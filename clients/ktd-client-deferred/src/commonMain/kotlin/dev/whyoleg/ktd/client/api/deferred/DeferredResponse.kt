package dev.whyoleg.ktd.client.api.deferred

import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*

typealias DeferredResponse = Deferred<TelegramResponse>
typealias DeferredResponseHandler = CompletableDeferred<TelegramResponse>
