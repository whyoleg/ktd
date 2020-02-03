package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import io.reactivex.rxjava3.core.*

class Rx3TdClient(
    api: StaticTdApi,
    runner: SynchronizedRunner = DefaultSynchronizedRunner(),
    updatesCallback: TdUpdatesCallback = {}
) : AbstractTdClient(api, runner, updatesCallback) {
    @Suppress("UNCHECKED_CAST")
    fun <R : TdResponse> send(request: TdRequest<R>): Single<R> = Single.create { sendCallback(request, it::onSuccess, it::onError) }
}
