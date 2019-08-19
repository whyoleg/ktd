package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.sync.*
import mu.*

class TelegramClient internal constructor(configuration: TelegramClientConfiguration, parent: Job) : Job by Job(parent) {
    private val nativeClient = NativeClient(configuration)
    private val eventHandlers = mutableMapOf<Long, CompletableDeferred<TelegramObject>>()

    init {
        invokeOnCompletion {
            logger.debug(it) { "Telegram client stopped" }
            nativeClient.destroy()
        }
    }

    private val mutex = Mutex()

    private val objectsCache = UnlimitedCacheChannel<TelegramObject>(this)
    private val updatesCache = UnlimitedCacheChannel<TelegramUpdate>(this)

    val objects: Flow<TelegramObject> = objectsCache.flow
    val updates: Flow<TelegramUpdate> = updatesCache.flow

    public fun send(function: TelegramFunction): Long = nativeClient.send(function)

    internal suspend fun execRaw(function: TelegramFunction): TelegramObject {
        val deferred = CompletableDeferred<TelegramObject>(this)
        val eventId = mutex.withLock {
            val eventId = send(function)
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
            when (val handler = eventHandlers[eventId]) {
                null -> when (obj) {
                    is TelegramUpdate -> updatesCache.offer(obj)
                    else              -> objectsCache.offer(obj)
                }
                else -> handler.complete(obj)
            }
        }
    }

    private companion object {
        private val logger = KotlinLogging.logger { }
    }
}