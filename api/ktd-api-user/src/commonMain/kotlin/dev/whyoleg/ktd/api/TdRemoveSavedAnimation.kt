package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Removes an animation from the list of saved animations
 *
 * @property animation Animation file to be removed
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("removeSavedAnimation")
data class TdRemoveSavedAnimation(
    @SerialName("animation")
    val animation: TdInputFile? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRemoveSavedAnimation {
        return copy(extra = extra.copy(id = id))
    }
}
