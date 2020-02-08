package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import reactor.core.publisher.*

class ReactorTdClient(
    api: StaticTdApi,
    runner: SynchronizedRunner = DefaultSynchronizedRunner(),
    updatesCallback: TdUpdatesCallback = {}
) : AbstractTdClient(api, runner, updatesCallback) {
    fun <R : TdResponse> send(request: TdRequest<R>): Mono<R> = Mono.create { sendCallback(request, it::success, it::error) }
}