@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.bot

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.bot(f: TdSetBotUpdatesStatus): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setBotUpdatesStatus(pendingUpdateCount, errorMessage)",
            "dev.whyoleg.ktd.api.suspend.setBotUpdatesStatus"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setBotUpdatesStatus(pendingUpdateCount: Int = 0, errorMessage: String? =
        null): TdOk = exec(TdSetBotUpdatesStatus(pendingUpdateCount, errorMessage))
