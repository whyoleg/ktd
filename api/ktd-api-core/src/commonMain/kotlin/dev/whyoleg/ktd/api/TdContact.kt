package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a user contact
 *
 * @property phoneNumber Phone number of the user
 * @property firstName First name of the user
 * @property lastName Last name of the user
 * @property vcard Additional data about the user in a form of vCard
 * @property userId Identifier of the user, if known
 *                  Otherwise 0
 */
@Serializable
@SerialName("contact")
data class TdContact(
    @SerialName("phone_number")
    val phoneNumber: String,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("last_name")
    val lastName: String,
    @SerialName("vcard")
    val vcard: String,
    @SerialName("user_id")
    val userId: Int
) : TdObject
