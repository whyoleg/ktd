package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Resets list of installed backgrounds to its default value
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("resetBackgrounds")
data class TdResetBackgrounds(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdResetBackgrounds {
        return copy(extra = extra.copy(id = id))
    }
}
