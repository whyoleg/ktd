package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a list of t.me URLs
 *
 * @property urls List of URLs
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("tMeUrls")
data class TdTMeUrls(
    @SerialName("urls")
    val urls: List<TdTMeUrl>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
