package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import mu.*
import kotlin.coroutines.*

class TelegramClient : CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.Default
    private val nativeClient = NativeClient()
    private val eventHandlers = mutableMapOf<Long, CompletableDeferred<TelegramObject>>()

    @PublishedApi
    internal val channel = Channel<TelegramObject>(Int.MAX_VALUE)

    init {
        launch { eventHandler.send(this@TelegramClient) }
        job.invokeOnCompletion {
            logger.debug { "STOP TELEGRAM" }
            nativeClient.destroy()
            channel.cancel()
            eventHandlers.values.forEach(CompletableDeferred<*>::cancel)
        }
    }

    fun send(function: TelegramFunction): Long = nativeClient.send(function)

    internal suspend fun execRaw(function: TelegramFunction): TelegramObject {
        val deferred = CompletableDeferred<TelegramObject>(job)
        val eventId = nativeClient.send(function) { eventHandlers[it] = deferred }
        val value = deferred.await()
        eventHandlers -= eventId

        if (value is TdApi.Error) logger.error { "Error($eventId): $function -> $value" }
        return value
    }

    private fun receive() = with(nativeClient) {
        receive { eventId, obj ->
            eventHandlers[eventId]?.complete(obj) ?: channel.send(obj)
        }
    }

    private companion object {
        private val logger = KotlinLogging.logger { }
        //TODO make it explicitly launched and can be canceled
        private val eventHandler = GlobalScope.actor<TelegramClient>(Dispatchers.IO) {
            consumeEach { client ->
                client.runCatching(TelegramClient::receive).onFailure { logger.error(it) { "Error on receiving telegram events" } }
                if (client.isActive) launch { channel.send(client) }
            }
        }
    }
}

fun main() {
    runBlocking {
        TelegramClient().channel.consumeEach {
            println(it)
        }
    }
}