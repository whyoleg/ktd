package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*

class DeferredTdClient internal constructor(
    job: Job,
    api: StaticTdApi,
    updatesCallback: TdUpdatesCallback
) : AbstractTdClient(api, CoroutinesSingleThreadRunner(job), updatesCallback), Job by job {
    @Suppress("UNCHECKED_CAST")
    private val requestsJob = SupervisorJob(job)
    internal val requestsScope = CoroutineScope(Dispatchers.Default + requestsJob)

    @Suppress("DeferredIsResult")
    internal suspend fun <R : TdResponse> sendImmediate(request: TdRequest<R>): R = CompletableDeferred<R>(requestsJob).also {
        sendCallback(request, it::complete, it::completeExceptionally)
    }.await()

}

suspend fun <R : TdResponse> DeferredTdClient.send(request: TdRequest<R>): R =
    withContext(Dispatchers.Default) { sendImmediate(request) }

fun <R : TdResponse> DeferredTdClient.sendAsync(request: TdRequest<R>): Deferred<R> =
    requestsScope.async(start = CoroutineStart.LAZY) { sendImmediate(request) }

@Suppress("FunctionName")
fun DeferredTdClient(
    api: StaticTdApi,
    parentJob: Job? = null,
    updatesCallback: TdUpdatesCallback = {}
): DeferredTdClient = DeferredTdClient(Job(parentJob), api, updatesCallback)
