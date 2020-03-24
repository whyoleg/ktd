package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*

/**
 * Create default suspend tdlib client.
 *
 * @receiver api to work with tdlib
 *
 * @param parentJob parent job for suspend client
 * @param runner runner to handle tdlib responses
 * @param updatesCallback callback called when [TdUpdate] received from tdlib
 *
 * @return [SuspendTdClient] default implementation
 */
fun TdApi.defaultSuspendClient(
    parentJob: Job? = null,
    runner: SynchronizedRunner = DefaultSynchronizedRunner(),
    updatesCallback: TdUpdatesCallback = {}
): SuspendTdClient = DefaultSuspendTdClient(this, runner, Job(parentJob), updatesCallback)

/**
 * Default suspend tdlib client.
 * Used by default in [TdApi.defaultSuspendClient]
 *
 * @param api api to work with tdlib
 * @param runner runner to handle tdlib responses
 * @param job job which will be used to handle requests and client lifecycle
 * @param updatesCallback callback called when [TdUpdate] received from tdlib
 */
internal class DefaultSuspendTdClient(
    api: TdApi,
    runner: SynchronizedRunner,
    job: Job,
    private val updatesCallback: TdUpdatesCallback
) : SuspendTdClient(api, runner, job) {
    override fun onUpdate(update: TdUpdate): Unit = updatesCallback(update)
}
