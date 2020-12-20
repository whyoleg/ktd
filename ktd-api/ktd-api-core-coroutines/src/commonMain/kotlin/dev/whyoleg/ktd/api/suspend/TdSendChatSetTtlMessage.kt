package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the current TTL setting (sets a new self-destruct timer) in a secret chat and sends the corresponding message
 *
 * @property chatId Chat identifier
 * @property ttl New TTL value, in seconds
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.sendChatSetTtlMessage(
    chatId: Long = 0L,
    ttl: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdMessage = exec(TdSendChatSetTtlMessage(chatId, ttl, extra))
