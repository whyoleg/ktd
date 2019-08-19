package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import mu.*

@PublishedApi
internal object Client {
    external fun createNativeClient(): Long
    external fun destroyNativeClient(nativeClientId: Long)
    external fun nativeClientExecute(function: TelegramFunction): TelegramObject
    external fun nativeClientSend(nativeClientId: Long, eventId: Long, function: TelegramFunction)
    external fun nativeClientReceive(nativeClientId: Long, eventIds: LongArray, events: Array<TelegramObject?>, timeout: Double): Int

    val nativeLogger = KotlinLogging.logger("TelegramNativeLogger")

    init {
        nativeLogger.info { "Start native with: ${System.getProperty("java.library.path")}" }
        runCatching { System.loadLibrary("tdjni") }.onFailure {
            nativeLogger.error(it) { "Can't load td library" }
            throw it
        }
        nativeClientExecute(TdApi.SetLogVerbosityLevel(0))
    }

}