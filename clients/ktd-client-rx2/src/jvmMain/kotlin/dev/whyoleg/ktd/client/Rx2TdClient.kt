package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import io.reactivex.*

class Rx2TdClient(
    api: StaticTdApi,
    runner: SynchronizedRunner = DefaultSynchronizedRunner(),
    updatesCallback: TdUpdatesCallback = {}
) : CallbackUpdatesTdClient(api, runner, updatesCallback) {
    fun <R : TdResponse> send(request: TdRequest<R>): Single<R> = Single.create { sendCallback(request, it::onSuccess, it::onError) }
}
