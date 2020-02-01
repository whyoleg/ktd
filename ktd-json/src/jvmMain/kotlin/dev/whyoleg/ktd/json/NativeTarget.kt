package dev.whyoleg.ktd.json

import java.io.*

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

internal val NativeTarget.libPath: String get() = "libs/${name.toLowerCase()}/${lib}.${ext}"

internal fun loadTdlib() {
    runCatching {
        println("Try to load tdlib as library")
        System.loadLibrary("tdjni")
    }.recoverCatching {
        it.printStackTrace()
        println("Try to load tdlib from artifact")
        val target = NativeTarget.current()

        val lib = NativeTarget::class.java.getResourceAsStream("/" + target.libPath)
        val file = File.createTempFile(target.lib, ".${target.ext}")

        lib.use { libStream ->
            file.outputStream().use { fileStream ->
                libStream.copyTo(fileStream)
            }
        }
        System.load(file.absolutePath)
    }.recoverCatching {
        it.printStackTrace()
        val path = File(NativeTarget.current().libPath).absolutePath
        println("Try to load tdlib from local path: $path")
        System.load(path)
    }.onFailure {
        println("Can't load tdlib")
        throw it
    }
}
