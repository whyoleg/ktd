package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes imported contacts using the list of current user contacts saved on the device
 * Imports newly added contacts and, if at least the file database is enabled, deletes recently deleted contacts
 * Query result depends on the result of the previous query, so only one query is possible at the same time
 *
 * @property contacts The new list of contacts, contact's vCard are ignored and are not imported
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("changeImportedContacts")
data class TdChangeImportedContacts(
    @SerialName("contacts")
    val contacts: List<TdContact> = emptyList(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdImportedContacts> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdChangeImportedContacts {
        return copy(extra = extra.copy(id = id))
    }
}
