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

/**
 * Returns game high scores and some part of the high score table in the range of the specified user
 */
@BotsOnly
suspend fun TelegramClient.game(
    f: GetInlineGameHighScores
): GameHighScores = exec(f) as GameHighScores
