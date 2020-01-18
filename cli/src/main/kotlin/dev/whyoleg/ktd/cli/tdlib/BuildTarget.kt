package dev.whyoleg.ktd.cli.tdlib

enum class BuildPlatform(val targets: List<BuildTarget>) {
    Jvm(listOf(BuildTarget.Linux, BuildTarget.MacOS) + BuildTarget.Windows.values() + BuildTarget.Android.values()),
    Js(emptyList()),
    Native(emptyList())
}

interface BuildTarget {
    val targetName: String

    object Linux : BuildTarget {
        override val targetName: String = "linux"
        override fun toString(): String = targetName
    }

    object MacOS : BuildTarget {
        override val targetName: String = "mac"
        override fun toString(): String = targetName
    }

    enum class Windows(val arch: String) : BuildTarget {
        X86("Win32"),
        X64("X64");

        override val targetName: String = "win-$name"
        override fun toString(): String = targetName
    }

    enum class Android(val archName: String, val toolChainName: String, val stripName: String) : BuildTarget {
        ArmV7("armeabi-v7a", "arm-linux-androideabi", "arm-linux-androideabi"),
        ArmV8("arm64-v8a", "aarch64-linux-android", "aarch64-linux-android"),
        X86("x86", "x86", "i686-linux-android"),
        X64("x86_64", "x86_64", "x86_64-linux-android");

        override val targetName: String = "android-$name"
        override fun toString(): String = targetName
    }
}
