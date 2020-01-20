package dev.whyoleg.ktd

import kotlinx.coroutines.*

internal expect inline fun launchOnSingleThread(job: Job, name: String, crossinline block: () -> Unit)
