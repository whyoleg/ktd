package dev.whyoleg.ktd

import java.io.*

internal actual fun loadTdlib() {
    runCatching {
        println("Try to load tdlib as library")
        System.loadLibrary("tdjni")
    }.recoverCatching {
        it.printStackTrace()
        println("Try to load tdlib from artifact")
        val target = NativeTarget.current()

        val lib = TelegramRawClient::class.java.getResourceAsStream("/" + target.libPath())
        val file = File.createTempFile(target.lib, ".${target.ext}")

        lib.use { libStream ->
            file.outputStream().use { fileStream ->
                libStream.copyTo(fileStream)
            }
        }
        System.load(file.absolutePath)
    }.recoverCatching {
        it.printStackTrace()
        val path = File(NativeTarget.current().libPath()).absolutePath
        println("Try to load tdlib from local path: $path")
        System.load(path)
    }.onFailure {
        println("Can't load tdlib")
        throw it
    }
}
