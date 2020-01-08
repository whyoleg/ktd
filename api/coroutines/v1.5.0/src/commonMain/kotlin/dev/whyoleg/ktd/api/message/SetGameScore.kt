@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.message

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Updates the game score of the specified user in the game
 *
 * @chatId - The chat to which the message with the game belongs
 * @messageId - Identifier of the message
 * @editMessage - True, if the message should be edited
 * @userId - User identifier
 * @score - The new score
 * @force - Pass true to update the score even if it decreases
 *          If the score is 0, the user will be deleted from the high score table
 */
@BotsOnly
suspend fun TelegramClient.setGameScore(
    chatId: Long = 0L,
    messageId: Long = 0L,
    editMessage: Boolean = false,
    userId: Int = 0,
    score: Int = 0,
    force: Boolean = false
): Message = message(
    SetGameScore(
        chatId,
        messageId,
        editMessage,
        userId,
        score,
        force
    )
)

/**
 * Updates the game score of the specified user in the game
 */
@BotsOnly
suspend fun TelegramClient.message(
    f: SetGameScore
): Message = exec(f) as Message
