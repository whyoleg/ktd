package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains an HTTP URL
 *
 * @property url The URL
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("httpUrl")
data class TdHttpUrl(
    @SerialName("url")
    val url: String,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
