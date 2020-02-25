package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns saved animations
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getSavedAnimations")
data class TdGetSavedAnimations(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdAnimations> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetSavedAnimations {
        return copy(extra = extra.copy(id = id))
    }
}
