package dev.whyoleg.ktd.client

import com.badoo.reaktive.single.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.api.reaktive.*

class ReaktiveTelegramClient<Updates : Any>(
    api: TelegramApi,
    manager: ReaktiveManager<Updates>
) : TelegramClient<ReaktiveResponse, ReaktiveResponseHandler, Nothing, Updates>(api, manager) {
    @Suppress("UNCHECKED_CAST")
    fun <R : TelegramResponse> send(request: TelegramRequest<R>): Single<R> = sendUntyped(request, null) as Single<R>
    fun <R : TelegramResponse> sendDefer(request: TelegramRequest<R>): Single<R> = singleUnsafe { send(request).subscribe(it) }

}
