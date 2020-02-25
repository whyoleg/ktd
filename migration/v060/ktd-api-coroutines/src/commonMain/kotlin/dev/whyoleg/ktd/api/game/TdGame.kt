@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.game

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.game(f: TdGetGameHighScores): TdGameHighScores = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getGameHighScores(chatId, messageId, userId)",
            "dev.whyoleg.ktd.api.suspend.getGameHighScores"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getGameHighScores(
    chatId: Long = 0L,
    messageId: Long = 0L,
    userId: Int = 0
): TdGameHighScores = exec(TdGetGameHighScores(chatId, messageId, userId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.game(f: TdGetInlineGameHighScores): TdGameHighScores = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getInlineGameHighScores(inlineMessageId, userId)",
            "dev.whyoleg.ktd.api.suspend.getInlineGameHighScores"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getInlineGameHighScores(inlineMessageId: String? = null, userId: Int =
        0): TdGameHighScores = exec(TdGetInlineGameHighScores(inlineMessageId, userId))
