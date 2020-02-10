package dev.whyoleg.ktd.json

import java.io.*

internal enum class NativeTarget(val lib: String, val ext: String) {
    Linux("libtdjni", "so"),
    MacOS("libtdjni", "dylib"),
    Win86("tdjni", "dll"),
    Win64("tdjni", "dll");

    companion object {
        fun current(): NativeTarget {
            val os = System.getProperty("os.name")!!
            val arch = System.getProperty("os.arch")!!
            println("Current target: [os=$os, arch=$arch]")
            return target(os, arch)
        }

        fun target(os: String, arch: String): NativeTarget = when {
            os.contains("linux", true)   -> Linux
            os.contains("mac", true)     -> MacOS
            os.contains("windows", true) -> if ("64" in arch) Win64 else Win86
            else                         -> error("Target [os=$os, arch=$arch] is not supported")
        }
    }
}

internal val NativeTarget.libPath: String get() = "libs/${name.toLowerCase()}/${lib}.${ext}"

internal fun loadTdLib() {
    runCatching {
        println("Try to load TdLib as library")
        System.loadLibrary("tdjni")
    }.recoverCatching {
        it.printStackTrace() //android
        println("Try to load TdLib from artifact")
        val target = NativeTarget.current()

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
        val path = File(NativeTarget.current().libPath).absolutePath
        println("Try to load TdLib from local path: $path")
        System.load(path)
    }.onSuccess {
        println("TdLib loaded")
    }.onFailure {
        println("Can't load TdLib")
        throw it
    }
}
