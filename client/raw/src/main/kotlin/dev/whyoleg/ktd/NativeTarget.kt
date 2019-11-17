package dev.whyoleg.ktd

enum class NativeTarget(val lib: String, val ext: String) {
    Linux("libtdjni", "so"),
    MacOS("libtdjni", "dylib"),
    Win32("tdjni", "dll"),
    Win64("tdjni", "dll");

    companion object {
        fun current(): NativeTarget {
            val os = System.getProperty("os.name").toLowerCase()
            return when {
                "linux" in os   -> Linux
                "mac" in os     -> MacOS
                "windows" in os -> if (System.getProperty("os.arch").contains("64")) Win64 else Win32
                else            -> error("Target is not supported")
            }
        }
    }
}