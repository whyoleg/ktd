package dev.whyoleg.ktd

import kotlinx.coroutines.*

class Telegram(
    parent: Job? = null,
    private val configuration: TelegramClientConfiguration = TelegramClientConfiguration()
) : Job by SupervisorJob(parent) {
    fun client(): TelegramClient {
        val job = Job(this)
        val nativeClient = NativeClient(configuration)
        job.invokeOnCompletion { nativeClient.destroy() }
        return TelegramClientActor(nativeClient, job)
    }
}
