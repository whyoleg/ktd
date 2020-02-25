package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class CoroutinesTdClient internal constructor(
    api: AnyTdApi,
    runner: SynchronizedRunner,
    job: Job
) : SuspendTdClient(api, runner, job) {
    private val cache = FlowUpdatesCache(job)

    val updates: Flow<TdUpdate> = cache.updates

    override fun onUpdate(update: TdUpdate): Unit = cache.save(update)

    //TODO remove after migration
    companion object {
        @Deprecated(
            message = "Use AnyTdApi.executeSynchronously instead",
            replaceWith = ReplaceWith("UserTdApi.executeSynchronously(request)", "dev.whyoleg.ktd.api.UserTdApi"),
            level = DeprecationLevel.ERROR
        )
        fun <T : TdResponse> exec(request: TdRequest<T>): T = error("No TdApi exists")
    }
}

fun AnyTdApi.coroutinesClient(
    parentJob: Job? = null,
    runner: SynchronizedRunner = DefaultSynchronizedRunner()
): CoroutinesTdClient = CoroutinesTdClient(this, runner, Job(parentJob))
