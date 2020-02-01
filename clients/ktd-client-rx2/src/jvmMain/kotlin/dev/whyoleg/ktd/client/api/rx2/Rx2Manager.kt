package dev.whyoleg.ktd.client.api.rx2

import dev.whyoleg.ktd.client.api.*
import dev.whyoleg.ktd.client.api.callback.*

typealias Rx2Manager<Updates> = ClientManager<Rx2Response, Rx2ResponseHandler, Nothing, Updates>

@Suppress("FunctionName")
fun <Updates : Any> Rx2Manager(
    updatesManager: UpdatesManager<Updates>,
    runner: SynchronizedRunner = DefaultSynchronizedRunner,
    store: ResponseHandlerStorage<Rx2ResponseHandler> = DefaultResponseHandlerStorage()
): Rx2Manager<Updates> = ClientManager(runner, Rx2Mapper, store, updatesManager)

@Suppress("FunctionName")
fun Rx2Manager(
    runner: SynchronizedRunner = DefaultSynchronizedRunner,
    store: ResponseHandlerStorage<Rx2ResponseHandler> = DefaultResponseHandlerStorage(),
    updatesCallback: UpdatesCallback
): Rx2Manager<Unit> = ClientManager(runner, Rx2Mapper, store, CallbackUpdatesManager(updatesCallback))
