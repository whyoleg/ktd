package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Removes background from the list of installed backgrounds
 *
 * @property backgroundId The background identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("removeBackground")
data class TdRemoveBackground(
    @SerialName("background_id")
    val backgroundId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRemoveBackground {
        return copy(extra = extra.copy(id = id))
    }
}
