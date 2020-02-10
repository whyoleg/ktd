package dev.whyoleg.ktd.client

import com.badoo.reaktive.single.*
import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

class ReaktiveTdClient(
    api: AnyTdApi,
    runner: SynchronizedRunner = DefaultSynchronizedRunner(),
    updatesCallback: TdUpdatesCallback = {}
) : CallbackUpdatesTdClient(api, runner, updatesCallback) {
    fun <R : TdResponse> send(request: TdRequest<R>): Single<R> = single { sendCallback(request, it::onSuccess, it::onError) }
}
