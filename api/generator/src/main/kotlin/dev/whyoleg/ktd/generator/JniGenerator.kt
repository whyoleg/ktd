package dev.whyoleg.ktd.generator

import eu.jrie.jetbrains.kotlinshell.shell.*
import kotlinx.coroutines.*
import org.kohsuke.github.*
import java.io.*

const val DCMAKE_BUILD_TYPE = "MinSizeRel"
val env = mapOf("CC" to "/usr/bin/clang-6.0", "CXX" to "/usr/bin/clang++-6.0")

suspend fun Shell.cmake(step: Int, vararg commands: String) {
    val cmd = when (target) {
        Target.Linux -> listOf(
            "-DCMAKE_BUILD_TYPE=$DCMAKE_BUILD_TYPE",
            "-DCMAKE_AR=/usr/bin/llvm-ar-6.0",
            "-DCMAKE_NM=/usr/bin/llvm-nm-6.0",
            "-DCMAKE_OBJDUMP=/usr/bin/llvm-objdump-6.0",
            "-DCMAKE_RANLIB=/usr/bin/llvm-ranlib-6.0"
        )
        Target.Mac   -> listOf(
            "-DCMAKE_BUILD_TYPE=$DCMAKE_BUILD_TYPE",
            "-DOPENSSL_ROOT_DIR=/usr/local/opt/openssl/"
        )
        else         -> listOf(if (target == Target.Win32) "-A Win32" else "-A x64") +
                if (step == 0) listOf(
                    "-DCMAKE_TOOLCHAIN_FILE:FILEPATH=../../vcpkg/scripts/buildsystems/vcpkg.cmake",
                    "-DGPERF_EXECUTABLE=../../gperf-win/bin/gperf.exe"
                ) else listOf(
                    "-DCMAKE_TOOLCHAIN_FILE:FILEPATH=../../../vcpkg/scripts/buildsystems/vcpkg.cmake",
                    "-DGPERF_EXECUTABLE=../../../gperf-win/bin/gperf.exe"
                )
    }

    ("cmake ${cmd.joinToString(" ")} ${commands.joinToString(" ")} ..").invoke()
}

suspend fun Shell.install() {
    val addition = if (target == Target.Win32 || target == Target.Win64) " --config $DCMAKE_BUILD_TYPE" else ""
    "cmake --build . --target install$addition".invoke()
}

suspend fun build(step: Int, dir: File, vararg commands: String) {
    dir.deleteRecursively()
    dir.mkdirs()
    shell(dir = dir, env = if (target == Target.Linux) env else null) {
        cmake(step, *commands)
        install()
    }
}

enum class Target { Linux, Win32, Win64, Mac }

val target by lazy {
    val os = System.getProperty("os.name").toLowerCase()
    val target = when {
        os.contains("linux")   -> Target.Linux
        os.contains("mac")     -> Target.Mac
        os.contains("windows") -> if (System.getProperty("ARCH")?.toLowerCase()?.contains("32") == true) Target.Win32 else Target.Win64
        else                   -> error("Target is not supported")
    }
    println("Start build on $target")
    target
}

fun main(vararg args: String) {
    val apiVersion = args.first()
    System.setProperty("ARCH", args.getOrElse(1) { "64" })
    println("Start with: $apiVersion")
    System
        .getProperties()
        .toList()
        .sortedBy { it.first?.toString() }
        .forEach { (key, value) -> println("$key: $value") }
    val commitSha =
        GitHub
            .connectAnonymously()
            .also { println("Connected with: $it") }
            .findCommit(apiVersion)
            .shA1
    println("tdlib commit: $commitSha")
    runBlocking {
        delay(500)
        target

        println("Check chell")
        shell(dir = File("td")) {
            "echo 322"()
            "git reset --hard $commitSha"()
        }

        val generatedPath = "api/v$apiVersion/generated"
        val buildDir = File("td/build-v$apiVersion")
        val generatedDir = File(generatedPath)
        val generatedBuildDir = generatedDir.resolve("build")

        File("api/generator/jni").copyFilesTo(generatedDir, "td_jni.cpp", "CMakeLists.txt")

        println("Build dir: ${buildDir.absolutePath}")
        println("Generated dir: ${generatedDir.absolutePath}")
        println("Generated build dir: ${generatedBuildDir.absolutePath}")

        println("Build tdlib")
        build(
            0,
            buildDir,
            "-DCMAKE_INSTALL_PREFIX:PATH=../../$generatedPath/td",
            "-DTD_ENABLE_LTO=ON",
            "-DTD_ENABLE_JNI=ON"
        )
        println("Generate tdlib")
        build(
            1,
            generatedBuildDir,
            "-DTd_DIR=${generatedDir.absolutePath}/td/lib/cmake/Td",
            "-DCMAKE_INSTALL_PREFIX:PATH=.."
        )
        //    delay(2000)
        generatedDir.listFiles().orEmpty().forEach {
            println(it.absolutePath)
            if (!it.isFile) {
                println("START DIRECTORY")
                it.listFiles().orEmpty().forEach {
                    println(it.absolutePath)
                }
                println("END   DIRECTORY")
            }
        }
        val lib = generatedDir.resolve("bin").listFiles().orEmpty().first { "tdjni" in it.name }
        val size = lib.readBytes().size

        println("Generated tdlib size: $size b")
        println("Generated tdlib size: ${size / 1024} mb")

        //    generatedDir
        //        .resolve("bin")
        //        .copyFilesTo(File("api/v$apiVersion/src/main/libs/linux/amd64"), "libtdjni.so")
    }
}

fun File.copyFilesTo(path: File, vararg names: String) {
    names.forEach {
        val from = resolve(it)
        val to = path.resolve(it)
        println("Copy '$it' from ${from.absolutePath} to ${to.absolutePath}")
        if (to.exists()) to.delete()
        from.copyTo(to)
    }
}
