package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the total number of imported contacts
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getImportedContactCount")
data class TdGetImportedContactCount(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdCount> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetImportedContactCount {
        return copy(extra = extra.copy(id = id))
    }
}
