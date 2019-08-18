@file:Suppress("unused")

package dev.whyoleg.ktd.api.message

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about a message
 *
 * @chatId - Identifier of the chat the message belongs to
 * @messageId - Identifier of the message to get
 */
suspend fun TelegramClient.getMessage(
    chatId: Long,
    messageId: Long
): Message = message(
    GetMessage(
        chatId,
        messageId
    )
)

/**
 * Returns information about a message, if it is available locally without sending network request. This is an offline request
 *
 * @chatId - Identifier of the chat the message belongs to
 * @messageId - Identifier of the message to get
 */
suspend fun TelegramClient.getMessageLocally(
    chatId: Long,
    messageId: Long
): Message = message(
    GetMessageLocally(
        chatId,
        messageId
    )
)

/**
 * Returns information about a message that is replied by given message
 *
 * @chatId - Identifier of the chat the message belongs to
 * @messageId - Identifier of the message reply to which get
 */
suspend fun TelegramClient.getRepliedMessage(
    chatId: Long,
    messageId: Long
): Message = message(
    GetRepliedMessage(
        chatId,
        messageId
    )
)

/**
 * Returns information about a pinned chat message
 *
 * @chatId - Identifier of the chat the message belongs to
 */
suspend fun TelegramClient.getChatPinnedMessage(
    chatId: Long
): Message = message(
    GetChatPinnedMessage(
        chatId
    )
)

/**
 * Returns the last message sent in a chat no later than the specified date
 *
 * @chatId - Chat identifier
 * @date - Point in time (Unix timestamp) relative to which to search for messages
 */
suspend fun TelegramClient.getChatMessageByDate(
    chatId: Long,
    date: Int
): Message = message(
    GetChatMessageByDate(
        chatId,
        date
    )
)

/**
 * Sends a message. Returns the sent message
 *
 * @chatId - Target chat
 * @replyToMessageId - Identifier of the message to reply to or 0
 * @disableNotification - Pass true to disable notification for the message. Not supported in secret chats
 * @fromBackground - Pass true if the message is sent from the background
 * @replyMarkup - Markup for replying to the message; for bots only
 * @inputMessageContent - The content of the message to be sent
 */
suspend fun TelegramClient.sendMessage(
    chatId: Long,
    replyToMessageId: Long,
    disableNotification: Boolean,
    fromBackground: Boolean,
    replyMarkup: ReplyMarkup,
    inputMessageContent: InputMessageContent
): Message = message(
    SendMessage(
        chatId,
        replyToMessageId,
        disableNotification,
        fromBackground,
        replyMarkup,
        inputMessageContent
    )
)

/**
 * Invites a bot to a chat (if it is not yet a member) and sends it the /start command. Bots can't be invited to a private chat other than the chat with the bot. Bots can't be invited to channels (although they can be added as admins) and secret chats. Returns the sent message
 *
 * @botUserId - Identifier of the bot
 * @chatId - Identifier of the target chat
 * @parameter - A hidden parameter sent to the bot for deep linking purposes (https:api.telegram.org/bots#deep-linking)
 */
suspend fun TelegramClient.sendBotStartMessage(
    botUserId: Int,
    chatId: Long,
    parameter: String
): Message = message(
    SendBotStartMessage(
        botUserId,
        chatId,
        parameter
    )
)

/**
 * Sends the result of an inline query as a message. Returns the sent message. Always clears a chat draft message
 *
 * @chatId - Target chat
 * @replyToMessageId - Identifier of a message to reply to or 0
 * @disableNotification - Pass true to disable notification for the message. Not supported in secret chats
 * @fromBackground - Pass true if the message is sent from background
 * @queryId - Identifier of the inline query
 * @resultId - Identifier of the inline result
 * @hideViaBot - If true, there will be no mention of a bot, via which the message is sent. Can be used only for bots GetOption("animation_search_bot_username"), GetOption("photo_search_bot_username") and GetOption("venue_search_bot_username")
 */
suspend fun TelegramClient.sendInlineQueryResultMessage(
    chatId: Long,
    replyToMessageId: Long,
    disableNotification: Boolean,
    fromBackground: Boolean,
    queryId: Long,
    resultId: String,
    hideViaBot: Boolean
): Message = message(
    SendInlineQueryResultMessage(
        chatId,
        replyToMessageId,
        disableNotification,
        fromBackground,
        queryId,
        resultId,
        hideViaBot
    )
)

/**
 * Changes the current TTL setting (sets a new self-destruct timer) in a secret chat and sends the corresponding message
 *
 * @chatId - Chat identifier
 * @ttl - New TTL value, in seconds
 */
suspend fun TelegramClient.sendChatSetTtlMessage(
    chatId: Long,
    ttl: Int
): Message = message(
    SendChatSetTtlMessage(
        chatId,
        ttl
    )
)

/**
 * Adds a local message to a chat. The message is persistent across application restarts only if the message database is used. Returns the added message
 *
 * @chatId - Target chat
 * @senderUserId - Identifier of the user who will be shown as the sender of the message; may be 0 for channel posts
 * @replyToMessageId - Identifier of the message to reply to or 0
 * @disableNotification - Pass true to disable notification for the message
 * @inputMessageContent - The content of the message to be added
 */
suspend fun TelegramClient.addLocalMessage(
    chatId: Long,
    senderUserId: Int,
    replyToMessageId: Long,
    disableNotification: Boolean,
    inputMessageContent: InputMessageContent
): Message = message(
    AddLocalMessage(
        chatId,
        senderUserId,
        replyToMessageId,
        disableNotification,
        inputMessageContent
    )
)

/**
 * Edits the text of a message (or a text of a game message). Returns the edited message after the edit is completed on the server side
 *
 * @chatId - The chat the message belongs to
 * @messageId - Identifier of the message
 * @replyMarkup - The new message reply markup; for bots only
 * @inputMessageContent - New text content of the message. Should be of type InputMessageText
 */
suspend fun TelegramClient.editMessageText(
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup,
    inputMessageContent: InputMessageContent
): Message = message(
    EditMessageText(
        chatId,
        messageId,
        replyMarkup,
        inputMessageContent
    )
)

/**
 * Edits the message content of a live location. Messages can be edited for a limited period of time specified in the live location. Returns the edited message after the edit is completed on the server side
 *
 * @chatId - The chat the message belongs to
 * @messageId - Identifier of the message
 * @replyMarkup - The new message reply markup; for bots only
 * @location - New location content of the message; may be null. Pass null to stop sharing the live location
 */
suspend fun TelegramClient.editMessageLiveLocation(
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup,
    location: Location
): Message = message(
    EditMessageLiveLocation(
        chatId,
        messageId,
        replyMarkup,
        location
    )
)

/**
 * Edits the content of a message with an animation, an audio, a document, a photo or a video. The media in the message can't be replaced if the message was set to self-destruct. Media can't be replaced by self-destructing media. Media in an album can be edited only to contain a photo or a video. Returns the edited message after the edit is completed on the server side
 *
 * @chatId - The chat the message belongs to
 * @messageId - Identifier of the message
 * @replyMarkup - The new message reply markup; for bots only
 * @inputMessageContent - New content of the message. Must be one of the following types: InputMessageAnimation, InputMessageAudio, InputMessageDocument, InputMessagePhoto or InputMessageVideo
 */
suspend fun TelegramClient.editMessageMedia(
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup,
    inputMessageContent: InputMessageContent
): Message = message(
    EditMessageMedia(
        chatId,
        messageId,
        replyMarkup,
        inputMessageContent
    )
)

/**
 * Edits the message content caption. Returns the edited message after the edit is completed on the server side
 *
 * @chatId - The chat the message belongs to
 * @messageId - Identifier of the message
 * @replyMarkup - The new message reply markup; for bots only
 * @caption - New message content caption; 0-GetOption("message_caption_length_max") characters
 */
suspend fun TelegramClient.editMessageCaption(
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup,
    caption: FormattedText
): Message = message(
    EditMessageCaption(
        chatId,
        messageId,
        replyMarkup,
        caption
    )
)

/**
 * Edits the message reply markup; for bots only. Returns the edited message after the edit is completed on the server side
 *
 * @chatId - The chat the message belongs to
 * @messageId - Identifier of the message
 * @replyMarkup - The new message reply markup
 */
suspend fun TelegramClient.editMessageReplyMarkup(
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup
): Message = message(
    EditMessageReplyMarkup(
        chatId,
        messageId,
        replyMarkup
    )
)

/**
 * Updates the game score of the specified user in the game; for bots only
 *
 * @chatId - The chat to which the message with the game belongs
 * @messageId - Identifier of the message
 * @editMessage - True, if the message should be edited
 * @userId - User identifier
 * @score - The new score
 * @force - Pass true to update the score even if it decreases. If the score is 0, the user will be deleted from the high score table
 */
suspend fun TelegramClient.setGameScore(
    chatId: Long,
    messageId: Long,
    editMessage: Boolean,
    userId: Int,
    score: Int,
    force: Boolean
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
 * Informs TDLib that the message content has been opened (e.g., the user has opened a photo, video, document, location or venue, or has listened to an audio file or voice note message). An updateMessageContentOpened update will be generated if something has changed
 *
 * @chatId - Chat identifier of the message
 * @messageId - Identifier of the message with the opened content
 */
suspend fun TelegramClient.openMessageContent(
    chatId: Long,
    messageId: Long
): Ok = message(
    OpenMessageContent(
        chatId,
        messageId
    )
)
