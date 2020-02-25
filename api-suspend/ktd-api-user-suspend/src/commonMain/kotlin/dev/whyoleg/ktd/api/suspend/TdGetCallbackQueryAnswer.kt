package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sends a callback query to a bot and returns an answer
 * Returns an error with code 502 if the bot fails to answer the query before the query timeout expires
 *
 * @property chatId Identifier of the chat with the message
 * @property messageId Identifier of the message from which the query originated
 * @property payload Query payload
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getCallbackQueryAnswer(
    chatId: Long = 0L,
    messageId: Long = 0L,
    payload: TdCallbackQueryPayload? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdCallbackQueryAnswer = exec(TdGetCallbackQueryAnswer(chatId, messageId, payload, extra))
