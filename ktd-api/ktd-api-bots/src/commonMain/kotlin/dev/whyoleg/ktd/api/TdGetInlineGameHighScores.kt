package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns game high scores and some part of the high score table in the range of the specified user
 *
 * @property inlineMessageId Inline message identifier
 * @property userId User identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getInlineGameHighScores")
data class TdGetInlineGameHighScores(
    @SerialName("inline_message_id")
    val inlineMessageId: String? = null,
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdGameHighScores> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetInlineGameHighScores {
        return copy(extra = extra.copy(id = id))
    }
}
