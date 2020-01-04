package dev.whyoleg.ktd

import java.io.*

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

internal fun link() {
    runCatching {
        System.loadLibrary("tdjni")
    }.recover {
        val target = NativeTarget.current()
        val file = File.createTempFile(target.lib, ".${target.ext}")
        val path = "libs/${target.name.toLowerCase()}/${target.lib}.${target.ext}"
        TelegramRawClient::class.java.getResourceAsStream(path).copyTo(file.outputStream())
        System.load(file.absolutePath)
    }.onFailure {
        println("Can't load tdlib")
        throw it
    }
}
