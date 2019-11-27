@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.game

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the high scores for a game and some part of the high score table in the range of the specified user
 *
 * @chatId - The chat that contains the message with the game
 * @messageId - Identifier of the message
 * @userId - User identifier
 */
@BotsOnly
suspend fun TelegramClient.getGameHighScores(
    chatId: Long = 0L,
    messageId: Long = 0L,
    userId: Int = 0
): GameHighScores = game(
    GetGameHighScores(
        chatId,
        messageId,
        userId
    )
)

/**
 * Returns game high scores and some part of the high score table in the range of the specified user
 *
 * @inlineMessageId - Inline message identifier
 * @userId - User identifier
 */
@BotsOnly
suspend fun TelegramClient.getInlineGameHighScores(
    inlineMessageId: String? = null,
    userId: Int = 0
): GameHighScores = game(
    GetInlineGameHighScores(
        inlineMessageId,
        userId
    )
)
