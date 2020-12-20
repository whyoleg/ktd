@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.updates(f: TdGetCurrentState): TdUpdates = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getCurrentState()", "dev.whyoleg.ktd.api.suspend.getCurrentState"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getCurrentState(): TdUpdates = exec(TdGetCurrentState())
