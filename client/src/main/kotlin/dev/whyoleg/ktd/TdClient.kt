package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import java.io.*

internal object TdClient {

    external fun create(): Long
    external fun destroy(clientId: Long)

    external fun send(clientId: Long, eventId: Long, function: TelegramFunction)
    external fun receive(clientId: Long, eventIds: LongArray, events: Array<TelegramObject?>, timeout: Double): Int

    external fun execute(function: TelegramFunction): TelegramObject

    init {
        runCatching {
            val file = File.createTempFile("libtdjni", ".so")
            TdClient::class.java.getResourceAsStream("/linux/amd64/libtdjni.so").copyTo(file.outputStream())
            System.load(file.absolutePath)
        }.recover {
            System.loadLibrary("tdjni") //if no lib in jar - find on local machine
        }.onFailure {
            println("Can't load td library")
            throw it
        }
    }
}
