package dev.whyoleg.ktd.json

import java.io.*

internal enum class NativeTarget(val lib: String, val ext: String) {
    Linux("libtdjni", "so"),
    MacOS("libtdjni", "dylib"),
    Win86("tdjni", "dll"),
    Win64("tdjni", "dll"),
    Android("libtdjni", "so");

    companion object {
        fun current(): NativeTarget {
            val os = System.getProperty("os.name")!!
            val arch = System.getProperty("os.arch")!!
            val vendor = System.getProperty("java.vendor")!!
            println("Current target: [os=$os, arch=$arch, vendor=$vendor]")
            return target(os, arch, vendor)
        }

        fun target(os: String, arch: String, vendor: String): NativeTarget = when {
            vendor.contains("android", true) -> Android
            os.contains("linux", true)       -> Linux
            os.contains("mac", true)         -> MacOS
            os.contains("windows", true)     -> if ("64" in arch) Win64 else Win86
            else                             -> error("Target [os=$os, arch=$arch, vendor=$vendor] is not supported")
        }
    }
}

internal val NativeTarget.libPath: String get() = "libs/${name.toLowerCase()}/${lib}.${ext}"

internal fun loadTdLib() {
    val target = NativeTarget.current()
    println("Try to load TdLib")
    val result = if (target == NativeTarget.Android) runCatching {
        System.loadLibrary("tdjni")
    } else runCatching {
        val lib = NativeTarget::class.java.getResourceAsStream("/" + target.libPath)
        val file = File.createTempFile(target.lib, ".${target.ext}")
        file.deleteOnExit()

        lib.use { libStream ->
            file.outputStream().use { fileStream ->
                libStream.copyTo(fileStream)
            }
        }
        System.load(file.absolutePath)
    }.recoverCatching {
        it.printStackTrace()
        val path = File(target.libPath).absolutePath
        println("Try to load TdLib from local path: $path")
        System.load(path)
    }

    result.onSuccess {
        println("TdLib loaded")
    }.onFailure {
        println("Can't load TdLib")
        throw it
    }
}
