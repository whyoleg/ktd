package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Invites a bot to a chat (if it is not yet a member) and sends it the /start command
 * Bots can't be invited to a private chat other than the chat with the bot
 * Bots can't be invited to channels (although they can be added as admins) and secret chats
 * Returns the sent message
 *
 * @property botUserId Identifier of the bot
 * @property chatId Identifier of the target chat
 * @property parameter A hidden parameter sent to the bot for deep linking purposes (https://core.telegram.org/bots#deep-linking)
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("sendBotStartMessage")
data class TdSendBotStartMessage(
    @SerialName("bot_user_id")
    val botUserId: Int = 0,
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("parameter")
    val parameter: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessage> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSendBotStartMessage {
        return copy(extra = extra.copy(id = id))
    }
}
