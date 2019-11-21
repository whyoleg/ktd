package dev.whyoleg.ktd.generator.tdlib.jvm

import dev.whyoleg.ktd.generator.tdlib.*
import eu.jrie.jetbrains.kotlinshell.shell.*
import java.io.*

const val BUILD_TYPE = "MinSizeRel"
const val DCMAKE_BUILD_TYPE = "-DCMAKE_BUILD_TYPE=$BUILD_TYPE"
const val WINDOWS_BUILD_TYPE_CONFIG = " --config $BUILD_TYPE"

//-DTD_ENABLE_LTO=ON
suspend fun buildJni(execution: CmakeExecution, cmake: Cmake = Cmake("cmake")): CmakeExecutionResult {
    println("Prepare build folders")

    val buildDir = File("td/build")
    val generatedDir = File("generator/jni")
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

    val (buildConfiguration, buildInstallation) = cmake.run(buildDir, jniExecution.build)
    val (libConfiguration, libInstallation) = cmake.run(generatedBuildDir, jniExecution.lib)

    val lib = libDir.listFiles { _, name -> "tdjni" in name }!!.first()

    println("Generated tdlib size: ${lib.mbSize()} mb")

    return CmakeExecutionResult(buildConfiguration, buildInstallation, libConfiguration, libInstallation, lib)
}

suspend fun buildLinux(
    llvmRootPath: String = "/usr/bin",
    clangPath: String = "/usr/bin/clang-6.0",
    clangPlusPath: String = "/usr/bin/clang++-6.0"
): CmakeExecutionResult = buildJni(
    CmakeExecution(
        CmakeConfig(
            env = mapOf(
                "CC" to clangPath,
                "CXX" to clangPlusPath
            ),
            configureParams = listOf(
                DCMAKE_BUILD_TYPE,
                "-DCMAKE_AR=$llvmRootPath/llvm-ar-6.0",
                "-DCMAKE_NM=$llvmRootPath/llvm-nm-6.0",
                "-DCMAKE_OBJDUMP=$llvmRootPath/llvm-objdump-6.0",
                "-DCMAKE_RANLIB=$llvmRootPath/llvm-ranlib-6.0"
            )
        )
    )
)

suspend fun buildMacOS(opensslRootPath: String = "/usr/local/opt/openssl"): CmakeExecutionResult = buildJni(
    CmakeExecution(
        build = CmakeConfig(configureParams = listOf(DCMAKE_BUILD_TYPE, "-DOPENSSL_ROOT_DIR=$opensslRootPath")),
        lib = CmakeConfig(configureParams = listOf(DCMAKE_BUILD_TYPE))
    )
)

suspend fun buildWindows(
    target: BuildTarget.Jvm.Windows,
    vcpkgPath: String = File("").absolutePath,
    gperfPath: String = File("").absolutePath
): CmakeExecutionResult = buildJni(
    CmakeExecution(
        CmakeConfig(
            configureParams = listOf(
                "-DCMAKE_TOOLCHAIN_FILE:FILEPATH=$vcpkgPath/scripts/buildsystems/vcpkg.cmake",
                "-DGPERF_EXECUTABLE=$gperfPath/gperf.exe",
                "-A ${target.arch}"
            ),
            installParams = listOf(WINDOWS_BUILD_TYPE_CONFIG)
        )
    )
)

suspend fun buildAndroid(
    androidSdkPath: String,
    opensslPath: String,
    target: BuildTarget.Jvm.Android,
    api: Int = 21,
    javaPath: String = "/usr/lib/jvm/java-8-openjdk-amd64",
    cmakeVersion: String = "3.10.2.4988404", //3.6.4111459
    ndkVersion: String = "21.0.5935234" //20.0.5594570
): CmakeExecutionResult {
    val cmakePath = "$androidSdkPath/cmake/$cmakeVersion/bin"
    val ndkPath = "$androidSdkPath/ndk/$ndkVersion"
    val ndkLibsPath = "$ndkPath/platforms/android-$api/arch-${target.ndkName}/usr/lib"

    val config = CmakeConfig(
        configureParams = listOf(
            DCMAKE_BUILD_TYPE,
            "-GNinja",
            "-DCMAKE_MAKE_PROGRAM=$cmakePath/ninja",
            "-DANDROID_NDK=$ndkPath",
            "-DCMAKE_TOOLCHAIN_FILE=$ndkPath/build/cmake/android.toolchain.cmake",
            "-DANDROID_ABI=${target.name}",
            "-DANDROID_NATIVE_API_LEVEL=$api",
            "-DANDROID_TOOLCHAIN=clang",
            "-DANDROID_STL=c++_static"
        )
    )

    File("$ndkLibsPath/openssl").deleteRecursively()
    File("$opensslPath/${target.name}").copyRecursively(File(ndkLibsPath), overwrite = true)

    val result = buildJni(
        CmakeExecution(
            build = config.copy(
                configureParams = config.configureParams + listOf(
                    "-DOPENSSL_ROOT_DIR=$ndkLibsPath",
                    "-DOPENSSL_INCLUDE_DIR=$ndkLibsPath"
                )
            ),
            lib = config.copy(
                configureParams = config.configureParams + listOf(
                    "-DJAVA_AWT_LIBRARY=$javaPath/jre/lib/amd64",
                    "-DJAVA_JVM_LIBRARY=$javaPath/jre/lib/amd64",
                    "-DJAVA_INCLUDE_PATH2=$javaPath/include/linux",
                    "-DJAVA_AWT_INCLUDE_PATH=$javaPath/include"
                )
            )
        ),
        Cmake("$cmakePath/cmake")
    )
    shell(dir = result.lib.parentFile) {
        "$ndkPath/toolchains/${target.toolChainName}-4.9/prebuilt/linux-x86_64/${target.stripName}/bin/strip -s -v ${result.lib.name}".invoke()
    }
    println("Stripped tdlib size: ${result.lib.mbSize()} mb")
    return result
}
