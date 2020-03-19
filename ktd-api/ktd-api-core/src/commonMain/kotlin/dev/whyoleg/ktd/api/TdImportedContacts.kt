package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents the result of an ImportContacts request
 *
 * @property userIds User identifiers of the imported contacts in the same order as they were specified in the request
 *                   0 if the contact is not yet a registered user
 * @property importerCount The number of users that imported the corresponding contact
 *                         0 for already registered users or if unavailable
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("importedContacts")
data class TdImportedContacts(
    @SerialName("user_ids")
    val userIds: IntArray,
    @SerialName("importer_count")
    val importerCount: IntArray,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
