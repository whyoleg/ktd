package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about a chat by its identifier, this is an offline request if the current user is not a bot
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getChat(chatId: Long = 0L, extra: TdExtra = TdExtra.EMPTY): TdChat =
        exec(TdGetChat(chatId, extra))
