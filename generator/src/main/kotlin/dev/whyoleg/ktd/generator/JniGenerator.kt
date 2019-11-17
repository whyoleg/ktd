package dev.whyoleg.ktd.generator

import eu.jrie.jetbrains.kotlinshell.shell.*
import org.kohsuke.github.*
import java.io.*

enum class Target { Linux, Win32, Win64, MacOS }

const val BUILD_TYPE = "MinSizeRel"
const val DCMAKE_BUILD_TYPE = "-DCMAKE_BUILD_TYPE=$BUILD_TYPE"
const val WINDOWS_BUILD_TYPE_CONFIG = " --config $BUILD_TYPE"

val linuxEnv = mapOf("CC" to "/usr/bin/clang-6.0", "CXX" to "/usr/bin/clang++-6.0")
val linuxConfig = listOf(
    DCMAKE_BUILD_TYPE,
    "-DCMAKE_AR=/usr/bin/llvm-ar-6.0",
    "-DCMAKE_NM=/usr/bin/llvm-nm-6.0",
    "-DCMAKE_OBJDUMP=/usr/bin/llvm-objdump-6.0",
    "-DCMAKE_RANLIB=/usr/bin/llvm-ranlib-6.0"
)
val macConfig = listOf(DCMAKE_BUILD_TYPE, "-DOPENSSL_ROOT_DIR=/usr/local/opt/openssl/")
val windowsBuildConfig = listOf(
    "-DCMAKE_TOOLCHAIN_FILE:FILEPATH=../../vcpkg/scripts/buildsystems/vcpkg.cmake",
    "-DGPERF_EXECUTABLE=../../gperf/gperf.exe"
)
val windowsLibConfig = listOf(
    "-DCMAKE_TOOLCHAIN_FILE:FILEPATH=../../../vcpkg/scripts/buildsystems/vcpkg.cmake",
    "-DGPERF_EXECUTABLE=../../../gperf/gperf.exe"
)

sealed class Step(val commands: List<String>) {
    class Build(path: String) : Step(listOf("-DCMAKE_INSTALL_PREFIX:PATH=../../$path/td", "-DTD_ENABLE_LTO=ON", "-DTD_ENABLE_JNI=ON"))
    class Lib(path: String) : Step(listOf("-DCMAKE_INSTALL_PREFIX:PATH=..", "-DTd_DIR=$path/td/lib/cmake/Td"))
}

suspend fun Shell.cmake(target: Target, step: Step) {
    val cmd = when (target) {
        Target.Linux -> linuxConfig
        Target.MacOS -> macConfig
        else         ->
            (if (step is Step.Build) windowsBuildConfig else windowsLibConfig) +
                    if (target == Target.Win32) "-A Win32" else "-A x64"
    }

    ("cmake ${cmd.joinToString(" ")} ${step.commands.joinToString(" ")} ..").invoke()
}

suspend fun Shell.install(target: Target) {
    val addition = if (target == Target.Win32 || target == Target.Win64) WINDOWS_BUILD_TYPE_CONFIG else ""
    "cmake --build . --target install$addition".invoke()
}

suspend fun build(target: Target, step: Step, dir: File) {
    dir.deleteRecursively()
    dir.mkdirs()
    println("Step: ${step::class.simpleName}")
    shell(dir = dir, env = if (target == Target.Linux) linuxEnv else null) {
        cmake(target, step)
        install(target)
    }
}

suspend fun main(vararg args: String) {
    val apiVersion = args.first().substringAfterLast("/")
    println("Start with tdlib $apiVersion")
    val os = System.getProperty("os.name").toLowerCase()
    val target = when {
        os.contains("linux")   -> Target.Linux
        os.contains("mac")     -> Target.MacOS
        os.contains("windows") -> if (args[1].contains("64")) Target.Win64 else Target.Win32
        else                   -> error("Target is not supported")
    }
    println("Start build $target")
    @Suppress("BlockingMethodInNonBlockingContext")
    val commitSha = GitHub.connectAnonymously().findCommit(apiVersion).shA1
    shell(dir = File("td")) { "git reset --hard $commitSha"() }

    val generatedPath = "generator/jni"
    val buildDir = File("td/build")
    val generatedDir = File(generatedPath)
    val generatedBuildDir = generatedDir.resolve("build")
    generatedDir.resolve("td").deleteRecursively()
    generatedDir.resolve("bin").deleteRecursively()

    println("Build dir: ${buildDir.absolutePath}")
    println("Generated dir: ${generatedDir.absolutePath}")
    println("Generated build dir: ${generatedBuildDir.absolutePath}")

    build(target, Step.Build(generatedPath), buildDir)
    build(target, Step.Lib(generatedDir.absolutePath), generatedBuildDir)

    val lib = generatedDir.resolve("bin").listFiles()!!.first { "tdjni" in it.name }
    val size = lib.readBytes().size

    println("Generated tdlib size: $size b")
    println("Generated tdlib size: ${size / 1024} kb")
    println("Generated tdlib size: ${size / 1024 / 1024} mb")

    lib.copyTo(generatedDir.resolve("libs/$apiVersion/${target.name.toLowerCase()}/${lib.name}"))
}
