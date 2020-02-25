package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a list of animations
 *
 * @property animations List of animations
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("animations")
data class TdAnimations(
    @SerialName("animations")
    val animations: List<TdAnimation>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
