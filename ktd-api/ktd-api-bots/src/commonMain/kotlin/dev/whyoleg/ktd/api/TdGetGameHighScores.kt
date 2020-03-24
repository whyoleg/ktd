package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the high scores for a game and some part of the high score table in the range of the specified user
 *
 * @property chatId The chat that contains the message with the game
 * @property messageId Identifier of the message
 * @property userId User identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getGameHighScores")
data class TdGetGameHighScores(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdGameHighScores> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetGameHighScores {
        return copy(extra = extra.copy(id = id))
    }
}
