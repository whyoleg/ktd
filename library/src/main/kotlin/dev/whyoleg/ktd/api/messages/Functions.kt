@file:Suppress("unused")

package dev.whyoleg.ktd.api.messages

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about messages. If a message is not found, returns null on the corresponding position of the result
 */
suspend fun TelegramClient.messages(
    f: GetMessages
): Messages = execRaw(f) as Messages

/**
 * Returns messages in a chat. The messages are returned in a reverse chronological order (i.e., in order of decreasing message_id).
 * For optimal performance the number of returned messages is chosen by the library. This is an offline request if onlyLocal is true
 */
suspend fun TelegramClient.messages(
    f: GetChatHistory
): Messages = execRaw(f) as Messages

/**
 * Searches for messages with given words in the chat. Returns the results in reverse chronological order, i.e. in order of decreasing message_id. Cannot be used in secret chats with a non-empty query
 * (searchSecretMessages should be used instead), or without an enabled message database. For optimal performance the number of returned messages is chosen by the library
 */
suspend fun TelegramClient.messages(
    f: SearchChatMessages
): Messages = execRaw(f) as Messages

/**
 * Searches for messages in all chats except secret chats. Returns the results in reverse chronological order (i.e., in order of decreasing (date, chat_id, message_id)).
 * For optimal performance the number of returned messages is chosen by the library
 */
suspend fun TelegramClient.messages(
    f: SearchMessages
): Messages = execRaw(f) as Messages

/**
 * Searches for call messages. Returns the results in reverse chronological order (i. e., in order of decreasing message_id). For optimal performance the number of returned messages is chosen by the library
 */
suspend fun TelegramClient.messages(
    f: SearchCallMessages
): Messages = execRaw(f) as Messages

/**
 * Returns information about the recent locations of chat members that were sent to the chat. Returns up to 1 location message per user
 */
suspend fun TelegramClient.messages(
    f: SearchChatRecentLocationMessages
): Messages = execRaw(f) as Messages

/**
 * Returns all active live locations that should be updated by the client. The list is persistent across application restarts only if the message database is used
 */
suspend fun TelegramClient.messages(
    f: GetActiveLiveLocationMessages
): Messages = execRaw(f) as Messages

/**
 * Sends messages grouped together into an album. Currently only photo and video messages can be grouped into an album. Returns sent messages
 */
suspend fun TelegramClient.messages(
    f: SendMessageAlbum
): Messages = execRaw(f) as Messages

/**
 * Forwards previously sent messages. Returns the forwarded messages in the same order as the message identifiers passed in messageIds. If a message can't be forwarded, null will be returned instead of the message
 */
suspend fun TelegramClient.messages(
    f: ForwardMessages
): Messages = execRaw(f) as Messages

/**
 * Resends messages which failed to send. Can be called only for messages for which messageSendingStateFailed.can_retry is true and after specified in messageSendingStateFailed.retry_after time passed.
 * If a message is re-sent, the corresponding failed to send message is deleted. Returns the sent messages in the same order as the message identifiers passed in messageIds. If a message can't be re-sent, null will be returned instead of the message
 */
suspend fun TelegramClient.messages(
    f: ResendMessages
): Messages = execRaw(f) as Messages

/**
 * Deletes messages
 */
suspend fun TelegramClient.messages(
    f: DeleteMessages
): Ok = execRaw(f) as Ok

/**
 * Informs TDLib that messages are being viewed by the user. Many useful activities depend on whether the messages are currently being viewed or not (e.g., marking messages as read, incrementing a view counter, updating a view counter, removing deleted messages in supergroups and channels)
 */
suspend fun TelegramClient.messages(
    f: ViewMessages
): Ok = execRaw(f) as Ok

/**
 * Clears draft messages in all chats
 */
suspend fun TelegramClient.messages(
    f: ClearAllDraftMessages
): Ok = execRaw(f) as Ok
