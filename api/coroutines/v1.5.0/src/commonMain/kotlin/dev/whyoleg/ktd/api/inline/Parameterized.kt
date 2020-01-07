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
 * Edits the text of an inline text or game message sent via a bot
 *
 * @inlineMessageId - Inline message identifier
 * @replyMarkup - The new message reply markup
 * @inputMessageContent - New text content of the message
 *                        Should be of type InputMessageText
 */
@BotsOnly
suspend fun TelegramClient.editInlineMessageText(
    inlineMessageId: String? = null,
    replyMarkup: ReplyMarkup? = null,
    inputMessageContent: InputMessageContent? = null
): Ok = inline(
    EditInlineMessageText(
        inlineMessageId,
        replyMarkup,
        inputMessageContent
    )
)

/**
 * Edits the content of a live location in an inline message sent via a bot
 *
 * @inlineMessageId - Inline message identifier
 * @replyMarkup - The new message reply markup
 * @location - New location content of the message
 *             Pass null to stop sharing the live location
 */
@BotsOnly
suspend fun TelegramClient.editInlineMessageLiveLocation(
    inlineMessageId: String? = null,
    replyMarkup: ReplyMarkup? = null,
    location: Location? = null
): Ok = inline(
    EditInlineMessageLiveLocation(
        inlineMessageId,
        replyMarkup,
        location
    )
)

/**
 * Edits the content of a message with an animation, an audio, a document, a photo or a video in an inline message sent via a bot
 *
 * @inlineMessageId - Inline message identifier
 * @replyMarkup - The new message reply markup
 * @inputMessageContent - New content of the message
 *                        Must be one of the following types: InputMessageAnimation, InputMessageAudio, InputMessageDocument, InputMessagePhoto or InputMessageVideo
 */
@BotsOnly
suspend fun TelegramClient.editInlineMessageMedia(
    inlineMessageId: String? = null,
    @BotsOnly replyMarkup: ReplyMarkup? = null,
    inputMessageContent: InputMessageContent? = null
): Ok = inline(
    EditInlineMessageMedia(
        inlineMessageId,
        replyMarkup,
        inputMessageContent
    )
)

/**
 * Edits the caption of an inline message sent via a bot
 *
 * @inlineMessageId - Inline message identifier
 * @replyMarkup - The new message reply markup
 * @caption - New message content caption
 *            0-GetOption("message_caption_length_max") characters
 */
@BotsOnly
suspend fun TelegramClient.editInlineMessageCaption(
    inlineMessageId: String? = null,
    replyMarkup: ReplyMarkup? = null,
    caption: FormattedText? = null
): Ok = inline(
    EditInlineMessageCaption(
        inlineMessageId,
        replyMarkup,
        caption
    )
)

/**
 * Edits the reply markup of an inline message sent via a bot
 *
 * @inlineMessageId - Inline message identifier
 * @replyMarkup - The new message reply markup
 */
@BotsOnly
suspend fun TelegramClient.editInlineMessageReplyMarkup(
    inlineMessageId: String? = null,
    replyMarkup: ReplyMarkup? = null
): Ok = inline(
    EditInlineMessageReplyMarkup(
        inlineMessageId,
        replyMarkup
    )
)

/**
 * Sends an inline query to a bot and returns its results
 * Returns an error with code 502 if the bot fails to answer the query before the query timeout expires
 *
 * @botUserId - The identifier of the target bot
 * @chatId - Identifier of the chat, where the query was sent
 * @userLocation - Location of the user, only if needed
 * @query - Text of the query
 * @offset - Offset of the first entry to return
 */
suspend fun TelegramClient.getInlineQueryResults(
    botUserId: Int = 0,
    chatId: Long = 0L,
    userLocation: Location? = null,
    query: String? = null,
    offset: String? = null
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
 * Sets the result of an inline query
 *
 * @inlineQueryId - Identifier of the inline query
 * @isPersonal - True, if the result of the query can be cached for the specified user
 * @results - The results of the query
 * @cacheTime - Allowed time to cache the results of the query, in seconds
 * @nextOffset - Offset for the next inline query
 *               Pass an empty string if there are no more results
 * @switchPmText - If non-empty, this text should be shown on the button that opens a private chat with the bot and sends a start message to the bot with the parameter switch_pm_parameter
 * @switchPmParameter - The parameter for the bot start message
 */
@BotsOnly
suspend fun TelegramClient.answerInlineQuery(
    inlineQueryId: Long = 0L,
    isPersonal: Boolean = false,
    results: Array<InputInlineQueryResult> = emptyArray(),
    cacheTime: Int = 0,
    nextOffset: String? = null,
    switchPmText: String? = null,
    switchPmParameter: String? = null
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
