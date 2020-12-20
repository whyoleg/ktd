@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.secret

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.secret(f: TdGetSecretChat): TdSecretChat = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getSecretChat(secretChatId)",
            "dev.whyoleg.ktd.api.suspend.getSecretChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getSecretChat(secretChatId: Int = 0): TdSecretChat =
        exec(TdGetSecretChat(secretChatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.secret(f: TdCloseSecretChat): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("closeSecretChat(secretChatId)",
            "dev.whyoleg.ktd.api.suspend.closeSecretChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.closeSecretChat(secretChatId: Int = 0): TdOk =
        exec(TdCloseSecretChat(secretChatId))
