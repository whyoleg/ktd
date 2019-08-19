package dev.whyoleg.ktd

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.*
import mu.*

class Telegram(
    parent: Job? = null,
    private val configuration: TelegramClientConfiguration = TelegramClientConfiguration()
) : Job by SupervisorJob(parent) {
    private val handler = GlobalScope.actor<TelegramClient>(Dispatchers.IO + this, Channel.UNLIMITED) {
        consumeEach { client ->
            client.runCatching(TelegramClient::receive).onFailure { logger.error(it) { "Error on receiving telegram events" } }
            if (client.isActive) channel.offer(client)
        }
    }

    fun client(): TelegramClient {
        val client = TelegramClient(configuration, this)
        handler.offer(client)
        return client
    }

    private companion object {
        private val logger = KotlinLogging.logger { }
    }
}

suspend fun main() {
    Telegram().client().updates.collect {
        println(it)
    }
}