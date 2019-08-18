@file:Suppress("unused")

package dev.whyoleg.ktd.api.count

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns approximate number of messages of the specified type in the chat
 */
suspend fun TelegramClient.count(
    f: GetChatMessageCount
): Count = execRaw(f) as Count

/**
 * Returns file downloaded prefix size from a given offset
 */
suspend fun TelegramClient.count(
    f: GetFileDownloadedPrefixSize
): Count = execRaw(f) as Count

/**
 * Returns the total number of imported contacts
 */
suspend fun TelegramClient.count(
    f: GetImportedContactCount
): Count = execRaw(f) as Count
