package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the location of a chat
 * Available only for some location-based supergroups, use supergroupFullInfo.can_set_location to check whether the method is allowed to use
 *
 * @property chatId Chat identifier
 * @property location New location for the chat
 *                    Must be valid and not null
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setChatLocation(
    chatId: Long = 0L,
    location: TdChatLocation? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetChatLocation(chatId, location, extra))
