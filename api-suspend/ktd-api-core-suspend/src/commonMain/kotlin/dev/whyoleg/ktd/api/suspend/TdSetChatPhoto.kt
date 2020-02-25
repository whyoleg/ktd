package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the photo of a chat
 * Supported only for basic groups, supergroups and channels
 * Requires can_change_info rights
 * The photo will not be changed before request to the server has been completed
 *
 * @property chatId Chat identifier
 * @property photo New chat photo
 *                 You can use a zero InputFileId to delete the chat photo
 *                 Files that are accessible only by HTTP URL are not acceptable
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setChatPhoto(
    chatId: Long = 0L,
    photo: TdInputFile? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetChatPhoto(chatId, photo, extra))
