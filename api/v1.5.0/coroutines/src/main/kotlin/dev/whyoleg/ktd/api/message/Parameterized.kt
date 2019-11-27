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
 * Returns information about a message
 *
 * @chatId - Identifier of the chat the message belongs to
 * @messageId - Identifier of the message to get
 */
suspend fun TelegramClient.getMessage(
    chatId: Long = 0L,
    messageId: Long = 0L
): Message = message(
    GetMessage(
        chatId,
        messageId
    )
)

/**
 * Returns information about a message, if it is available locally without sending network request
 * This is an offline request
 *
 * @chatId - Identifier of the chat the message belongs to
 * @messageId - Identifier of the message to get
 */
suspend fun TelegramClient.getMessageLocally(
    chatId: Long = 0L,
    messageId: Long = 0L
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
    chatId: Long = 0L,
    messageId: Long = 0L
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
    chatId: Long = 0L
): Message = message(
    GetChatPinnedMessage(
        chatId
    )
)

/**
 * Returns information about messages
 * If a message is not found, returns null on the corresponding position of the result
 *
 * @chatId - Identifier of the chat the messages belong to
 * @messageIds - Identifiers of the messages to get
 */
suspend fun TelegramClient.getMessages(
    chatId: Long = 0L,
    messageIds: LongArray = longArrayOf()
): Messages = message(
    GetMessages(
        chatId,
        messageIds
    )
)

/**
 * Returns messages in a chat
 * The messages are returned in a reverse chronological order (i.e., in order of decreasing message_id)
 * For optimal performance the number of returned messages is chosen by the library
 * This is an offline request if only_local is true
 *
 * @chatId - Chat identifier
 * @fromMessageId - Identifier of the message starting from which history must be fetched
 *                  Use 0 to get results from the last message
 * @offset - Specify 0 to get results from exactly the from_message_id or a negative offset up to 99 to get additionally some newer messages
 * @limit - The maximum number of messages to be returned
 *          Must be positive and can't be greater than 100
 *          If the offset is negative, the limit must be greater or equal to -offset
 *          Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 * @onlyLocal - If true, returns only messages that are available locally without sending network requests
 */
suspend fun TelegramClient.getChatHistory(
    chatId: Long = 0L,
    fromMessageId: Long = 0L,
    offset: Int = 0,
    limit: Int = 0,
    onlyLocal: Boolean = false
): Messages = message(
    GetChatHistory(
        chatId,
        fromMessageId,
        offset,
        limit,
        onlyLocal
    )
)

/**
 * Searches for messages with given words in the chat
 * Returns the results in reverse chronological order, i.e
 * In order of decreasing message_id
 * Cannot be used in secret chats with a non-empty query (searchSecretMessages should be used instead), or without an enabled message database
 * For optimal performance the number of returned messages is chosen by the library
 *
 * @chatId - Identifier of the chat in which to search messages
 * @query - Query to search for
 * @senderUserId - If not 0, only messages sent by the specified user will be returned
 *                 Not supported in secret chats
 * @fromMessageId - Identifier of the message starting from which history must be fetched
 *                  Use 0 to get results from the last message
 * @offset - Specify 0 to get results from exactly the from_message_id or a negative offset to get the specified message and some newer messages
 * @limit - The maximum number of messages to be returned
 *          Must be positive and can't be greater than 100
 *          If the offset is negative, the limit must be greater than -offset
 *          Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 * @filter - Filter for message content in the search results
 */
suspend fun TelegramClient.searchChatMessages(
    chatId: Long = 0L,
    query: String? = null,
    senderUserId: Int = 0,
    fromMessageId: Long = 0L,
    offset: Int = 0,
    limit: Int = 0,
    filter: SearchMessagesFilter? = null
): Messages = message(
    SearchChatMessages(
        chatId,
        query,
        senderUserId,
        fromMessageId,
        offset,
        limit,
        filter
    )
)

/**
 * Searches for messages in all chats except secret chats
 * Returns the results in reverse chronological order (i.e., in order of decreasing (date, chat_id, message_id))
 * For optimal performance the number of returned messages is chosen by the library
 *
 * @query - Query to search for
 * @offsetDate - The date of the message starting from which the results should be fetched
 *               Use 0 or any date in the future to get results from the last message
 * @offsetChatId - The chat identifier of the last found message, or 0 for the first request
 * @offsetMessageId - The message identifier of the last found message, or 0 for the first request
 * @limit - The maximum number of messages to be returned, up to 100
 *          Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 */
suspend fun TelegramClient.searchMessages(
    query: String? = null,
    offsetDate: Int = 0,
    offsetChatId: Long = 0L,
    offsetMessageId: Long = 0L,
    limit: Int = 0
): Messages = message(
    SearchMessages(
        query,
        offsetDate,
        offsetChatId,
        offsetMessageId,
        limit
    )
)

/**
 * Searches for messages in secret chats
 * Returns the results in reverse chronological order
 * For optimal performance the number of returned messages is chosen by the library
 *
 * @chatId - Identifier of the chat in which to search
 *           Specify 0 to search in all secret chats
 * @query - Query to search for
 *          If empty, searchChatMessages should be used instead
 * @fromSearchId - The identifier from the result of a previous request, use 0 to get results from the last message
 * @limit - Maximum number of messages to be returned
 *          Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 * @filter - A filter for the content of messages in the search results
 */
suspend fun TelegramClient.searchSecretMessages(
    chatId: Long = 0L,
    query: String? = null,
    fromSearchId: Long = 0L,
    limit: Int = 0,
    filter: SearchMessagesFilter? = null
): FoundMessages = message(
    SearchSecretMessages(
        chatId,
        query,
        fromSearchId,
        limit,
        filter
    )
)

/**
 * Searches for call messages
 * Returns the results in reverse chronological order (i
 * E., in order of decreasing message_id)
 * For optimal performance the number of returned messages is chosen by the library
 *
 * @fromMessageId - Identifier of the message from which to search
 *                  Use 0 to get results from the last message
 * @limit - The maximum number of messages to be returned
 *          Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 * @onlyMissed - If true, returns only messages with missed calls
 */
suspend fun TelegramClient.searchCallMessages(
    fromMessageId: Long = 0L,
    limit: Int = 0,
    onlyMissed: Boolean = false
): Messages = message(
    SearchCallMessages(
        fromMessageId,
        limit,
        onlyMissed
    )
)

/**
 * Returns information about the recent locations of chat members that were sent to the chat
 * Returns up to 1 location message per user
 *
 * @chatId - Chat identifier
 * @limit - Maximum number of messages to be returned
 */
suspend fun TelegramClient.searchChatRecentLocationMessages(
    chatId: Long = 0L,
    limit: Int = 0
): Messages = message(
    SearchChatRecentLocationMessages(
        chatId,
        limit
    )
)

/**
 * Returns all active live locations that should be updated by the client
 * The list is persistent across application restarts only if the message database is used
 */
suspend fun TelegramClient.getActiveLiveLocationMessages(): Messages = message(
    GetActiveLiveLocationMessages()
)

/**
 * Returns the last message sent in a chat no later than the specified date
 *
 * @chatId - Chat identifier
 * @date - Point in time (Unix timestamp) relative to which to search for messages
 */
suspend fun TelegramClient.getChatMessageByDate(
    chatId: Long = 0L,
    date: Int = 0
): Message = message(
    GetChatMessageByDate(
        chatId,
        date
    )
)

/**
 * Returns a public HTTPS link to a message
 * Available only for messages in supergroups and channels with username
 *
 * @chatId - Identifier of the chat to which the message belongs
 * @messageId - Identifier of the message
 * @forAlbum - Pass true if a link for a whole media album should be returned
 */
suspend fun TelegramClient.getPublicMessageLink(
    chatId: Long = 0L,
    messageId: Long = 0L,
    forAlbum: Boolean = false
): PublicMessageLink = message(
    GetPublicMessageLink(
        chatId,
        messageId,
        forAlbum
    )
)

/**
 * Returns a private HTTPS link to a message in a chat
 * Available only for already sent messages in supergroups and channels
 * The link will work only for members of the chat
 *
 * @chatId - Identifier of the chat to which the message belongs
 * @messageId - Identifier of the message
 */
suspend fun TelegramClient.getMessageLink(
    chatId: Long = 0L,
    messageId: Long = 0L
): HttpUrl = message(
    GetMessageLink(
        chatId,
        messageId
    )
)

/**
 * Returns information about a public or private message link
 *
 * @url - The message link in the format "https://t.me/c/...", or "tg://privatepost?...", or "https://t.me/username/...", or "tg://resolve?..."
 */
suspend fun TelegramClient.getMessageLinkInfo(
    url: String? = null
): MessageLinkInfo = message(
    GetMessageLinkInfo(
        url
    )
)

/**
 * Sends a message
 * Returns the sent message
 *
 * @chatId - Target chat
 * @replyToMessageId - Identifier of the message to reply to or 0
 * @disableNotification - Pass true to disable notification for the message
 *                        Not supported in secret chats
 * @fromBackground - Pass true if the message is sent from the background
 * @replyMarkup - Markup for replying to the message
 * @inputMessageContent - The content of the message to be sent
 */
suspend fun TelegramClient.sendMessage(
    chatId: Long = 0L,
    replyToMessageId: Long = 0L,
    disableNotification: Boolean = false,
    fromBackground: Boolean = false,
    @BotsOnly replyMarkup: ReplyMarkup? = null,
    inputMessageContent: InputMessageContent? = null
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
 * Sends messages grouped together into an album
 * Currently only photo and video messages can be grouped into an album
 * Returns sent messages
 *
 * @chatId - Target chat
 * @replyToMessageId - Identifier of a message to reply to or 0
 * @disableNotification - Pass true to disable notification for the messages
 *                        Not supported in secret chats
 * @fromBackground - Pass true if the messages are sent from the background
 * @inputMessageContents - Contents of messages to be sent
 */
suspend fun TelegramClient.sendMessageAlbum(
    chatId: Long = 0L,
    replyToMessageId: Long = 0L,
    disableNotification: Boolean = false,
    fromBackground: Boolean = false,
    inputMessageContents: Array<InputMessageContent> = emptyArray()
): Messages = message(
    SendMessageAlbum(
        chatId,
        replyToMessageId,
        disableNotification,
        fromBackground,
        inputMessageContents
    )
)

/**
 * Invites a bot to a chat (if it is not yet a member) and sends it the /start command
 * Bots can't be invited to a private chat other than the chat with the bot
 * Bots can't be invited to channels (although they can be added as admins) and secret chats
 * Returns the sent message
 *
 * @botUserId - Identifier of the bot
 * @chatId - Identifier of the target chat
 * @parameter - A hidden parameter sent to the bot for deep linking purposes (https://core.telegram.org/bots#deep-linking)
 */
suspend fun TelegramClient.sendBotStartMessage(
    botUserId: Int = 0,
    chatId: Long = 0L,
    parameter: String? = null
): Message = message(
    SendBotStartMessage(
        botUserId,
        chatId,
        parameter
    )
)

/**
 * Sends the result of an inline query as a message
 * Returns the sent message
 * Always clears a chat draft message
 *
 * @chatId - Target chat
 * @replyToMessageId - Identifier of a message to reply to or 0
 * @disableNotification - Pass true to disable notification for the message
 *                        Not supported in secret chats
 * @fromBackground - Pass true if the message is sent from background
 * @queryId - Identifier of the inline query
 * @resultId - Identifier of the inline result
 * @hideViaBot - If true, there will be no mention of a bot, via which the message is sent
 *               Can be used only for bots GetOption("animation_search_bot_username"), GetOption("photo_search_bot_username") and GetOption("venue_search_bot_username")
 */
suspend fun TelegramClient.sendInlineQueryResultMessage(
    chatId: Long = 0L,
    replyToMessageId: Long = 0L,
    disableNotification: Boolean = false,
    fromBackground: Boolean = false,
    queryId: Long = 0L,
    resultId: String? = null,
    hideViaBot: Boolean = false
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
 * Forwards previously sent messages
 * Returns the forwarded messages in the same order as the message identifiers passed in message_ids
 * If a message can't be forwarded, null will be returned instead of the message
 *
 * @chatId - Identifier of the chat to which to forward messages
 * @fromChatId - Identifier of the chat from which to forward messages
 * @messageIds - Identifiers of the messages to forward
 * @disableNotification - Pass true to disable notification for the message, doesn't work if messages are forwarded to a secret chat
 * @fromBackground - Pass true if the messages are sent from the background
 * @asAlbum - True, if the messages should be grouped into an album after forwarding
 *            For this to work, no more than 10 messages may be forwarded, and all of them must be photo or video messages
 * @sendCopy - True, if content of the messages needs to be copied without links to the original messages
 *             Always true if the messages are forwarded to a secret chat
 * @removeCaption - True, if media captions of message copies needs to be removed
 *                  Ignored if send_copy is false
 */
suspend fun TelegramClient.forwardMessages(
    chatId: Long = 0L,
    fromChatId: Long = 0L,
    messageIds: LongArray = longArrayOf(),
    disableNotification: Boolean = false,
    fromBackground: Boolean = false,
    asAlbum: Boolean = false,
    sendCopy: Boolean = false,
    removeCaption: Boolean = false
): Messages = message(
    ForwardMessages(
        chatId,
        fromChatId,
        messageIds,
        disableNotification,
        fromBackground,
        asAlbum,
        sendCopy,
        removeCaption
    )
)

/**
 * Resends messages which failed to send
 * Can be called only for messages for which messageSendingStateFailed.can_retry is true and after specified in messageSendingStateFailed.retry_after time passed
 * If a message is re-sent, the corresponding failed to send message is deleted
 * Returns the sent messages in the same order as the message identifiers passed in message_ids
 * If a message can't be re-sent, null will be returned instead of the message
 *
 * @chatId - Identifier of the chat to send messages
 * @messageIds - Identifiers of the messages to resend
 *               Message identifiers must be in a strictly increasing order
 */
suspend fun TelegramClient.resendMessages(
    chatId: Long = 0L,
    messageIds: LongArray = longArrayOf()
): Messages = message(
    ResendMessages(
        chatId,
        messageIds
    )
)

/**
 * Changes the current TTL setting (sets a new self-destruct timer) in a secret chat and sends the corresponding message
 *
 * @chatId - Chat identifier
 * @ttl - New TTL value, in seconds
 */
suspend fun TelegramClient.sendChatSetTtlMessage(
    chatId: Long = 0L,
    ttl: Int = 0
): Message = message(
    SendChatSetTtlMessage(
        chatId,
        ttl
    )
)

/**
 * Adds a local message to a chat
 * The message is persistent across application restarts only if the message database is used
 * Returns the added message
 *
 * @chatId - Target chat
 * @senderUserId - Identifier of the user who will be shown as the sender of the message
 *                 May be 0 for channel posts
 * @replyToMessageId - Identifier of the message to reply to or 0
 * @disableNotification - Pass true to disable notification for the message
 * @inputMessageContent - The content of the message to be added
 */
suspend fun TelegramClient.addLocalMessage(
    chatId: Long = 0L,
    senderUserId: Int = 0,
    replyToMessageId: Long = 0L,
    disableNotification: Boolean = false,
    inputMessageContent: InputMessageContent? = null
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
 * Deletes messages
 *
 * @chatId - Chat identifier
 * @messageIds - Identifiers of the messages to be deleted
 * @revoke - Pass true to try to delete messages for all chat members
 *           Always true for supergroups, channels and secret chats
 */
suspend fun TelegramClient.deleteMessages(
    chatId: Long = 0L,
    messageIds: LongArray = longArrayOf(),
    revoke: Boolean = false
): Ok = message(
    DeleteMessages(
        chatId,
        messageIds,
        revoke
    )
)

/**
 * Edits the text of a message (or a text of a game message)
 * Returns the edited message after the edit is completed on the server side
 *
 * @chatId - The chat the message belongs to
 * @messageId - Identifier of the message
 * @replyMarkup - The new message reply markup
 * @inputMessageContent - New text content of the message
 *                        Should be of type InputMessageText
 */
suspend fun TelegramClient.editMessageText(
    chatId: Long = 0L,
    messageId: Long = 0L,
    @BotsOnly replyMarkup: ReplyMarkup? = null,
    inputMessageContent: InputMessageContent? = null
): Message = message(
    EditMessageText(
        chatId,
        messageId,
        replyMarkup,
        inputMessageContent
    )
)

/**
 * Edits the message content of a live location
 * Messages can be edited for a limited period of time specified in the live location
 * Returns the edited message after the edit is completed on the server side
 *
 * @chatId - The chat the message belongs to
 * @messageId - Identifier of the message
 * @replyMarkup - The new message reply markup
 * @location - New location content of the message
 *             Pass null to stop sharing the live location
 */
suspend fun TelegramClient.editMessageLiveLocation(
    chatId: Long = 0L,
    messageId: Long = 0L,
    @BotsOnly replyMarkup: ReplyMarkup? = null,
    location: Location? = null
): Message = message(
    EditMessageLiveLocation(
        chatId,
        messageId,
        replyMarkup,
        location
    )
)

/**
 * Edits the content of a message with an animation, an audio, a document, a photo or a video
 * The media in the message can't be replaced if the message was set to self-destruct
 * Media can't be replaced by self-destructing media
 * Media in an album can be edited only to contain a photo or a video
 * Returns the edited message after the edit is completed on the server side
 *
 * @chatId - The chat the message belongs to
 * @messageId - Identifier of the message
 * @replyMarkup - The new message reply markup
 * @inputMessageContent - New content of the message
 *                        Must be one of the following types: InputMessageAnimation, InputMessageAudio, InputMessageDocument, InputMessagePhoto or InputMessageVideo
 */
suspend fun TelegramClient.editMessageMedia(
    chatId: Long = 0L,
    messageId: Long = 0L,
    @BotsOnly replyMarkup: ReplyMarkup? = null,
    inputMessageContent: InputMessageContent? = null
): Message = message(
    EditMessageMedia(
        chatId,
        messageId,
        replyMarkup,
        inputMessageContent
    )
)

/**
 * Edits the message content caption
 * Returns the edited message after the edit is completed on the server side
 *
 * @chatId - The chat the message belongs to
 * @messageId - Identifier of the message
 * @replyMarkup - The new message reply markup
 * @caption - New message content caption
 *            0-GetOption("message_caption_length_max") characters
 */
suspend fun TelegramClient.editMessageCaption(
    chatId: Long = 0L,
    messageId: Long = 0L,
    @BotsOnly replyMarkup: ReplyMarkup? = null,
    caption: FormattedText? = null
): Message = message(
    EditMessageCaption(
        chatId,
        messageId,
        replyMarkup,
        caption
    )
)

/**
 * Edits the message reply markup
 * Returns the edited message after the edit is completed on the server side
 *
 * @chatId - The chat the message belongs to
 * @messageId - Identifier of the message
 * @replyMarkup - The new message reply markup
 */
@BotsOnly
suspend fun TelegramClient.editMessageReplyMarkup(
    chatId: Long = 0L,
    messageId: Long = 0L,
    replyMarkup: ReplyMarkup? = null
): Message = message(
    EditMessageReplyMarkup(
        chatId,
        messageId,
        replyMarkup
    )
)

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
 * Informs TDLib that messages are being viewed by the user
 * Many useful activities depend on whether the messages are currently being viewed or not (e.g., marking messages as read, incrementing a view counter, updating a view counter, removing deleted messages in supergroups and channels)
 *
 * @chatId - Chat identifier
 * @messageIds - The identifiers of the messages being viewed
 * @forceRead - True, if messages in closed chats should be marked as read
 */
suspend fun TelegramClient.viewMessages(
    chatId: Long = 0L,
    messageIds: LongArray = longArrayOf(),
    forceRead: Boolean = false
): Ok = message(
    ViewMessages(
        chatId,
        messageIds,
        forceRead
    )
)

/**
 * Informs TDLib that the message content has been opened (e.g., the user has opened a photo, video, document, location or venue, or has listened to an audio file or voice note message)
 * An updateMessageContentOpened update will be generated if something has changed
 *
 * @chatId - Chat identifier of the message
 * @messageId - Identifier of the message with the opened content
 */
suspend fun TelegramClient.openMessageContent(
    chatId: Long = 0L,
    messageId: Long = 0L
): Ok = message(
    OpenMessageContent(
        chatId,
        messageId
    )
)

/**
 * Clears draft messages in all chats
 *
 * @excludeSecretChats - If true, local draft messages in secret chats will not be cleared
 */
suspend fun TelegramClient.clearAllDraftMessages(
    excludeSecretChats: Boolean = false
): Ok = message(
    ClearAllDraftMessages(
        excludeSecretChats
    )
)
