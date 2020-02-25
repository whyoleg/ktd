package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about a button of type inlineKeyboardButtonTypeLoginUrl
 * The method needs to be called when the user presses the button
 *
 * @property chatId Chat identifier of the message with the button
 * @property messageId Message identifier of the message with the button
 * @property buttonId Button identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getLoginUrlInfo(
    chatId: Long = 0L,
    messageId: Long = 0L,
    buttonId: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdLoginUrlInfo = exec(TdGetLoginUrlInfo(chatId, messageId, buttonId, extra))
