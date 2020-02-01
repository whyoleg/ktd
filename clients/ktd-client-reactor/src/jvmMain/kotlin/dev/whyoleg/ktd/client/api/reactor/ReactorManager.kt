package dev.whyoleg.ktd.client.api.reactor

import dev.whyoleg.ktd.client.api.*
import dev.whyoleg.ktd.client.api.callback.*

typealias ReactorManager<Updates> = ClientManager<ReactorResponse, ReactorResponseHandler, Nothing, Updates>

@Suppress("FunctionName")
fun <Updates : Any> ReactorManager(
    updatesManager: UpdatesManager<Updates>,
    runner: SynchronizedRunner = DefaultSynchronizedRunner,
    store: ResponseHandlerStorage<ReactorResponseHandler> = DefaultResponseHandlerStorage()
): ReactorManager<Updates> = ClientManager(runner, ReactorMapper, store, updatesManager)

@Suppress("FunctionName")
fun ReactorManager(
    runner: SynchronizedRunner = DefaultSynchronizedRunner,
    store: ResponseHandlerStorage<ReactorResponseHandler> = DefaultResponseHandlerStorage(),
    updatesCallback: UpdatesCallback
): ReactorManager<Unit> = ClientManager(runner, ReactorMapper, store, CallbackUpdatesManager(updatesCallback))
