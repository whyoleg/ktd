package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.api.rx2.*
import io.reactivex.*

class Rx2TelegramClient<Updates : Any>(
    api: TelegramApi,
    manager: Rx2Manager<Updates>
) : TelegramClient<Rx2Response, Rx2ResponseHandler, Nothing, Updates>(api, manager) {
    @Suppress("UNCHECKED_CAST")
    fun <R : TelegramResponse> send(request: TelegramRequest<R>): Single<R> = sendUntyped(request, null) as Single<R>
    fun <R : TelegramResponse> sendDefer(request: TelegramRequest<R>): Single<R> = Single.defer { send(request) }
}
