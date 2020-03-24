package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a list of hashtags
 *
 * @property hashtags A list of hashtags
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("hashtags")
data class TdHashtags(
    @SerialName("hashtags")
    val hashtags: List<String>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
