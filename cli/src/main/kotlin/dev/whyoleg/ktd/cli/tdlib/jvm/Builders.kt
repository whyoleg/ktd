package dev.whyoleg.ktd.cli.tdlib.jvm

import dev.whyoleg.ktd.cli.tdlib.*
import eu.jrie.jetbrains.kotlinshell.shell.*
import java.io.*

const val BUILD_TYPE = "MinSizeRel"
const val DCMAKE_BUILD_TYPE = "-DCMAKE_BUILD_TYPE=$BUILD_TYPE"
const val WINDOWS_BUILD_TYPE_CONFIG = " --config $BUILD_TYPE"

fun prop(cmd: String, file: File): String = "$cmd=${file.absolutePath}"

suspend fun buildJni(execution: CmakeExecution): CmakeExecutionResult {
    println("Prepare build folders")

    val buildDir = File("td/build")
    val generatedDir = File("config/tdlib/jni")
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
                "-GNinja",
                "-DCMAKE_MAKE_PROGRAM=ninja",
                "-DTD_ENABLE_JNI=ON",
                "-DCMAKE_INSTALL_PREFIX:PATH=${installDir.absolutePath}"
            )
        ),
        lib = CmakeConfig(
            configureParams = listOf(
                "-GNinja",
                "-DCMAKE_MAKE_PROGRAM=ninja",
                "-DCMAKE_INSTALL_PREFIX:PATH=..",
                "-DTd_DIR=${installDir.resolve("lib/cmake/Td").absolutePath}"
            )
        )
    )

    val cmake = Cmake("cmake")
    val (buildConfiguration, buildInstallation) = cmake.run(buildDir, jniExecution.build)
    val (libConfiguration, libInstallation) = cmake.run(generatedBuildDir, jniExecution.lib)

    val lib = libDir.listFiles { _, name -> "tdjni" in name }!!.first()

    println("Generated tdlib size: ${lib.mbSize()} mb")

    return CmakeExecutionResult(buildConfiguration, buildInstallation, libConfiguration, libInstallation, lib)
}

suspend fun buildLinuxJni(
    llvmRootPath: File = File("/usr/bin"),
    clangPath: File = File("/usr/bin/clang-6.0"),
    clangPlusPath: File = File("/usr/bin/clang++-6.0")
): CmakeExecutionResult = buildJni(
    CmakeExecution(
        CmakeConfig(
            env = mapOf(
                "CC" to clangPath.absolutePath,
                "CXX" to clangPlusPath.absolutePath
            ),
            configureParams = listOf(
                DCMAKE_BUILD_TYPE,
                prop("-DCMAKE_AR", llvmRootPath.resolve("llvm-ar-6.0")),
                prop("-DCMAKE_NM", llvmRootPath.resolve("llvm-nm-6.0")),
                prop("-DCMAKE_OBJDUMP", llvmRootPath.resolve("llvm-objdump-6.0")),
                prop("-DCMAKE_RANLIB", llvmRootPath.resolve("llvm-ranlib-6.0"))
            )
        )
    )
)

suspend fun buildMacOSJni(
    opensslRootPath: File = File("/usr/local/opt/openssl")
): CmakeExecutionResult = buildJni(
    CmakeExecution(
        build = CmakeConfig(configureParams = listOf(DCMAKE_BUILD_TYPE, prop("-DOPENSSL_ROOT_DIR", opensslRootPath))),
        lib = CmakeConfig(configureParams = listOf(DCMAKE_BUILD_TYPE))
    )
)

suspend fun buildWindowsJni(
    target: BuildTarget.Windows,
    vcpkgPath: File = File(""),
    gperfPath: File = File("")
): CmakeExecutionResult = buildJni(
    CmakeExecution(
        CmakeConfig(
            configureParams = listOf(
                prop("-DCMAKE_TOOLCHAIN_FILE:FILEPATH", vcpkgPath.resolve("scripts/buildsystems/vcpkg.cmake")),
                prop("-DGPERF_EXECUTABLE", gperfPath.resolve("gperf.exe")),
                "-A ${target.arch}"
            ),
            installParams = listOf(WINDOWS_BUILD_TYPE_CONFIG)
        )
    )
)

suspend fun buildAndroid(
    androidSdkPath: File,
    opensslPath: File,
    target: BuildTarget.Android,
    api: Int = 21,
    jdkPath: File = File("/usr/lib/jvm/java-8-openjdk-amd64"),
    ndkVersion: String = "21.0.5935234" //20.0.5594570
): CmakeExecutionResult {
    val ndkPath = androidSdkPath.resolve("ndk/$ndkVersion")
    val ndkLibsPath = ndkPath.resolve("platforms/android-$api/arch-${target.ndkName}/usr/lib")

    val config = CmakeConfig(
        configureParams = listOf(
            DCMAKE_BUILD_TYPE,
            prop("-DANDROID_NDK", ndkPath),
            prop("-DCMAKE_TOOLCHAIN_FILE", ndkPath.resolve("build/cmake/android.toolchain.cmake")),
            "-DANDROID_ABI=${target.archName}",
            "-DANDROID_NATIVE_API_LEVEL=$api",
            "-DANDROID_TOOLCHAIN=clang",
            "-DANDROID_STL=c++_static"
        )
    )

    ndkLibsPath.resolve("openssl").deleteRecursively()
    File("$opensslPath/${target.archName}").copyRecursively(ndkLibsPath, overwrite = true)

    val result = buildJni(
        CmakeExecution(
            build = config.copy(
                configureParams = config.configureParams + listOf(
                    prop("-DOPENSSL_ROOT_DIR", ndkLibsPath),
                    prop("-DOPENSSL_INCLUDE_DIR", ndkLibsPath)
                )
            ),
            lib = config.copy(
                configureParams = config.configureParams + listOf(
                    prop("-DJAVA_AWT_LIBRARY", jdkPath.resolve("jre/lib/amd64")),
                    prop("-DJAVA_JVM_LIBRARY", jdkPath.resolve("jre/lib/amd64")),
                    prop("-DJAVA_INCLUDE_PATH2", jdkPath.resolve("include/linux")),
                    prop("-DJAVA_AWT_INCLUDE_PATH", jdkPath.resolve("include"))
                )
            )
        )
    )

    val strip = ndkPath.resolve("toolchains/${target.toolChainName}-4.9/prebuilt/linux-x86_64/${target.stripName}/bin/strip").absolutePath
    shell(dir = result.lib.parentFile) {
        "$strip -s -v ${result.lib.name}".invoke()
    }

    println("Stripped tdlib size: ${result.lib.mbSize()} mb")
    return result
}
