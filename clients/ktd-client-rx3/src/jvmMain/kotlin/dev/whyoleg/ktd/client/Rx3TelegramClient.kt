package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.api.rx3.*
import io.reactivex.rxjava3.core.*

class Rx3TelegramClient<Updates : Any>(
    api: TelegramApi,
    manager: Rx3Manager<Updates>
) : TelegramClient<Rx3Response, Rx3ResponseHandler, Nothing, Updates>(api, manager) {
    @Suppress("UNCHECKED_CAST")
    fun <R : TelegramResponse> send(request: TelegramRequest<R>): Single<R> = sendUntyped(request, null) as Single<R>
    fun <R : TelegramResponse> sendDefer(request: TelegramRequest<R>): Single<R> = Single.defer { send(request) }
}
