package dev.whyoleg.ktd.client.api.callback

import dev.whyoleg.ktd.client.api.*

typealias CallbackManager<Updates> = ClientManager<Unit, Callback, Callback, Updates>

@Suppress("FunctionName")
fun <Updates : Any> CallbackManager(
    updatesManager: UpdatesManager<Updates>,
    runner: SynchronizedRunner = DefaultSynchronizedRunner,
    storage: ResponseHandlerStorage<Callback> = DefaultResponseHandlerStorage()
): CallbackManager<Updates> = ClientManager(runner, CallbackMapper, storage, updatesManager)

@Suppress("FunctionName")
fun CallbackManager(
    runner: SynchronizedRunner = DefaultSynchronizedRunner,
    storage: ResponseHandlerStorage<Callback> = DefaultResponseHandlerStorage(),
    updatesCallback: UpdatesCallback
): CallbackManager<Unit> = ClientManager(runner, CallbackMapper, storage, CallbackUpdatesManager(updatesCallback))
