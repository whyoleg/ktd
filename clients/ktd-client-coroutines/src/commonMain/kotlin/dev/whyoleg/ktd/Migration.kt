package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.time.*

@Deprecated(
    message = "Use CoroutinesTdClient instead",
    replaceWith = ReplaceWith("CoroutinesTdClient"),
    level = DeprecationLevel.ERROR
)
interface TelegramClient {
    val updates: Flow<TdUpdate>
    fun send(request: TdApiRequest)
    suspend fun <R : TdResponse> exec(request: TdRequest<R>): R

    companion object {
        @Deprecated(
            message = "Use TdApi.executeSynchronously instead",
            replaceWith = ReplaceWith("TdApi.executeSynchronously(request)", "dev.whyoleg.ktd.api.TdApi"),
            level = DeprecationLevel.ERROR
        )
        fun <T : TdResponse> exec(request: TdRequest<T>): T = error("No TdApi exists")
    }
}

@Deprecated(message = "Replaced by SynchronizedRunner with timeout configuration", level = DeprecationLevel.ERROR)
data class TelegramClientConfiguration(val maxEventsCount: Int = 1000, val receiveTimeout: Duration = 1.seconds)

@Deprecated(
    message = "Replaced by TdError",
    replaceWith = ReplaceWith("TdError", "dev.whyoleg.ktd.api.TdError"),
    level = DeprecationLevel.ERROR
)
data class TelegramException(val code: Int, override val message: String?) : RuntimeException(message)

@Suppress("DEPRECATION_ERROR")
@Deprecated(message = "Use TdApi.coroutinesClient instead", level = DeprecationLevel.ERROR)
class Telegram(
    parent: Job? = null,
    private val configuration: TelegramClientConfiguration = TelegramClientConfiguration()
) : Job by SupervisorJob(parent) {
    @Deprecated(
        message = "Use CoroutinesTdClient instead",
        replaceWith = ReplaceWith("TdApi.coroutinesClient(`parent job`)"),
        level = DeprecationLevel.ERROR
    )
    fun client(): CoroutinesTdClient = error("No TdApi exists")
}
