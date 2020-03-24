package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * Create default coroutines tdlib client.
 *
 * @receiver api to work with tdlib
 *
 * @param parentJob parent job for suspend client
 * @param runner runner to handle tdlib responses
 *
 * @return [CoroutinesTdClient] default implementation
 */
fun TdApi.coroutinesClient(
    parentJob: Job? = null,
    runner: SynchronizedRunner = DefaultSynchronizedRunner()
): CoroutinesTdClient = CoroutinesTdClient(this, runner, Job(parentJob))

/**
 * Coroutines tdlib client, use [Flow] to handle tdlib updates
 * Used by default in [TdApi.coroutinesClient]
 *
 * @param api api to work with tdlib
 * @param runner runner to handle tdlib responses
 * @param job job which will be used to handle requests and client lifecycle
 */
class CoroutinesTdClient internal constructor(
    api: TdApi,
    runner: SynchronizedRunner,
    job: Job
) : SuspendTdClient(api, runner, job) {
    /**
     * Cache to save updates
     */
    private val cache = FlowUpdatesCache(job)

    /**
     * [Flow] which will return stream of ALL updates
     */
    public val updates: Flow<TdUpdate> = cache.updates

    /**
     * Save received update to [cache]
     */
    override fun onUpdate(update: TdUpdate): Unit = cache.save(update)

    //TODO remove after migration
    companion object {
        @Suppress("UNUSED_PARAMETER")
        @Deprecated(
            message = "Use TdApi.executeSynchronously instead",
            replaceWith = ReplaceWith("UserTdApi.executeSynchronously(request)", "dev.whyoleg.ktd.api.UserTdApi"),
            level = DeprecationLevel.ERROR
        )
        fun <T : TdResponse> exec(request: TdRequest<T>): T = error("No TdApi exists")
    }
}
