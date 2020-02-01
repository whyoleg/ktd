package dev.whyoleg.ktd.client.api.future

import dev.whyoleg.ktd.api.*
import java.util.concurrent.*

typealias FutureResponse = Future<TelegramResponse>
typealias FutureResponseHandler = CompletableFuture<TelegramResponse>
