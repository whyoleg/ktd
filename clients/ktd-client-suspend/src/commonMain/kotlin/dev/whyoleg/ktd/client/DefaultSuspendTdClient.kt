package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*

internal class DefaultSuspendTdClient(
    api: AnyTdApi,
    runner: SynchronizedRunner,
    job: Job,
    private val updatesCallback: TdUpdatesCallback
) : SuspendTdClient(api, runner, job) {
    override fun onUpdate(update: TdUpdate): Unit = updatesCallback(update)
}

fun AnyTdApi.defaultSuspendClient(
    parentJob: Job? = null,
    runner: SynchronizedRunner = DefaultSynchronizedRunner(),
    updatesCallback: TdUpdatesCallback = {}
): SuspendTdClient = DefaultSuspendTdClient(this, runner, Job(parentJob), updatesCallback)
