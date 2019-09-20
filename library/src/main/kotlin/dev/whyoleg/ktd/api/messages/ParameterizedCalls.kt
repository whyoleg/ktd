@file:Suppress("unused")

package dev.whyoleg.ktd.api.messages

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about messages. If a message is not found, returns null on the corresponding position of the result
 *
 * @chatId - Identifier of the chat the messages belong to
 * @messageIds - Identifiers of the messages to get
 */
suspend fun TelegramClient.getMessages(
    chatId: Long,
    messageIds: LongArray
): Messages = messages(
    GetMessages(
        chatId,
        messageIds
    )
)

/**
 * Returns messages in a chat. The messages are returned in a reverse chronological order (i.e., in order of decreasing message_id).
 * For optimal performance the number of returned messages is chosen by the library. This is an offline request if onlyLocal is true
 *
 * @chatId - Chat identifier
 * @fromMessageId - Identifier of the message starting from which history must be fetched; use 0 to get results from the last message
 * @offset - Specify 0 to get results from exactly the from_message_id or a negative offset up to 99 to get additionally some newer messages
 * @limit - The maximum number of messages to be returned; must be positive and can't be greater than 100. If the offset is negative, the limit must be greater or equal to -offset. Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 * @onlyLocal - If true, returns only messages that are available locally without sending network requests
 */
suspend fun TelegramClient.getChatHistory(
    chatId: Long,
    fromMessageId: Long,
    offset: Int,
    limit: Int,
    onlyLocal: Boolean
): Messages = messages(
    GetChatHistory(
        chatId,
        fromMessageId,
        offset,
        limit,
        onlyLocal
    )
)

/**
 * Searches for messages with given words in the chat. Returns the results in reverse chronological order, i.e. in order of decreasing message_id. Cannot be used in secret chats with a non-empty query
 * (searchSecretMessages should be used instead), or without an enabled message database. For optimal performance the number of returned messages is chosen by the library
 *
 * @chatId - Identifier of the chat in which to search messages
 * @query - Query to search for
 * @senderUserId - If not 0, only messages sent by the specified user will be returned. Not supported in secret chats
 * @fromMessageId - Identifier of the message starting from which history must be fetched; use 0 to get results from the last message
 * @offset - Specify 0 to get results from exactly the from_message_id or a negative offset to get the specified message and some newer messages
 * @limit - The maximum number of messages to be returned; must be positive and can't be greater than 100. If the offset is negative, the limit must be greater than -offset. Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 * @filter - Filter for message content in the search results
 */
suspend fun TelegramClient.searchChatMessages(
    chatId: Long,
    query: String,
    senderUserId: Int,
    fromMessageId: Long,
    offset: Int,
    limit: Int,
    filter: SearchMessagesFilter
): Messages = messages(
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
 * Searches for messages in all chats except secret chats. Returns the results in reverse chronological order (i.e., in order of decreasing (date, chat_id, message_id)).
 * For optimal performance the number of returned messages is chosen by the library
 *
 * @query - Query to search for
 * @offsetDate - The date of the message starting from which the results should be fetched. Use 0 or any date in the future to get results from the last message
 * @offsetChatId - The chat identifier of the last found message, or 0 for the first request
 * @offsetMessageId - The message identifier of the last found message, or 0 for the first request
 * @limit - The maximum number of messages to be returned, up to 100. Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 */
suspend fun TelegramClient.searchMessages(
    query: String,
    offsetDate: Int,
    offsetChatId: Long,
    offsetMessageId: Long,
    limit: Int
): Messages = messages(
    SearchMessages(
        query,
        offsetDate,
        offsetChatId,
        offsetMessageId,
        limit
    )
)

/**
 * Searches for call messages. Returns the results in reverse chronological order (i. e., in order of decreasing message_id). For optimal performance the number of returned messages is chosen by the library
 *
 * @fromMessageId - Identifier of the message from which to search; use 0 to get results from the last message
 * @limit - The maximum number of messages to be returned; up to 100. Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
 * @onlyMissed - If true, returns only messages with missed calls
 */
suspend fun TelegramClient.searchCallMessages(
    fromMessageId: Long,
    limit: Int,
    onlyMissed: Boolean
): Messages = messages(
    SearchCallMessages(
        fromMessageId,
        limit,
        onlyMissed
    )
)

/**
 * Returns information about the recent locations of chat members that were sent to the chat. Returns up to 1 location message per user
 *
 * @chatId - Chat identifier
 * @limit - Maximum number of messages to be returned
 */
suspend fun TelegramClient.searchChatRecentLocationMessages(
    chatId: Long,
    limit: Int
): Messages = messages(
    SearchChatRecentLocationMessages(
        chatId,
        limit
    )
)

/**
 * Returns all active live locations that should be updated by the client. The list is persistent across application restarts only if the message database is used
 */
suspend fun TelegramClient.getActiveLiveLocationMessages(): Messages = messages(
    GetActiveLiveLocationMessages()
)

/**
 * Sends messages grouped together into an album. Currently only photo and video messages can be grouped into an album. Returns sent messages
 *
 * @chatId - Target chat
 * @replyToMessageId - Identifier of a message to reply to or 0
 * @disableNotification - Pass true to disable notification for the messages. Not supported in secret chats
 * @fromBackground - Pass true if the messages are sent from the background
 * @inputMessageContents - Contents of messages to be sent
 */
suspend fun TelegramClient.sendMessageAlbum(
    chatId: Long,
    replyToMessageId: Long,
    disableNotification: Boolean,
    fromBackground: Boolean,
    inputMessageContents: Array<InputMessageContent>
): Messages = messages(
    SendMessageAlbum(
        chatId,
        replyToMessageId,
        disableNotification,
        fromBackground,
        inputMessageContents
    )
)

/**
 * Forwards previously sent messages. Returns the forwarded messages in the same order as the message identifiers passed in messageIds. If a message can't be forwarded, null will be returned instead of the message
 *
 * @chatId - Identifier of the chat to which to forward messages
 * @fromChatId - Identifier of the chat from which to forward messages
 * @messageIds - Identifiers of the messages to forward
 * @disableNotification - Pass true to disable notification for the message, doesn't work if messages are forwarded to a secret chat
 * @fromBackground - Pass true if the messages are sent from the background
 * @asAlbum - True, if the messages should be grouped into an album after forwarding. For this to work, no more than 10 messages may be forwarded, and all of them must be photo or video messages
 * @sendCopy - True, if content of the messages needs to be copied without links to the original messages. Always true if the messages are forwarded to a secret chat
 * @removeCaption - True, if media captions of message copies needs to be removed. Ignored if send_copy is false
 */
suspend fun TelegramClient.forwardMessages(
    chatId: Long,
    fromChatId: Long,
    messageIds: LongArray,
    disableNotification: Boolean,
    fromBackground: Boolean,
    asAlbum: Boolean,
    sendCopy: Boolean,
    removeCaption: Boolean
): Messages = messages(
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
 * Resends messages which failed to send. Can be called only for messages for which messageSendingStateFailed.can_retry is true and after specified in messageSendingStateFailed.retry_after time passed.
 * If a message is re-sent, the corresponding failed to send message is deleted. Returns the sent messages in the same order as the message identifiers passed in messageIds. If a message can't be re-sent, null will be returned instead of the message
 *
 * @chatId - Identifier of the chat to send messages
 * @messageIds - Identifiers of the messages to resend. Message identifiers must be in a strictly increasing order
 */
suspend fun TelegramClient.resendMessages(
    chatId: Long,
    messageIds: LongArray
): Messages = messages(
    ResendMessages(
        chatId,
        messageIds
    )
)

/**
 * Deletes messages
 *
 * @chatId - Chat identifier
 * @messageIds - Identifiers of the messages to be deleted
 * @revoke - Pass true to try to delete messages for all chat members. Always true for supergroups, channels and secret chats
 */
suspend fun TelegramClient.deleteMessages(
    chatId: Long,
    messageIds: LongArray,
    revoke: Boolean
): Ok = messages(
    DeleteMessages(
        chatId,
        messageIds,
        revoke
    )
)

/**
 * Informs TDLib that messages are being viewed by the user. Many useful activities depend on whether the messages are currently being viewed or not (e.g., marking messages as read, incrementing a view counter, updating a view counter, removing deleted messages in supergroups and channels)
 *
 * @chatId - Chat identifier
 * @messageIds - The identifiers of the messages being viewed
 * @forceRead - True, if messages in closed chats should be marked as read
 */
suspend fun TelegramClient.viewMessages(
    chatId: Long,
    messageIds: LongArray,
    forceRead: Boolean
): Ok = messages(
    ViewMessages(
        chatId,
        messageIds,
        forceRead
    )
)

/**
 * Clears draft messages in all chats
 *
 * @excludeSecretChats - If true, local draft messages in secret chats will not be cleared
 */
suspend fun TelegramClient.clearAllDraftMessages(
    excludeSecretChats: Boolean
): Ok = messages(
    ClearAllDraftMessages(
        excludeSecretChats
    )
)
