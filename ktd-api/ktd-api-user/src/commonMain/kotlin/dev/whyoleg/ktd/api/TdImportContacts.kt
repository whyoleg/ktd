package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Adds new contacts or edits existing contacts by their phone numbers
 * Contacts' user identifiers are ignored
 *
 * @property contacts The list of contacts to import or edit
 *                    Contacts' vCard are ignored and are not imported
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("importContacts")
data class TdImportContacts(
    @SerialName("contacts")
    val contacts: List<TdContact> = emptyList(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdImportedContacts> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdImportContacts {
        return copy(extra = extra.copy(id = id))
    }
}
