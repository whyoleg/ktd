package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Clears all imported contacts, contact list remains unchanged
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("clearImportedContacts")
data class TdClearImportedContacts(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdClearImportedContacts {
        return copy(extra = extra.copy(id = id))
    }
}
