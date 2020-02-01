package dev.whyoleg.ktd.client.api.deferred

import dev.whyoleg.ktd.client.api.*
import dev.whyoleg.ktd.client.api.callback.*
import kotlinx.coroutines.*

typealias DeferredManager<Updates> = ClientManager<DeferredResponse, DeferredResponseHandler, Nothing, Updates>

@Suppress("FunctionName")
fun <Updates : Any> DeferredManager(
    updatesManager: UpdatesManager<Updates>,
    job: Job = Job(),
    runner: SynchronizedRunner = DefaultSynchronizedRunner,
    storage: ResponseHandlerStorage<DeferredResponseHandler> = DefaultResponseHandlerStorage()
): DeferredManager<Updates> = ClientManager(runner, DeferredMapper(job), storage, updatesManager)

@Suppress("FunctionName")
fun DeferredManager(
    job: Job = Job(),
    runner: SynchronizedRunner = DefaultSynchronizedRunner,
    storage: ResponseHandlerStorage<DeferredResponseHandler> = DefaultResponseHandlerStorage(),
    updatesCallback: UpdatesCallback
): DeferredManager<Unit> = ClientManager(runner, DeferredMapper(job), storage, CallbackUpdatesManager(updatesCallback))
