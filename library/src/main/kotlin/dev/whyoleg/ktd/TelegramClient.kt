package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.sync.*
import mu.*

class TelegramClient internal constructor(configuration: TelegramClientConfiguration, parent: Job) : Job by Job(parent) {
    private val mutex = Mutex()
    private val nativeClient = NativeClient(configuration)
    private val eventHandlers = mutableMapOf<Long, CompletableDeferred<TelegramObject>>()
    private val updatesCache = UnlimitedCacheChannel<TelegramUpdate>(this)
    public val updates: Flow<TelegramUpdate> = updatesCache.flow

    init {
        invokeOnCompletion {
            logger.debug(it) { "Telegram client stopped" }
            nativeClient.destroy()
        }
    }

    public fun send(function: TelegramFunction) {
        sendInternal(function)
    }

    private fun sendInternal(function: TelegramFunction): Long = nativeClient.send(function)

    suspend fun exec(function: TelegramFunction): TelegramObject {
        val deferred = CompletableDeferred<TelegramObject>(this)
        val eventId = mutex.withLock {
            val eventId = sendInternal(function)
            eventHandlers[eventId] = deferred
            eventId
        }
        val result = deferred.runCatching { await() }
        eventHandlers -= eventId

        return when (val value = result.getOrThrow()) {
            is TdApi.Error -> {
                logger.error { "Error($eventId): $function -> (${value.code})${value.message}" }
                throw TelegramException(value.code, value.message)
            }
            else           -> value
        }
    }

    internal fun receive() {
        if (!mutex.tryLock()) return
        try {
            nativeClient.receive()
        } finally {
            mutex.unlock()
        }
        nativeClient.handle { eventId, obj ->
            eventHandlers[eventId]
                ?.complete(obj)
                ?: if (obj is TelegramUpdate) updatesCache.offer(obj)
        }
    }

    private companion object {
        private val logger = KotlinLogging.logger { }
    }
}
