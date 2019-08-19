package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import mu.*
import java.io.*

@PublishedApi
internal object Client {
    external fun createNativeClient(): Long
    external fun destroyNativeClient(nativeClientId: Long)
    external fun nativeClientExecute(function: TelegramFunction): TelegramObject
    external fun nativeClientSend(nativeClientId: Long, eventId: Long, function: TelegramFunction)
    external fun nativeClientReceive(nativeClientId: Long, eventIds: LongArray, events: Array<TelegramObject?>, timeout: Double): Int

    val nativeLogger = KotlinLogging.logger("TelegramNativeLogger")

    init {
        runCatching {
            val file = File.createTempFile("libtdjni", ".so")
            Client::class.java.getResourceAsStream("/linux/amd64/libtdjni.so").copyTo(file.outputStream())
            System.load(file.absolutePath)
        }.onFailure {
            nativeLogger.error(it) { "Can't load td library" }
            throw it
        }
        nativeClientExecute(TdApi.SetLogVerbosityLevel(0))
    }

}