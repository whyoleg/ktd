package dev.whyoleg.ktd.generator.tdlib

sealed class BuildTarget {
    sealed class Jvm : BuildTarget() {
        object Linux : Jvm()
        object MacOS : Jvm()

        sealed class Windows(val arch: String) : Jvm() {
            object X86 : Windows("Win32")
            object X64 : Windows("X64")
        }

        sealed class Android(val name: String, val ndkName: String, val toolChainName: String, val stripName: String) : Jvm() {
            object ArmV7 : Android("armeabi-v7a", "arm", "arm-linux-androideabi", "arm-linux-androideabi")
            object ArmV8 : Android("arm64-v8a", "arm64", "aarch64-linux-android", "aarch64-linux-android")
            object X86 : Android("x86", "x86", "x86", "i686-linux-android")
            object X64 : Android("x86_64", "x86_64", "x86_64", "x86_64-linux-android")
            companion object {
                val targets = listOf(ArmV7, ArmV8, X86, X64)
            }
        }
    }
}
