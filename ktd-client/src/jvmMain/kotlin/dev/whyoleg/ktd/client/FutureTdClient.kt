package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import java.util.concurrent.*

class FutureTdClient(
    api: StaticTdApi,
    runner: SynchronizedRunner = DefaultSynchronizedRunner(),
    updatesCallback: TdUpdatesCallback = {}
) : AbstractTdClient(api, runner, updatesCallback) {
    fun <R : TdResponse> send(request: TdRequest<R>): Future<R> = CompletableFuture<R>().also {
        sendCallback(request, it::complete, it::completeExceptionally)
    }
}
