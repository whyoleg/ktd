package dev.whyoleg.ktd.cli.tdlib.jvm

import dev.whyoleg.ktd.cli.tdlib.*
import eu.jrie.jetbrains.kotlinshell.shell.*
import java.io.*

private val ninjaConfig = listOf("-GNinja", "-DCMAKE_MAKE_PROGRAM=ninja")

fun prop(cmd: String, file: File): String = "$cmd=${file.absolutePath}"

suspend fun JniConfig.buildJni(execution: CmakeExecution): CmakeExecutionResult {
    println("Prepare build folders")

    val buildDir = td.buildPath
    val generatedDir = td.jniPath
    val generatedBuildDir = generatedDir.resolve("build")
    val installDir = generatedDir.resolve("td")
    val libDir = generatedDir.resolve("bin")

    listOf(buildDir, generatedBuildDir, installDir, libDir).forEach(File::deleteRecursively)
    listOf(buildDir, generatedBuildDir).forEach(File::mkdirs)

    println("Build dir:           ${buildDir.absolutePath}")
    println("Generated dir:       ${generatedDir.absolutePath}")
    println("Generated build dir: ${generatedBuildDir.absolutePath}")
    println("Install dir:         ${installDir.absolutePath}")
    println("Lib dir:             ${libDir.absolutePath}")

    val jniExecution = execution + CmakeExecution(
        build = CmakeConfig(
            configureParams = listOf(
                "-DTD_ENABLE_JNI=ON",
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
    val (buildConfiguration, buildInstallation) = cmake.run(buildDir, jniExecution.build)
    val (libConfiguration, libInstallation) = cmake.run(generatedBuildDir, jniExecution.lib)

    val lib = libDir.listFiles { _, name -> "tdjni" in name }!!.first()

    val result = CmakeExecutionResult(buildConfiguration, buildInstallation, libConfiguration, libInstallation, lib)

    jniExecution.after(result)

    println("Generated tdlib size: ${lib.mbSize()} mb")
    return result
}

fun LinuxJniConfig.execution(buildType: TdBuildType): CmakeExecution = CmakeExecution(
    CmakeConfig(
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
)

fun MacosJniConfig.execution(buildType: TdBuildType): CmakeExecution = CmakeExecution(
    build = CmakeConfig(configureParams = ninjaConfig + listOf(buildType.dCmake(), prop("-DOPENSSL_ROOT_DIR", opensslPath))),
    lib = CmakeConfig(configureParams = ninjaConfig + listOf(buildType.dCmake()))
)

fun WindowsJniConfig.execution(buildType: TdBuildType, target: BuildTarget.Windows): CmakeExecution = CmakeExecution(
    CmakeConfig(
        configureParams = listOf(
            prop("-DCMAKE_TOOLCHAIN_FILE:FILEPATH", vcpkgPath.resolve("scripts/buildsystems/vcpkg.cmake")),
            prop("-DGPERF_EXECUTABLE", gperfPath.resolve("gperf.exe")),
            "-A ${target.arch}"
        ),
        installParams = listOf(buildType.windowsCmake())
    )
)

fun AndroidJniConfig.execution(buildType: TdBuildType, target: BuildTarget.Android): CmakeExecution {
    val ndkPath = if (ndkVersion != null) androidSdkPath.resolve("../ndk/$ndkVersion") else androidSdkPath.resolve("ndk-bundle")
    val ndkLibsPath = ndkPath.resolve("platforms/android-$apiLevel/arch-${target.ndkName}/usr/lib")
    val opensslTargetPath = opensslPath.resolve(target.archName)
    val commonExecution = CmakeExecution(
        config = CmakeConfig(
            configureParams = ninjaConfig + listOf(
                buildType.dCmake(),
                prop("-DANDROID_NDK", ndkPath),
                prop("-DCMAKE_TOOLCHAIN_FILE", ndkPath.resolve("build/cmake/android.toolchain.cmake")),
                "-DANDROID_ABI=${target.archName}",
                "-DANDROID_NATIVE_API_LEVEL=$apiLevel",
                "-DANDROID_TOOLCHAIN=clang",
                "-DANDROID_STL=c++_static"
            )
        ),
        before = {
            //            runCatching {
            ndkLibsPath.resolve("openssl").deleteRecursively()
            opensslTargetPath.copyRecursively(ndkLibsPath, overwrite = true)
//            }.also(::println)
//            ndkLibsPath.copyRecursively(opensslTargetPath, overwrite = true)

//            opensslTargetPath.listFiles()?.forEach {
//                println("FOLDER!!!${it.absolutePath}")
//                it.listFiles()?.forEach {
//                    println("SUBFOLDER!!!${it.absolutePath}")
//                }
//            }
        },
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

    val customExecution = CmakeExecution(
        build = CmakeConfig(
            configureParams = listOf(
                prop("-DOPENSSL_ROOT_DIR", ndkLibsPath),
                prop("-DOPENSSL_INCLUDE_DIR", ndkLibsPath)
            )
        ),
        lib = CmakeConfig(
            configureParams = listOf(
                prop("-DJAVA_AWT_LIBRARY", jdkPath.resolve("jre/lib/amd64")),
                prop("-DJAVA_JVM_LIBRARY", jdkPath.resolve("jre/lib/amd64")),
                prop("-DJAVA_INCLUDE_PATH2", jdkPath.resolve("include/linux")),
                prop("-DJAVA_AWT_INCLUDE_PATH", jdkPath.resolve("include"))
            )
        )
    )

    return commonExecution + customExecution
}
