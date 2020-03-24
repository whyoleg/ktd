package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a list of backgrounds
 *
 * @property backgrounds A list of backgrounds
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("backgrounds")
data class TdBackgrounds(
    @SerialName("backgrounds")
    val backgrounds: List<TdBackground>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
