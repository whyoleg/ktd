package dev.whyoleg.ktd

import dev.whyoleg.ktd.client.*
import kotlinx.coroutines.*
import kotlin.time.*

@Deprecated(
    message = "Use CoroutinesTdClient instead",
    replaceWith = ReplaceWith("CoroutinesTdClient", "dev.whyoleg.ktd.client.CoroutinesTdClient"),
    level = DeprecationLevel.ERROR
)
typealias TelegramClient = CoroutinesTdClient

@Deprecated(message = "Replaced by SynchronizedRunner with timeout configuration", level = DeprecationLevel.ERROR)
data class TelegramClientConfiguration(val maxEventsCount: Int = 1000, val receiveTimeout: Duration = 1.seconds)

@Deprecated(
    message = "Replaced by TdError",
    replaceWith = ReplaceWith("TdError", "dev.whyoleg.ktd.api.TdError"),
    level = DeprecationLevel.ERROR
)
data class TelegramException(val code: Int, override val message: String?) : RuntimeException(message)

@Suppress("DEPRECATION_ERROR")
@Deprecated(message = "Use UserTdApi.coroutinesClient instead", level = DeprecationLevel.ERROR)
class Telegram(
    parent: Job? = null,
    configuration: TelegramClientConfiguration = TelegramClientConfiguration()
) : Job by SupervisorJob(parent) {
    @Deprecated(
        message = "Use CoroutinesTdClient instead",
        replaceWith = ReplaceWith("UserTdApi.coroutinesClient(`parent job`)"),
        level = DeprecationLevel.ERROR
    )
    fun client(): CoroutinesTdClient = error("No TdApi exists")
}
