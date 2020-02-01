package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.api.deferred.*
import kotlinx.coroutines.*

class DeferredTelegramClient<Updates : Any>(
    api: TelegramApi,
    manager: DeferredManager<Updates>,
    parentJob: Job? = null
) : TelegramClient<DeferredResponse, DeferredResponseHandler, Nothing, Updates>(api, manager), Job by Job(parentJob) {
    @Suppress("UNCHECKED_CAST")
    fun <R : TelegramResponse> sendAsync(request: TelegramRequest<R>): Deferred<R> = sendUntyped(request, null) as Deferred<R>
    suspend fun <R : TelegramResponse> send(request: TelegramRequest<R>): R = sendAsync(request).await()
}
