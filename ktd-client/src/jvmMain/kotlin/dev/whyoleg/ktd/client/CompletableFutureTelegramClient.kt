package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.api.future.*
import java.util.concurrent.*

class FutureTelegramClient<Updates : Any>(
    api: TelegramApi,
    manager: FutureManager<Updates>
) : TelegramClient<FutureResponse, FutureResponseHandler, Nothing, Updates>(api, manager) {
    @Suppress("UNCHECKED_CAST")
    fun <R : TelegramResponse> send(request: TelegramRequest<R>): Future<R> = sendUntyped(request, null) as Future<R>
}
