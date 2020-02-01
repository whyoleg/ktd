package dev.whyoleg.ktd.client.api.rx3

import dev.whyoleg.ktd.client.api.*
import dev.whyoleg.ktd.client.api.callback.*

typealias Rx3Manager<Updates> = ClientManager<Rx3Response, Rx3ResponseHandler, Nothing, Updates>

@Suppress("FunctionName")
fun <Updates : Any> Rx3Manager(
    updatesManager: UpdatesManager<Updates>,
    runner: SynchronizedRunner = DefaultSynchronizedRunner,
    store: ResponseHandlerStorage<Rx3ResponseHandler> = DefaultResponseHandlerStorage()
): Rx3Manager<Updates> = ClientManager(runner, Rx3Mapper, store, updatesManager)

@Suppress("FunctionName")
fun Rx3Manager(
    runner: SynchronizedRunner = DefaultSynchronizedRunner,
    store: ResponseHandlerStorage<Rx3ResponseHandler> = DefaultResponseHandlerStorage(),
    updatesCallback: UpdatesCallback
): Rx3Manager<Unit> = ClientManager(runner, Rx3Mapper, store, CallbackUpdatesManager(updatesCallback))
