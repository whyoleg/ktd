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
}

fun AnyTdApi.coroutinesClient(
    parentJob: Job? = null,
    runner: SynchronizedRunner = DefaultSynchronizedRunner()
): CoroutinesTdClient = CoroutinesTdClient(this, runner, Job(parentJob))
