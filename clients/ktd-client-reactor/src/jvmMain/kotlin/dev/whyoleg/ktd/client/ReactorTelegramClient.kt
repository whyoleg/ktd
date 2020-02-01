package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.api.reactor.*
import reactor.core.publisher.*

class ReactorTelegramClient<Updates : Any>(
    api: TelegramApi,
    manager: ReactorManager<Updates>
) : TelegramClient<ReactorResponse, ReactorResponseHandler, Nothing, Updates>(api, manager) {
    @Suppress("UNCHECKED_CAST")
    fun <R : TelegramResponse> send(request: TelegramRequest<R>): Mono<R> = sendUntyped(request, null) as Mono<R>
    fun <R : TelegramResponse> sendDefer(request: TelegramRequest<R>): Mono<R> = Mono.defer { send(request) }
}
