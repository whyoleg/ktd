package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class CoroutinesTdClient internal constructor(
    private val job: Job,
    api: AnyTdApi,
    runner: SynchronizedRunner
) : AbstractTdClient(api, runner), Job by job {
    private val requestsJob = SupervisorJob(job)
    private val cache = FlowUpdatesCache(job)
    val updates: Flow<TdUpdate> = cache.updates

    override fun cancel(cause: CancellationException?) {
        close()
        job.cancel(cause)
    }

    override fun onClose() {
        job.cancel()
    }

    override fun onUpdate(update: TdUpdate) {
        cache.save(update)
    }

    fun send(request: TdApiRequest) {
        sendCallback(request)
    }

    suspend fun <R : TdResponse> exec(request: TdRequest<R>): R = Dispatchers.Default {
        CompletableDeferred<R>(requestsJob).also { sendCallback(request, it::complete, it::completeExceptionally) }.await()
    }
}

@Suppress("FunctionName")
fun CoroutinesTdClient(
    api: AnyTdApi,
    parentJob: Job? = null,
    runner: SynchronizedRunner = DefaultSynchronizedRunner()
): CoroutinesTdClient = CoroutinesTdClient(Job(parentJob), api, runner)
