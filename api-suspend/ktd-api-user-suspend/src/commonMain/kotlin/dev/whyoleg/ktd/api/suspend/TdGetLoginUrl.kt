package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns an HTTP URL which can be used to automatically authorize the user on a website after clicking an inline button of type inlineKeyboardButtonTypeLoginUrl
 * Use the method getLoginUrlInfo to find whether a prior user confirmation is needed
 * If an error is returned, then the button must be handled as an ordinary URL button
 *
 * @property chatId Chat identifier of the message with the button
 * @property messageId Message identifier of the message with the button
 * @property buttonId Button identifier
 * @property allowWriteAccess True, if the user allowed the bot to send them messages
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getLoginUrl(
    chatId: Long = 0L,
    messageId: Long = 0L,
    buttonId: Int = 0,
    allowWriteAccess: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdHttpUrl = exec(TdGetLoginUrl(chatId, messageId, buttonId, allowWriteAccess, extra))
