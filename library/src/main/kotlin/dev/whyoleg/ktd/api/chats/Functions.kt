@file:Suppress("unused")

package dev.whyoleg.ktd.api.chats

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns an ordered list of chats. Chats are sorted by the pair (order, chat_id) in decreasing order. (For example, to get a list of chats from the beginning, the offsetOrder should be equal to a biggest signed 64-bit number 9223372036854775807 == 2^63 - 1).
 * For optimal performance the number of returned chats is chosen by the library.
 */
suspend fun TelegramClient.chats(
    f: GetChats
): Chats = execRaw(f) as Chats

/**
 * Searches public chats by looking for specified query in their username and title. Currently only private chats, supergroups and channels can be public. Returns a meaningful number of results. Returns nothing if the length of the searched username prefix is less than 5. Excludes private chats with contacts and chats from the chat list from the results
 */
suspend fun TelegramClient.chats(
    f: SearchPublicChats
): Chats = execRaw(f) as Chats

/**
 * Searches for the specified query in the title and username of already known chats, this is an offline request. Returns chats in the order seen in the chat list
 */
suspend fun TelegramClient.chats(
    f: SearchChats
): Chats = execRaw(f) as Chats

/**
 * Searches for the specified query in the title and username of already known chats via request to the server. Returns chats in the order seen in the chat list
 */
suspend fun TelegramClient.chats(
    f: SearchChatsOnServer
): Chats = execRaw(f) as Chats

/**
 * Returns a list of frequently used chats. Supported only if the chat info database is enabled
 */
suspend fun TelegramClient.chats(
    f: GetTopChats
): Chats = execRaw(f) as Chats

/**
 * Returns a list of public chats created by the user
 */
suspend fun TelegramClient.chats(
    f: GetCreatedPublicChats
): Chats = execRaw(f) as Chats

/**
 * Returns a list of common group chats with a given user. Chats are sorted by their type and creation date
 */
suspend fun TelegramClient.chats(
    f: GetGroupsInCommon
): Chats = execRaw(f) as Chats

/**
 * Returns list of chats with non-default notification settings
 */
suspend fun TelegramClient.chats(
    f: GetChatNotificationSettingsExceptions
): Chats = execRaw(f) as Chats

/**
 * Changes the order of pinned chats
 */
suspend fun TelegramClient.chats(
    f: SetPinnedChats
): Ok = execRaw(f) as Ok
