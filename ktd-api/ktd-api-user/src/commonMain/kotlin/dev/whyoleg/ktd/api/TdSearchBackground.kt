package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Searches for a background by its name
 *
 * @property name The name of the background
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("searchBackground")
data class TdSearchBackground(
    @SerialName("name")
    val name: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdBackground> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSearchBackground {
        return copy(extra = extra.copy(id = id))
    }
}
