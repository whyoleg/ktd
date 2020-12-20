package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * Create default coroutines tdlib client.
 *
 * @receiver api to work with tdlib
 *
 * @param parentJob parent job for suspend client
 *
 * @return [CoroutinesTdClient] default implementation
 */
fun TdApi.coroutinesClient(
    parentJob: Job? = null,
    cache: Int = Int.MAX_VALUE
): CoroutinesTdClient = CoroutinesTdClient(this, cache, Job(parentJob))

/**
 * Coroutines tdlib client, use [Flow] to handle tdlib updates
 * Used by default in [TdApi.coroutinesClient]
 *
 * @param api api to work with tdlib
 * @param job job which will be used to handle requests and client lifecycle
 */
class CoroutinesTdClient internal constructor(
    api: TdApi,
    cache: Int,
    job: Job
) : SuspendTdClient(api, job) {
    /**
     * Cache to save updates
     */
    private val shared = UpdatesFlow(cache, job)

    /**
     * [Flow] which will return stream of ALL updates
     */
    val updates: Flow<TdUpdate> = shared

    /**
     * Save received update to [shared]
     */
    override fun onUpdate(update: TdUpdate): Unit = shared.emit(update)

    companion object

//    //TODO remove after migration
//    companion object {
//        @Suppress("UNUSED_PARAMETER")
//        @Deprecated(
//            message = "Use TdApi.executeSynchronously instead",
//            replaceWith = ReplaceWith("UserTdApi.executeSynchronously(request)", "dev.whyoleg.ktd.api.UserTdApi"),
//            level = DeprecationLevel.ERROR
//        )
//        fun <T : TdResponse> exec(request: TdRequest<T>): T = error("No TdApi exists")
//    }
}

