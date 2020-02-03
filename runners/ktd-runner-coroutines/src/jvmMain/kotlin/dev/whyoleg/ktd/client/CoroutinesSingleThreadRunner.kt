package dev.whyoleg.ktd.client

import kotlinx.coroutines.*

internal actual inline fun launchOnSingleThread(job: Job, name: String, crossinline block: () -> Boolean) {
    val singleThread = newSingleThreadContext(name)
    CoroutineScope(singleThread + job)
        .launch { while (isActive && block()) Unit }
        .invokeOnCompletion { singleThread.close() }
}
