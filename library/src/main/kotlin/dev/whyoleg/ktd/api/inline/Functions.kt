@file:Suppress("unused")

package dev.whyoleg.ktd.api.inline

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Edits the text of an inline text or game message sent via a bot; for bots only
 */
suspend fun TelegramClient.inline(
    f: EditInlineMessageText
): Ok = execRaw(f) as Ok

/**
 * Edits the content of a live location in an inline message sent via a bot; for bots only
 */
suspend fun TelegramClient.inline(
    f: EditInlineMessageLiveLocation
): Ok = execRaw(f) as Ok

/**
 * Edits the content of a message with an animation, an audio, a document, a photo or a video in an inline message sent via a bot; for bots only
 */
suspend fun TelegramClient.inline(
    f: EditInlineMessageMedia
): Ok = execRaw(f) as Ok

/**
 * Edits the caption of an inline message sent via a bot; for bots only
 */
suspend fun TelegramClient.inline(
    f: EditInlineMessageCaption
): Ok = execRaw(f) as Ok

/**
 * Edits the reply markup of an inline message sent via a bot; for bots only
 */
suspend fun TelegramClient.inline(
    f: EditInlineMessageReplyMarkup
): Ok = execRaw(f) as Ok

/**
 * Sends an inline query to a bot and returns its results. Returns an error with code 502 if the bot fails to answer the query before the query timeout expires
 */
suspend fun TelegramClient.inline(
    f: GetInlineQueryResults
): InlineQueryResults = execRaw(f) as InlineQueryResults

/**
 * Sets the result of an inline query; for bots only
 */
suspend fun TelegramClient.inline(
    f: AnswerInlineQuery
): Ok = execRaw(f) as Ok

/**
 * Updates the game score of the specified user in a game; for bots only
 */
suspend fun TelegramClient.inline(
    f: SetInlineGameScore
): Ok = execRaw(f) as Ok
