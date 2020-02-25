package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns all entities (mentions, hashtags, cashtags, bot commands, URLs, and email addresses) contained in the text
 * This is an offline method
 * Can be called before authorization
 *
 * @property text The text in which to look for entites
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getTextEntities")
data class TdGetTextEntities(
    @SerialName("text")
    val text: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdSyncRequest<TdTextEntities> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetTextEntities {
        return copy(extra = extra.copy(id = id))
    }
}
