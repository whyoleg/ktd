package dev.whyoleg.ktd

enum class NativeTarget(val lib: String, val ext: String) {
    Linux("libtdjni", "so"),
    MacOS("libtdjni", "dylib"),
    Win32("tdjni", "dll"),
    Win64("tdjni", "dll");

    companion object {
        fun current(): NativeTarget = target(System.getProperty("os.name"), System.getProperty("os.arch"))
        internal fun target(os: String, arch: String): NativeTarget {
            val osLowerCase = os.toLowerCase()
            return when {
                "linux" in osLowerCase   -> Linux
                "mac" in osLowerCase     -> MacOS
                "windows" in osLowerCase -> if ("64" in arch.toLowerCase()) Win64 else Win32
                else                     -> error("Target is not supported")
            }
        }
    }
}