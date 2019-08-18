@file:Suppress("unused")

package dev.whyoleg.ktd.api.found

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Adds a chat to the list of recently found chats. The chat is added to the beginning of the list. If the chat is already in the list, it will be removed from the list first
 */
suspend fun TelegramClient.found(
    f: AddRecentlyFoundChat
): Ok = execRaw(f) as Ok

/**
 * Removes a chat from the list of recently found chats
 */
suspend fun TelegramClient.found(
    f: RemoveRecentlyFoundChat
): Ok = execRaw(f) as Ok

/**
 * Clears the list of recently found chats
 */
suspend fun TelegramClient.found(
    f: ClearRecentlyFoundChats
): Ok = execRaw(f) as Ok

/**
 * Searches for messages in secret chats. Returns the results in reverse chronological order. For optimal performance the number of returned messages is chosen by the library
 */
suspend fun TelegramClient.found(
    f: SearchSecretMessages
): FoundMessages = execRaw(f) as FoundMessages
