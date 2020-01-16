package dev.whyoleg.ktd

internal enum class NativeTarget(val lib: String, val ext: String) {
    Linux("libtdjni", "so"),
    MacOS("libtdjni", "dylib"),
    Win86("tdjni", "dll"),
    Win64("tdjni", "dll");

    companion object {
        fun current(): NativeTarget = target(System.getProperty("os.name")!!, System.getProperty("os.arch")!!)

        fun target(os: String, arch: String): NativeTarget = when {
            os.contains("linux", true)   -> Linux
            os.contains("mac", true)     -> MacOS
            os.contains("windows", true) -> if ("64" in arch) Win64 else Win86
            else                         -> error("Target is not supported")
        }
    }
}

internal fun NativeTarget.libPath(): String = "libs/${name.toLowerCase()}/${lib}.${ext}"