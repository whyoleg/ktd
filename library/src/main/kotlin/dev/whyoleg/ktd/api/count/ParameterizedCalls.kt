@file:Suppress("unused")

package dev.whyoleg.ktd.api.count

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns approximate number of messages of the specified type in the chat
 *
 * @chatId - Identifier of the chat in which to count messages
 * @filter - Filter for message content; searchMessagesFilterEmpty is unsupported in this function
 * @returnLocal - If true, returns count that is available locally without sending network requests, returning -1 if the number of messages is unknown
 */
suspend fun TelegramClient.getChatMessageCount(
    chatId: Long,
    filter: SearchMessagesFilter,
    returnLocal: Boolean
): Count = count(
    GetChatMessageCount(
        chatId,
        filter,
        returnLocal
    )
)

/**
 * Returns file downloaded prefix size from a given offset
 *
 * @fileId - Identifier of the file
 * @offset - Offset from which downloaded prefix size should be calculated
 */
suspend fun TelegramClient.getFileDownloadedPrefixSize(
    fileId: Int,
    offset: Int
): Count = count(
    GetFileDownloadedPrefixSize(
        fileId,
        offset
    )
)

/**
 * Returns the total number of imported contacts
 */
suspend fun TelegramClient.getImportedContactCount(): Count = count(
    GetImportedContactCount()
)
