package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Updates the game score of the specified user in the game
 *
 * @property chatId The chat to which the message with the game belongs
 * @property messageId Identifier of the message
 * @property editMessage True, if the message should be edited
 * @property userId User identifier
 * @property score The new score
 * @property force Pass true to update the score even if it decreases
 *                 If the score is 0, the user will be deleted from the high score table
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setGameScore")
data class TdSetGameScore(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("edit_message")
    val editMessage: Boolean = false,
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("score")
    val score: Int = 0,
    @SerialName("force")
    val force: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessage> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetGameScore {
        return copy(extra = extra.copy(id = id))
    }
}
