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
 */
suspend fun TelegramClient.message(
    f: GetMessage
): Message = exec(f) as Message

/**
 * Returns information about a message, if it is available locally without sending network request
 * This is an offline request
 */
suspend fun TelegramClient.message(
    f: GetMessageLocally
): Message = exec(f) as Message

/**
 * Returns information about a message that is replied by given message
 */
suspend fun TelegramClient.message(
    f: GetRepliedMessage
): Message = exec(f) as Message

/**
 * Returns information about a pinned chat message
 */
suspend fun TelegramClient.message(
    f: GetChatPinnedMessage
): Message = exec(f) as Message

/**
 * Returns information about messages
 * If a message is not found, returns null on the corresponding position of the result
 */
suspend fun TelegramClient.message(
    f: GetMessages
): Messages = exec(f) as Messages

/**
 * Returns messages in a chat
 * The messages are returned in a reverse chronological order (i.e., in order of decreasing message_id)
 * For optimal performance the number of returned messages is chosen by the library
 * This is an offline request if only_local is true
 */
suspend fun TelegramClient.message(
    f: GetChatHistory
): Messages = exec(f) as Messages

/**
 * Searches for messages with given words in the chat
 * Returns the results in reverse chronological order, i.e
 * In order of decreasing message_id
 * Cannot be used in secret chats with a non-empty query (searchSecretMessages should be used instead), or without an enabled message database
 * For optimal performance the number of returned messages is chosen by the library
 */
suspend fun TelegramClient.message(
    f: SearchChatMessages
): Messages = exec(f) as Messages

/**
 * Searches for messages in all chats except secret chats
 * Returns the results in reverse chronological order (i.e., in order of decreasing (date, chat_id, message_id))
 * For optimal performance the number of returned messages is chosen by the library
 */
suspend fun TelegramClient.message(
    f: SearchMessages
): Messages = exec(f) as Messages

/**
 * Searches for messages in secret chats
 * Returns the results in reverse chronological order
 * For optimal performance the number of returned messages is chosen by the library
 */
suspend fun TelegramClient.message(
    f: SearchSecretMessages
): FoundMessages = exec(f) as FoundMessages

/**
 * Searches for call messages
 * Returns the results in reverse chronological order (i
 * E., in order of decreasing message_id)
 * For optimal performance the number of returned messages is chosen by the library
 */
suspend fun TelegramClient.message(
    f: SearchCallMessages
): Messages = exec(f) as Messages

/**
 * Returns information about the recent locations of chat members that were sent to the chat
 * Returns up to 1 location message per user
 */
suspend fun TelegramClient.message(
    f: SearchChatRecentLocationMessages
): Messages = exec(f) as Messages

/**
 * Returns all active live locations that should be updated by the client
 * The list is persistent across application restarts only if the message database is used
 */
suspend fun TelegramClient.message(
    f: GetActiveLiveLocationMessages
): Messages = exec(f) as Messages

/**
 * Returns the last message sent in a chat no later than the specified date
 */
suspend fun TelegramClient.message(
    f: GetChatMessageByDate
): Message = exec(f) as Message

/**
 * Returns a public HTTPS link to a message
 * Available only for messages in supergroups and channels with username
 */
suspend fun TelegramClient.message(
    f: GetPublicMessageLink
): PublicMessageLink = exec(f) as PublicMessageLink

/**
 * Returns a private HTTPS link to a message in a chat
 * Available only for already sent messages in supergroups and channels
 * The link will work only for members of the chat
 */
suspend fun TelegramClient.message(
    f: GetMessageLink
): HttpUrl = exec(f) as HttpUrl

/**
 * Returns information about a public or private message link
 */
suspend fun TelegramClient.message(
    f: GetMessageLinkInfo
): MessageLinkInfo = exec(f) as MessageLinkInfo

/**
 * Sends a message
 * Returns the sent message
 */
suspend fun TelegramClient.message(
    f: SendMessage
): Message = exec(f) as Message

/**
 * Sends messages grouped together into an album
 * Currently only photo and video messages can be grouped into an album
 * Returns sent messages
 */
suspend fun TelegramClient.message(
    f: SendMessageAlbum
): Messages = exec(f) as Messages

/**
 * Invites a bot to a chat (if it is not yet a member) and sends it the /start command
 * Bots can't be invited to a private chat other than the chat with the bot
 * Bots can't be invited to channels (although they can be added as admins) and secret chats
 * Returns the sent message
 */
suspend fun TelegramClient.message(
    f: SendBotStartMessage
): Message = exec(f) as Message

/**
 * Sends the result of an inline query as a message
 * Returns the sent message
 * Always clears a chat draft message
 */
suspend fun TelegramClient.message(
    f: SendInlineQueryResultMessage
): Message = exec(f) as Message

/**
 * Forwards previously sent messages
 * Returns the forwarded messages in the same order as the message identifiers passed in message_ids
 * If a message can't be forwarded, null will be returned instead of the message
 */
suspend fun TelegramClient.message(
    f: ForwardMessages
): Messages = exec(f) as Messages

/**
 * Resends messages which failed to send
 * Can be called only for messages for which messageSendingStateFailed.can_retry is true and after specified in messageSendingStateFailed.retry_after time passed
 * If a message is re-sent, the corresponding failed to send message is deleted
 * Returns the sent messages in the same order as the message identifiers passed in message_ids
 * If a message can't be re-sent, null will be returned instead of the message
 */
suspend fun TelegramClient.message(
    f: ResendMessages
): Messages = exec(f) as Messages

/**
 * Changes the current TTL setting (sets a new self-destruct timer) in a secret chat and sends the corresponding message
 */
suspend fun TelegramClient.message(
    f: SendChatSetTtlMessage
): Message = exec(f) as Message

/**
 * Adds a local message to a chat
 * The message is persistent across application restarts only if the message database is used
 * Returns the added message
 */
suspend fun TelegramClient.message(
    f: AddLocalMessage
): Message = exec(f) as Message

/**
 * Deletes messages
 */
suspend fun TelegramClient.message(
    f: DeleteMessages
): Ok = exec(f) as Ok

/**
 * Edits the text of a message (or a text of a game message)
 * Returns the edited message after the edit is completed on the server side
 */
suspend fun TelegramClient.message(
    f: EditMessageText
): Message = exec(f) as Message

/**
 * Edits the message content of a live location
 * Messages can be edited for a limited period of time specified in the live location
 * Returns the edited message after the edit is completed on the server side
 */
suspend fun TelegramClient.message(
    f: EditMessageLiveLocation
): Message = exec(f) as Message

/**
 * Edits the content of a message with an animation, an audio, a document, a photo or a video
 * The media in the message can't be replaced if the message was set to self-destruct
 * Media can't be replaced by self-destructing media
 * Media in an album can be edited only to contain a photo or a video
 * Returns the edited message after the edit is completed on the server side
 */
suspend fun TelegramClient.message(
    f: EditMessageMedia
): Message = exec(f) as Message

/**
 * Edits the message content caption
 * Returns the edited message after the edit is completed on the server side
 */
suspend fun TelegramClient.message(
    f: EditMessageCaption
): Message = exec(f) as Message

/**
 * Edits the message reply markup
 * Returns the edited message after the edit is completed on the server side
 */
@BotsOnly
suspend fun TelegramClient.message(
    f: EditMessageReplyMarkup
): Message = exec(f) as Message

/**
 * Updates the game score of the specified user in the game
 */
@BotsOnly
suspend fun TelegramClient.message(
    f: SetGameScore
): Message = exec(f) as Message

/**
 * Informs TDLib that messages are being viewed by the user
 * Many useful activities depend on whether the messages are currently being viewed or not (e.g., marking messages as read, incrementing a view counter, updating a view counter, removing deleted messages in supergroups and channels)
 */
suspend fun TelegramClient.message(
    f: ViewMessages
): Ok = exec(f) as Ok

/**
 * Informs TDLib that the message content has been opened (e.g., the user has opened a photo, video, document, location or venue, or has listened to an audio file or voice note message)
 * An updateMessageContentOpened update will be generated if something has changed
 */
suspend fun TelegramClient.message(
    f: OpenMessageContent
): Ok = exec(f) as Ok

/**
 * Clears draft messages in all chats
 */
suspend fun TelegramClient.message(
    f: ClearAllDraftMessages
): Ok = exec(f) as Ok
