@file:Suppress("unused")

package dev.whyoleg.ktd.api.game

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the high scores for a game and some part of the high score table in the range of the specified user; for bots only
 */
suspend fun TelegramClient.game(
    f: GetGameHighScores
): GameHighScores = execRaw(f) as GameHighScores

/**
 * Returns game high scores and some part of the high score table in the range of the specified user; for bots only
 */
suspend fun TelegramClient.game(
    f: GetInlineGameHighScores
): GameHighScores = execRaw(f) as GameHighScores
