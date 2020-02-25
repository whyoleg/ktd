package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the default text for invitation messages to be used as a placeholder when the current user invites friends to Telegram
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getInviteText")
data class TdGetInviteText(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdText> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetInviteText {
        return copy(extra = extra.copy(id = id))
    }
}
