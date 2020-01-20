package dev.whyoleg.ktd

import kotlinx.coroutines.*

internal actual inline fun launchOnSingleThread(job: Job, name: String, crossinline block: () -> Unit) {
    val singleThread = newSingleThreadContext(name)
    CoroutineScope(singleThread + job)
        .launch { while (isActive) block() }
        .invokeOnCompletion { singleThread.close() }
}
