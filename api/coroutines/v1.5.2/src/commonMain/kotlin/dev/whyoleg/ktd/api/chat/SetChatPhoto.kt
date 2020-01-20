@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.chat

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Changes the photo of a chat
 * Supported only for basic groups, supergroups and channels
 * Requires can_change_info rights
 * The photo will not be changed before request to the server has been completed
 *
 * @chatId - Chat identifier
 * @photo - New chat photo
 *          You can use a zero InputFileId to delete the chat photo
 *          Files that are accessible only by HTTP URL are not acceptable
 */
suspend fun TelegramClient.setChatPhoto(
    chatId: Long = 0L,
    photo: InputFile? = null
): Ok = chat(
    SetChatPhoto(
        chatId,
        photo
    )
)

/**
 * Changes the photo of a chat
 * Supported only for basic groups, supergroups and channels
 * Requires can_change_info rights
 * The photo will not be changed before request to the server has been completed
 */
suspend fun TelegramClient.chat(
    f: SetChatPhoto
): Ok = exec(f) as Ok
