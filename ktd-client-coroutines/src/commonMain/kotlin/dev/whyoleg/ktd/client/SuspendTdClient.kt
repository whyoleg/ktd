package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*

/**
 * Create default suspend tdlib client.
 *
 * @receiver api to work with tdlib
 *
 * @param parentJob parent job for suspend client
 * @param updatesCallback callback called when [TdUpdate] received from tdlib
 *
 * @return [SuspendTdClient] default implementation
 */
fun TdApi.suspendClient(
    parentJob: Job? = null,
    updatesCallback: TdUpdatesCallback = {}
): SuspendTdClient = DefaultSuspendTdClient(this, Job(parentJob), updatesCallback)

/**
 * Abstract suspend tdlib client.
 *
 * @param api api to work with tdlib
 * @param runner runner to handle tdlib responses
 * @param job job which will be used to handle requests and client lifecycle
 */
abstract class SuspendTdClient(
    api: TdApi,
    protected val job: Job = Job()
) : AbstractTdClient(api), Job by job {
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
    fun send(request: TdRequest<*>) {
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
    suspend fun <R : TdResponse> exec(request: TdRequest<R>): R = CompletableDeferred<R>(requestsJob).also {
        sendCallback(request, it::complete, it::completeExceptionally)
    }.await()

}

private class DefaultSuspendTdClient(
    api: TdApi,
    job: Job,
    private val updatesCallback: TdUpdatesCallback
) : SuspendTdClient(api, job) {
    override fun onUpdate(update: TdUpdate): Unit = updatesCallback(update)
}
