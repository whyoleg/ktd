package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*
import kotlin.time.*

@Deprecated(
    message = "Use CoroutinesTdClient instead",
    replaceWith = ReplaceWith("CoroutinesTdClient"),
    level = DeprecationLevel.ERROR
)
interface TelegramClient {
    companion object {
        @Deprecated(
            message = "Use StaticTdApi.executeSynchronously instead",
            replaceWith = ReplaceWith("StaticTdApi.executeSynchronously(request)", "dev.whyoleg.ktd.api.StaticTdApi"),
            level = DeprecationLevel.ERROR
        )
        fun <T : TdResponse> exec(request: TdRequest<T>): T = error("")
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
@Deprecated(message = "Use CoroutinesTdClient constructor instead", level = DeprecationLevel.ERROR)
class Telegram {
    @Deprecated(
        message = "Use CoroutinesTdClient instead",
        replaceWith = ReplaceWith("CoroutinesTdClient(StaticTdApi, `parent job`)"),
        level = DeprecationLevel.ERROR
    )
    fun client(): CoroutinesTdClient = error("")
}
