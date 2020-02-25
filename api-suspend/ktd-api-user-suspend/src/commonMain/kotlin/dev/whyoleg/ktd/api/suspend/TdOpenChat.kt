package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Informs TDLib that the chat is opened by the user
 * Many useful activities depend on the chat being opened or closed (e.g., in supergroups and channels all updates are received only for opened chats)
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.openChat(chatId: Long = 0L, extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdOpenChat(chatId, extra))
