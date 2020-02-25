package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Manually adds a new animation to the list of saved animations
 * The new animation is added to the beginning of the list
 * If the animation was already in the list, it is removed first
 * Only non-secret video animations with MIME type "video/mp4" can be added to the list
 *
 * @property animation The animation file to be added
 *                     Only animations known to the server (i.e
 *                     Successfully sent via a message) can be added to the list
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("addSavedAnimation")
data class TdAddSavedAnimation(
    @SerialName("animation")
    val animation: TdInputFile? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdAddSavedAnimation {
        return copy(extra = extra.copy(id = id))
    }
}
