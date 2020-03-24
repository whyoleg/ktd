package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Informs TDLib that the chat is closed by the user
 * Many useful activities depend on the chat being opened or closed
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.closeChat(chatId: Long = 0L, extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdCloseChat(chatId, extra))
