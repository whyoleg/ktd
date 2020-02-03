package dev.whyoleg.ktd.client

import com.badoo.reaktive.single.*
import dev.whyoleg.ktd.api.*

class ReaktiveTdClient(
    api: StaticTdApi,
    runner: SynchronizedRunner = DefaultSynchronizedRunner(),
    updatesCallback: TdUpdatesCallback = {}
) : AbstractTdClient(api, runner, updatesCallback) {
    @Suppress("UNCHECKED_CAST")
    fun <R : TdResponse> send(request: TdRequest<R>): Single<R> = single { sendCallback(request, it::onSuccess, it::onError) }
}
