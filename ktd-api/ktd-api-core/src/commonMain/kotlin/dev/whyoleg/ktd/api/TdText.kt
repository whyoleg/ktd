package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains some text
 *
 * @property text Text
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("text")
data class TdText(
    @SerialName("text")
    val text: String,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
