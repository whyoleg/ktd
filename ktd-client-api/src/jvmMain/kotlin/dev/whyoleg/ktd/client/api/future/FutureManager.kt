package dev.whyoleg.ktd.client.api.future

import dev.whyoleg.ktd.client.api.*
import dev.whyoleg.ktd.client.api.callback.*

typealias FutureManager<Updates> = ClientManager<FutureResponse, FutureResponseHandler, Nothing, Updates>

@Suppress("FunctionName")
fun <Updates : Any> FutureManager(
    updatesManager: UpdatesManager<Updates>,
    runner: SynchronizedRunner = DefaultSynchronizedRunner,
    storage: ResponseHandlerStorage<FutureResponseHandler> = DefaultResponseHandlerStorage()
): FutureManager<Updates> = ClientManager(runner, FutureMapper, storage, updatesManager)

@Suppress("FunctionName")
fun FutureManager(
    runner: SynchronizedRunner = DefaultSynchronizedRunner,
    storage: ResponseHandlerStorage<FutureResponseHandler> = DefaultResponseHandlerStorage(),
    updatesCallback: UpdatesCallback
): FutureManager<Unit> = ClientManager(runner, FutureMapper, storage, CallbackUpdatesManager(updatesCallback))
