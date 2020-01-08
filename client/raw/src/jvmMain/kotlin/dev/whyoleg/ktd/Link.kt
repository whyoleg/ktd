package dev.whyoleg.ktd

import java.io.*

actual fun loadTdlib() {
    runCatching {
        System.loadLibrary("tdjni")
    }.recover {
        val target = NativeTarget.current()
        val file = File.createTempFile(target.lib, ".${target.ext}")
        val path = "libs/${target.name.toLowerCase()}/${target.lib}.${target.ext}"
        TelegramRawClient::class.java.getResourceAsStream(path)!!.copyTo(file.outputStream())
        System.load(file.absolutePath)
    }.onFailure {
        println("Can't load tdlib")
        throw it
    }
}
