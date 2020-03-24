package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Constructs a persistent HTTP URL for a background
 *
 * @property name Background name
 * @property type Background type
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getBackgroundUrl")
data class TdGetBackgroundUrl(
    @SerialName("name")
    val name: String? = null,
    @SerialName("type")
    val type: TdBackgroundType? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdHttpUrl> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetBackgroundUrl {
        return copy(extra = extra.copy(id = id))
    }
}
