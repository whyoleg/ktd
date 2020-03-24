package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*

/**
 * Abstract suspend tdlib client.
 *
 * @param api api to work with tdlib
 * @param runner runner to handle tdlib responses
 * @param job job which will be used to handle requests and client lifecycle
 */
abstract class SuspendTdClient(
    api: TdApi,
    runner: SynchronizedRunner = DefaultSynchronizedRunner(),
    protected val job: Job = Job()
) : AbstractTdClient(api, runner), Job by job {
    /**
     * [SupervisorJob] used to handle requests independently, with possibility to cancel all requests on client cancel
     */
    private val requestsJob = SupervisorJob(job)

    /**
     * On cancel, first close client, and then close underlying job
     */
    override fun cancel(cause: CancellationException?) {
        close()
        job.cancel(cause)
    }

    /**
     * If closed not through [cancel], need to cancel underlying job
     */
    override fun onClose() {
        job.cancel()
    }

    /**
     * Send [TdApiRequest] ignoring response
     *
     * @param request request to tdlib
     */
    fun send(request: TdApiRequest) {
        sendCallback(request)
    }

    /**
     * Suspend execute of typed [TdRequest]
     *
     * @param R type of [TdResponse]
     * @param request typed request to tdlib
     *
     * @return response of type [R]
     */
    suspend fun <R : TdResponse> exec(request: TdRequest<R>): R = Dispatchers.Default {
        CompletableDeferred<R>(requestsJob).also { sendCallback(request, it::complete, it::completeExceptionally) }.await()
    }
}
