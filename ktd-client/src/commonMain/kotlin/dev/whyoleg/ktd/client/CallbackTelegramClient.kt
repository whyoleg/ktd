package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.api.callback.*

class CallbackTelegramClient<Updates : Any>(
    api: TelegramApi,
    manager: CallbackManager<Updates>
) : TelegramClient<Unit, Callback, Callback, Updates>(api, manager) {
    @Suppress("UNCHECKED_CAST")
    fun <R : TelegramResponse> send(request: TelegramRequest<R>, block: TypedCallback<R>): Unit = sendUntyped(request, block as Callback)
}
