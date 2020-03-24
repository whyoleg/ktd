package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the high scores for a game and some part of the high score table in the range of the specified user
 *
 * @property chatId The chat that contains the message with the game
 * @property messageId Identifier of the message
 * @property userId User identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getGameHighScores(
    chatId: Long = 0L,
    messageId: Long = 0L,
    userId: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdGameHighScores = exec(TdGetGameHighScores(chatId, messageId, userId, extra))
