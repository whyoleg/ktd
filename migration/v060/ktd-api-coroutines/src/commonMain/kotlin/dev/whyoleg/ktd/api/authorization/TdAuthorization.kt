@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.authorization

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.authorization(f: TdGetAuthorizationState): TdAuthorizationState = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getAuthorizationState()",
            "dev.whyoleg.ktd.api.suspend.getAuthorizationState"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getAuthorizationState(): TdAuthorizationState =
        exec(TdGetAuthorizationState())
