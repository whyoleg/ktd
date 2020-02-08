package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*

class DeferredTdClient internal constructor(
    private val job: Job,
    api: StaticTdApi,
    runner: SynchronizedRunner,
    updatesCallback: TdUpdatesCallback
) : AbstractTdClient(api, runner, updatesCallback), Job by job {
    private val requestsJob = SupervisorJob(job)
    internal val requestsScope = CoroutineScope(Dispatchers.Default + requestsJob)

    internal suspend fun <R : TdResponse> sendImmediate(request: TdRequest<R>): R = CompletableDeferred<R>(requestsJob).also {
        sendCallback(request, it::complete, it::completeExceptionally)
    }.await()

    override fun cancel(cause: CancellationException?) {
        close()
        job.cancel(cause)
    }

    override fun onClose() {
        job.cancel()
    }

}

suspend fun <R : TdResponse> DeferredTdClient.send(request: TdRequest<R>): R =
    withContext(Dispatchers.Default) { sendImmediate(request) }

fun <R : TdResponse> DeferredTdClient.sendAsync(request: TdRequest<R>): Deferred<R> =
    requestsScope.async(start = CoroutineStart.LAZY) { sendImmediate(request) }

@Suppress("FunctionName")
fun DeferredTdClient(
    api: StaticTdApi,
    parentJob: Job? = null,
    runner: SynchronizedRunner = DefaultSynchronizedRunner(),
    updatesCallback: TdUpdatesCallback = {}
): DeferredTdClient = DeferredTdClient(Job(parentJob), api, runner, updatesCallback)
