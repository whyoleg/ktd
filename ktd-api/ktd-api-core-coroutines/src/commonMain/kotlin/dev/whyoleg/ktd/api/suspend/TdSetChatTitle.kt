package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the chat title
 * Supported only for basic groups, supergroups and channels
 * Requires can_change_info rights
 * The title will not be changed until the request to the server has been completed
 *
 * @property chatId Chat identifier
 * @property title New title of the chat
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setChatTitle(
    chatId: Long = 0L,
    title: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetChatTitle(chatId, title, extra))
