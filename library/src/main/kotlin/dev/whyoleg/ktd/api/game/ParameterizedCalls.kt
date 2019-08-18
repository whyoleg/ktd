@file:Suppress("unused")

package dev.whyoleg.ktd.api.game

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the high scores for a game and some part of the high score table in the range of the specified user; for bots only
 *
 * @chatId - The chat that contains the message with the game
 * @messageId - Identifier of the message
 * @userId - User identifier
 */
suspend fun TelegramClient.getGameHighScores(
    chatId: Long,
    messageId: Long,
    userId: Int
): GameHighScores = game(
    GetGameHighScores(
        chatId,
        messageId,
        userId
    )
)

/**
 * Returns game high scores and some part of the high score table in the range of the specified user; for bots only
 *
 * @inlineMessageId - Inline message identifier
 * @userId - User identifier
 */
suspend fun TelegramClient.getInlineGameHighScores(
    inlineMessageId: String,
    userId: Int
): GameHighScores = game(
    GetInlineGameHighScores(
        inlineMessageId,
        userId
    )
)
