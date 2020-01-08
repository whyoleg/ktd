@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.inline

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Updates the game score of the specified user in a game
 *
 * @inlineMessageId - Inline message identifier
 * @editMessage - True, if the message should be edited
 * @userId - User identifier
 * @score - The new score
 * @force - Pass true to update the score even if it decreases
 *          If the score is 0, the user will be deleted from the high score table
 */
@BotsOnly
suspend fun TelegramClient.setInlineGameScore(
    inlineMessageId: String? = null,
    editMessage: Boolean = false,
    userId: Int = 0,
    score: Int = 0,
    force: Boolean = false
): Ok = inline(
    SetInlineGameScore(
        inlineMessageId,
        editMessage,
        userId,
        score,
        force
    )
)

/**
 * Updates the game score of the specified user in a game
 */
@BotsOnly
suspend fun TelegramClient.inline(
    f: SetInlineGameScore
): Ok = exec(f) as Ok
