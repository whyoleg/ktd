package dev.whyoleg.ktd.generator

import eu.jrie.jetbrains.kotlinshell.shell.*
import org.kohsuke.github.*
import java.io.*

const val DCMAKE_BUILD_TYPE = "MinSizeRel"

suspend fun Shell.cmake(vararg commands: String) =
    ("cmake " +
            "-DCMAKE_BUILD_TYPE=$DCMAKE_BUILD_TYPE " +
            "-DCMAKE_AR=/usr/bin/llvm-ar-6.0 " +
            "-DCMAKE_NM=/usr/bin/llvm-nm-6.0 " +
            "-DCMAKE_OBJDUMP=/usr/bin/llvm-objdump-6.0 " +
            "-DCMAKE_RANLIB=/usr/bin/llvm-ranlib-6.0 " +
            commands.joinToString(" ") +
            " ..")()

suspend fun Shell.install() = "cmake --build . --target install"()

//suspend fun Call.log() {
//    output().collect {
//        if (it is Output.Line) println(it.data)
//        else println(it)
//    }
//}

suspend fun main(vararg args: String) {
    val apiVersion = args.firstOrNull() ?: "1.5.0"

    val commitSha = GitHub.connectAnonymously().findCommit(apiVersion).shA1
    shell(dir = File("td")) {
        "echo 123"()
        println("Reset td to commit")
        "git reset --hard $commitSha"()
        println("td reseted")
    }

    val buildPath = "td/build-v$apiVersion"
    val generatedPath = "api/v$apiVersion/generated"
    val buildDir = File(buildPath)
    println("Build dir: ${buildDir.absolutePath}")
    buildDir.mkdirs()
    shell(dir = buildDir, env = mapOf("CC" to "/usr/bin/clang-6.0", "CXX" to "/usr/bin/clang++-6.0")) {
        cmake(
            "-DCMAKE_INSTALL_PREFIX:PATH=../../$generatedPath/td",
            "-DTD_ENABLE_LTO=ON",
            "-DTD_ENABLE_JNI=ON"
        )
        install()
    }
    val generatedDir = File(generatedPath)
    val generatedBuildDir = generatedDir.resolve("build")
    println("Generated dir: ${generatedDir.absolutePath}")
    println("Generated build dir: ${generatedBuildDir.absolutePath}")
    generatedBuildDir.mkdirs()
    with(File("api/generator/jni")) {
        listOf("td_jni.cpp", "CMakeLists.txt").forEach {
            print("Copy '$it'")
            resolve(it).also { print(" from ${it.absolutePath}") }
                .copyTo(generatedDir.resolve(it).also { println(" to ${it.absolutePath}") })
        }
    }
    shell(dir = generatedBuildDir, env = mapOf("CC" to "/usr/bin/clang-6.0", "CXX" to "/usr/bin/clang++-6.0")) {
        cmake(
            "-DTd_DIR=${generatedDir.absolutePath}/td/lib/cmake/Td",
            "-DCMAKE_INSTALL_PREFIX:PATH=.."
        )
        install()
    }
    generatedDir
        .resolve("bin")
        .copyFileTo("libtdjni.so", File("api/v$apiVersion/src/main/libs/linux/amd64"))
}

fun File.copyFileTo(name: String, path: File) {
    resolve(name).copyTo(path.resolve(name))
}