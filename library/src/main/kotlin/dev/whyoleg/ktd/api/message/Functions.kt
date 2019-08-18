@file:Suppress("unused")

package dev.whyoleg.ktd.api.message

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about a message
 */
suspend fun TelegramClient.message(
    f: GetMessage
): Message = execRaw(f) as Message

/**
 * Returns information about a message, if it is available locally without sending network request. This is an offline request
 */
suspend fun TelegramClient.message(
    f: GetMessageLocally
): Message = execRaw(f) as Message

/**
 * Returns information about a message that is replied by given message
 */
suspend fun TelegramClient.message(
    f: GetRepliedMessage
): Message = execRaw(f) as Message

/**
 * Returns information about a pinned chat message
 */
suspend fun TelegramClient.message(
    f: GetChatPinnedMessage
): Message = execRaw(f) as Message

/**
 * Returns the last message sent in a chat no later than the specified date
 */
suspend fun TelegramClient.message(
    f: GetChatMessageByDate
): Message = execRaw(f) as Message

/**
 * Sends a message. Returns the sent message
 */
suspend fun TelegramClient.message(
    f: SendMessage
): Message = execRaw(f) as Message

/**
 * Invites a bot to a chat (if it is not yet a member) and sends it the /start command. Bots can't be invited to a private chat other than the chat with the bot. Bots can't be invited to channels (although they can be added as admins) and secret chats. Returns the sent message
 */
suspend fun TelegramClient.message(
    f: SendBotStartMessage
): Message = execRaw(f) as Message

/**
 * Sends the result of an inline query as a message. Returns the sent message. Always clears a chat draft message
 */
suspend fun TelegramClient.message(
    f: SendInlineQueryResultMessage
): Message = execRaw(f) as Message

/**
 * Changes the current TTL setting (sets a new self-destruct timer) in a secret chat and sends the corresponding message
 */
suspend fun TelegramClient.message(
    f: SendChatSetTtlMessage
): Message = execRaw(f) as Message

/**
 * Adds a local message to a chat. The message is persistent across application restarts only if the message database is used. Returns the added message
 */
suspend fun TelegramClient.message(
    f: AddLocalMessage
): Message = execRaw(f) as Message

/**
 * Edits the text of a message (or a text of a game message). Returns the edited message after the edit is completed on the server side
 */
suspend fun TelegramClient.message(
    f: EditMessageText
): Message = execRaw(f) as Message

/**
 * Edits the message content of a live location. Messages can be edited for a limited period of time specified in the live location. Returns the edited message after the edit is completed on the server side
 */
suspend fun TelegramClient.message(
    f: EditMessageLiveLocation
): Message = execRaw(f) as Message

/**
 * Edits the content of a message with an animation, an audio, a document, a photo or a video. The media in the message can't be replaced if the message was set to self-destruct. Media can't be replaced by self-destructing media. Media in an album can be edited only to contain a photo or a video. Returns the edited message after the edit is completed on the server side
 */
suspend fun TelegramClient.message(
    f: EditMessageMedia
): Message = execRaw(f) as Message

/**
 * Edits the message content caption. Returns the edited message after the edit is completed on the server side
 */
suspend fun TelegramClient.message(
    f: EditMessageCaption
): Message = execRaw(f) as Message

/**
 * Edits the message reply markup; for bots only. Returns the edited message after the edit is completed on the server side
 */
suspend fun TelegramClient.message(
    f: EditMessageReplyMarkup
): Message = execRaw(f) as Message

/**
 * Updates the game score of the specified user in the game; for bots only
 */
suspend fun TelegramClient.message(
    f: SetGameScore
): Message = execRaw(f) as Message

/**
 * Informs TDLib that the message content has been opened (e.g., the user has opened a photo, video, document, location or venue, or has listened to an audio file or voice note message). An updateMessageContentOpened update will be generated if something has changed
 */
suspend fun TelegramClient.message(
    f: OpenMessageContent
): Ok = execRaw(f) as Ok
