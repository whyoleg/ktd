package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import java.io.*

object TdClient {

    external fun create(): Long
    external fun destroy(clientId: Long)

    external fun send(clientId: Long, eventId: Long, function: TelegramFunction)
    external fun receive(clientId: Long, eventIds: LongArray, events: Array<TelegramObject?>, timeout: Double): Int

    external fun execute(function: TelegramFunction): TelegramObject

    init {
        runCatching {
            val target = NativeTarget.current()
            val file = File.createTempFile(target.lib, ".${target.ext}")
            val path = "/${target.name.toLowerCase()}/${target.lib}.${target.ext}"
            TdClient::class.java.getResourceAsStream(path).copyTo(file.outputStream())
            System.load(file.absolutePath)
        }.recover {
            System.loadLibrary("tdjni") //if no lib in jar - find on local machine
        }.onFailure {
            println("Can't load td library")
            throw it
        }
    }
}
