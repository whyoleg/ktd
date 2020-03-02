package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*

abstract class SuspendTdClient(
    api: TdApi,
    runner: SynchronizedRunner = DefaultSynchronizedRunner(),
    protected val job: Job = Job()
) : AbstractTdClient(api, runner), Job by job {
    private val requestsJob = SupervisorJob(job)

    override fun cancel(cause: CancellationException?) {
        close()
        job.cancel(cause)
    }

    override fun onClose() {
        job.cancel()
    }

    fun send(request: TdApiRequest) {
        sendCallback(request)
    }

    suspend fun <R : TdResponse> exec(request: TdRequest<R>): R = Dispatchers.Default {
        CompletableDeferred<R>(requestsJob).also { sendCallback(request, it::complete, it::completeExceptionally) }.await()
    }
}
