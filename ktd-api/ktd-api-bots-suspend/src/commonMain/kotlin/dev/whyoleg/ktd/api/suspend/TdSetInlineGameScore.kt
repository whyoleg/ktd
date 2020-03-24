package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Updates the game score of the specified user in a game
 *
 * @property inlineMessageId Inline message identifier
 * @property editMessage True, if the message should be edited
 * @property userId User identifier
 * @property score The new score
 * @property force Pass true to update the score even if it decreases
 *                 If the score is 0, the user will be deleted from the high score table
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setInlineGameScore(
    inlineMessageId: String? = null,
    editMessage: Boolean = false,
    userId: Int = 0,
    score: Int = 0,
    force: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetInlineGameScore(inlineMessageId, editMessage, userId, score, force, extra))
