package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns game high scores and some part of the high score table in the range of the specified user
 *
 * @property inlineMessageId Inline message identifier
 * @property userId User identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getInlineGameHighScores(
    inlineMessageId: String? = null,
    userId: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdGameHighScores = exec(TdGetInlineGameHighScores(inlineMessageId, userId, extra))
