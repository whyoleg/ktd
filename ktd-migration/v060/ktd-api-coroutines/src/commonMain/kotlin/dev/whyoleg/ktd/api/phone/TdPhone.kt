@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.phone

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.phone(f: TdSharePhoneNumber): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("sharePhoneNumber(userId)",
            "dev.whyoleg.ktd.api.suspend.sharePhoneNumber"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sharePhoneNumber(userId: Int = 0): TdOk =
        exec(TdSharePhoneNumber(userId))
