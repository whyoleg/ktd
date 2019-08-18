@file:Suppress("unused")

package dev.whyoleg.ktd.api.inline

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Edits the text of an inline text or game message sent via a bot; for bots only
 *
 * @inlineMessageId - Inline message identifier
 * @replyMarkup - The new message reply markup
 * @inputMessageContent - New text content of the message. Should be of type InputMessageText
 */
suspend fun TelegramClient.editInlineMessageText(
    inlineMessageId: String,
    replyMarkup: ReplyMarkup,
    inputMessageContent: InputMessageContent
): Ok = inline(
    EditInlineMessageText(
        inlineMessageId,
        replyMarkup,
        inputMessageContent
    )
)

/**
 * Edits the content of a live location in an inline message sent via a bot; for bots only
 *
 * @inlineMessageId - Inline message identifier
 * @replyMarkup - The new message reply markup
 * @location - New location content of the message; may be null. Pass null to stop sharing the live location
 */
suspend fun TelegramClient.editInlineMessageLiveLocation(
    inlineMessageId: String,
    replyMarkup: ReplyMarkup,
    location: Location
): Ok = inline(
    EditInlineMessageLiveLocation(
        inlineMessageId,
        replyMarkup,
        location
    )
)

/**
 * Edits the content of a message with an animation, an audio, a document, a photo or a video in an inline message sent via a bot; for bots only
 *
 * @inlineMessageId - Inline message identifier
 * @replyMarkup - The new message reply markup; for bots only
 * @inputMessageContent - New content of the message. Must be one of the following types: InputMessageAnimation, InputMessageAudio, InputMessageDocument, InputMessagePhoto or InputMessageVideo
 */
suspend fun TelegramClient.editInlineMessageMedia(
    inlineMessageId: String,
    replyMarkup: ReplyMarkup,
    inputMessageContent: InputMessageContent
): Ok = inline(
    EditInlineMessageMedia(
        inlineMessageId,
        replyMarkup,
        inputMessageContent
    )
)

/**
 * Edits the caption of an inline message sent via a bot; for bots only
 *
 * @inlineMessageId - Inline message identifier
 * @replyMarkup - The new message reply markup
 * @caption - New message content caption; 0-GetOption("message_caption_length_max") characters
 */
suspend fun TelegramClient.editInlineMessageCaption(
    inlineMessageId: String,
    replyMarkup: ReplyMarkup,
    caption: FormattedText
): Ok = inline(
    EditInlineMessageCaption(
        inlineMessageId,
        replyMarkup,
        caption
    )
)

/**
 * Edits the reply markup of an inline message sent via a bot; for bots only
 *
 * @inlineMessageId - Inline message identifier
 * @replyMarkup - The new message reply markup
 */
suspend fun TelegramClient.editInlineMessageReplyMarkup(
    inlineMessageId: String,
    replyMarkup: ReplyMarkup
): Ok = inline(
    EditInlineMessageReplyMarkup(
        inlineMessageId,
        replyMarkup
    )
)

/**
 * Sends an inline query to a bot and returns its results. Returns an error with code 502 if the bot fails to answer the query before the query timeout expires
 *
 * @botUserId - The identifier of the target bot
 * @chatId - Identifier of the chat, where the query was sent
 * @userLocation - Location of the user, only if needed
 * @query - Text of the query
 * @offset - Offset of the first entry to return
 */
suspend fun TelegramClient.getInlineQueryResults(
    botUserId: Int,
    chatId: Long,
    userLocation: Location,
    query: String,
    offset: String
): InlineQueryResults = inline(
    GetInlineQueryResults(
        botUserId,
        chatId,
        userLocation,
        query,
        offset
    )
)

/**
 * Sets the result of an inline query; for bots only
 *
 * @inlineQueryId - Identifier of the inline query
 * @isPersonal - True, if the result of the query can be cached for the specified user
 * @results - The results of the query
 * @cacheTime - Allowed time to cache the results of the query, in seconds
 * @nextOffset - Offset for the next inline query; pass an empty string if there are no more results
 * @switchPmText - If non-empty, this text should be shown on the button that opens a private chat with the bot and sends a start message to the bot with the parameter switch_pm_parameter
 * @switchPmParameter - The parameter for the bot start message
 */
suspend fun TelegramClient.answerInlineQuery(
    inlineQueryId: Long,
    isPersonal: Boolean,
    results: Array<InputInlineQueryResult>,
    cacheTime: Int,
    nextOffset: String,
    switchPmText: String,
    switchPmParameter: String
): Ok = inline(
    AnswerInlineQuery(
        inlineQueryId,
        isPersonal,
        results,
        cacheTime,
        nextOffset,
        switchPmText,
        switchPmParameter
    )
)

/**
 * Updates the game score of the specified user in a game; for bots only
 *
 * @inlineMessageId - Inline message identifier
 * @editMessage - True, if the message should be edited
 * @userId - User identifier
 * @score - The new score
 * @force - Pass true to update the score even if it decreases. If the score is 0, the user will be deleted from the high score table
 */
suspend fun TelegramClient.setInlineGameScore(
    inlineMessageId: String,
    editMessage: Boolean,
    userId: Int,
    score: Int,
    force: Boolean
): Ok = inline(
    SetInlineGameScore(
        inlineMessageId,
        editMessage,
        userId,
        score,
        force
    )
)
