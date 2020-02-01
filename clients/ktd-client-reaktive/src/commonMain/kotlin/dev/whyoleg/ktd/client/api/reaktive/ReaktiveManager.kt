package dev.whyoleg.ktd.client.api.reaktive

import dev.whyoleg.ktd.client.api.*
import dev.whyoleg.ktd.client.api.callback.*

typealias ReaktiveManager<Updates> = ClientManager<ReaktiveResponse, ReaktiveResponseHandler, Nothing, Updates>

@Suppress("FunctionName")
fun <Updates : Any> ReaktiveManager(
    updatesManager: UpdatesManager<Updates>,
    runner: SynchronizedRunner = DefaultSynchronizedRunner,
    store: ResponseHandlerStorage<ReaktiveResponseHandler> = DefaultResponseHandlerStorage()
): ReaktiveManager<Updates> = ClientManager(runner, ReaktiveMapper, store, updatesManager)

@Suppress("FunctionName")
fun ReaktiveManager(
    runner: SynchronizedRunner = DefaultSynchronizedRunner,
    store: ResponseHandlerStorage<ReaktiveResponseHandler> = DefaultResponseHandlerStorage(),
    updatesCallback: UpdatesCallback
): ReaktiveManager<Unit> = ClientManager(runner, ReaktiveMapper, store, CallbackUpdatesManager(updatesCallback))
