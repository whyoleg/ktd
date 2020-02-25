package dev.whyoleg.ktd.cli.tdlib.jvm

import dev.whyoleg.ktd.cli.tdlib.*
import dev.whyoleg.ktd.cli.tdlib.cmake.*
import eu.jrie.jetbrains.kotlinshell.shell.*
import java.io.*

private val ninjaConfig = listOf("-GNinja", "-DCMAKE_MAKE_PROGRAM=ninja")

fun prop(cmd: String, file: File): String = "$cmd=${file.absolutePath}"

suspend fun JniConfig.buildJni(execution: CmakeExecution): CmakeExecutionResult {
    println("Prepare build folders")

    val buildDir = td.tdPath.resolve("build")
    val crossCompileDir = td.tdPath.resolve("crossCompile")

    val generatedDir = td.jniPath
    val generatedBuildDir = generatedDir.resolve("build")
    val installDir = generatedDir.resolve("td")
    val libDir = generatedDir.resolve("bin")

    listOf(buildDir, generatedBuildDir, installDir, libDir, crossCompileDir).forEach(File::deleteRecursively)
    listOf(buildDir, generatedBuildDir, crossCompileDir).forEach(File::mkdirs)

    println("Build dir:           ${buildDir.absolutePath}")
    println("Cross compile dir:   ${libDir.absolutePath}")
    println("Generated dir:       ${generatedDir.absolutePath}")
    println("Generated build dir: ${generatedBuildDir.absolutePath}")
    println("Install dir:         ${installDir.absolutePath}")
    println("Lib dir:             ${libDir.absolutePath}")

    val jniExecution = execution + CmakeExecution(
        crossCompile = null,
        build = CmakeConfig(
            configureParams = listOf(
                "-DCMAKE_INSTALL_PREFIX:PATH=${installDir.absolutePath}"
            )
        ),
        lib = CmakeConfig(
            configureParams = listOf(
                "-DCMAKE_INSTALL_PREFIX:PATH=..",
                "-DTd_DIR=${installDir.resolve("lib/cmake/Td").absolutePath}"
            )
        )
    )

    jniExecution.before()

    val cmake = Cmake(cmakePath)
    val (crossCompileConfiguration, crossCompileInstallation) =
        jniExecution.crossCompile?.let { cmake.run(crossCompileDir, it, "prepare_cross_compiling") } ?: null to null
    val (buildConfiguration, buildInstallation) = cmake.run(buildDir, jniExecution.build, "install")
    val (libConfiguration, libInstallation) = cmake.run(generatedBuildDir, jniExecution.lib, "install")

    val lib = libDir.listFiles { _, name -> "tdjni" in name }!!.first()

    val result = CmakeExecutionResult(
        crossCompileConfiguration,
        crossCompileInstallation,
        buildConfiguration,
        buildInstallation,
        libConfiguration,
        libInstallation,
        lib
    )

    jniExecution.after(result)

    return result
}

fun LinuxJniConfig.execution(buildType: TdBuildType): CmakeExecution {
    val config = CmakeConfig(
        env = mapOf(
            "CC" to clangPath.absolutePath,
            "CXX" to clangPlusPlusPath.absolutePath
        ),
        configureParams = ninjaConfig + listOf(
            buildType.dCmake(),
            prop("-DCMAKE_AR", llvmPath.resolve("llvm-ar-6.0")),
            prop("-DCMAKE_NM", llvmPath.resolve("llvm-nm-6.0")),
            prop("-DCMAKE_OBJDUMP", llvmPath.resolve("llvm-objdump-6.0")),
            prop("-DCMAKE_RANLIB", llvmPath.resolve("llvm-ranlib-6.0"))
        )
    )
    return CmakeExecution(null, config, config)
}

fun MacosJniConfig.execution(buildType: TdBuildType): CmakeExecution = CmakeExecution(
    crossCompile = null,
    build = CmakeConfig(
        configureParams = ninjaConfig + listOf(
            buildType.dCmake(),
            prop("-DOPENSSL_ROOT_DIR", opensslPath)
        )
    ),
    lib = CmakeConfig(configureParams = ninjaConfig + listOf(buildType.dCmake()))
)

fun WindowsJniConfig.execution(buildType: TdBuildType, target: BuildTarget.Windows): CmakeExecution {
    val config = CmakeConfig(
        configureParams = listOf(
            prop("-DCMAKE_TOOLCHAIN_FILE:FILEPATH", vcpkgPath.resolve("scripts/buildsystems/vcpkg.cmake")),
            prop("-DGPERF_EXECUTABLE", gperfPath.resolve("gperf.exe")),
            "-A ${target.arch}"
        ),
        installParams = listOf(buildType.windowsCmake())
    )
    return CmakeExecution(null, config, config)
}

fun AndroidJniConfig.execution(buildType: TdBuildType, target: BuildTarget.Android, linuxConfig: LinuxJniConfig?): CmakeExecution {
    val commonConfig = CmakeConfig(
        configureParams = ninjaConfig + listOf(
            buildType.dCmake(),
            prop("-DANDROID_NDK", ndkPath),
            prop("-DCMAKE_TOOLCHAIN_FILE", ndkPath.resolve("build/cmake/android.toolchain.cmake")),
            "-DANDROID_ABI=${target.archName}",
            "-DANDROID_NATIVE_API_LEVEL=$apiLevel",
            "-DANDROID_TOOLCHAIN=clang",
            "-DANDROID_STL=c++_static"
        )
    )
    val opensslTargetPath = opensslPath.resolve(target.archName)
    val jdkLibPath = jdkPath.resolve("lib")
    val jdkIncludePath = jdkPath.resolve("include")

    return CmakeExecution(
        crossCompile = linuxConfig?.execution(buildType)?.build ?: CmakeConfig(),
        build = commonConfig + CmakeConfig(
            configureParams = listOf(
                prop("-DOPENSSL_ROOT_DIR", opensslTargetPath),
                prop("-DOPENSSL_INCLUDE_DIR", opensslTargetPath),
                prop("-DOPENSSL_CRYPTO_LIBRARY", opensslTargetPath.resolve("libcrypto.a")),
                prop("-DOPENSSL_SSL_LIBRARY", opensslTargetPath.resolve("libssl.a"))
            )
        ),
        lib = commonConfig + CmakeConfig(
            configureParams = listOf(
                prop("-DJAVA_AWT_LIBRARY", jdkLibPath),
                prop("-DJAVA_JVM_LIBRARY", jdkLibPath),
                prop("-DJAVA_INCLUDE_PATH2", jdkIncludePath.resolve("linux")),
                prop("-DJAVA_AWT_INCLUDE_PATH", jdkIncludePath)
            )
        ),
        after = {
            val strip =
                ndkPath
                    .resolve("toolchains/${target.toolChainName}-4.9/prebuilt/linux-x86_64/${target.stripName}/bin/strip")
                    .absolutePath
            shell(dir = lib.parentFile) {
                "$strip -s -v ${lib.name}"()
            }
        }
    )
}
