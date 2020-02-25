package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a user
 *
 * @property id User identifier
 * @property firstName First name of the user
 * @property lastName Last name of the user
 * @property username Username of the user
 * @property phoneNumber Phone number of the user
 * @property status Current online status of the user
 * @property profilePhoto Profile photo of the user
 * @property isContact The user is a contact of the current user
 * @property isMutualContact The user is a contact of the current user and the current user is a contact of the user
 * @property isVerified True, if the user is verified
 * @property isSupport True, if the user is Telegram support account
 * @property restrictionReason If non-empty, it contains a human-readable description of the reason why access to this user must be restricted
 * @property isScam True, if many users reported this user as a scam
 * @property haveAccess If false, the user is inaccessible, and the only information known about the user is inside this class
 *                      It can't be passed to any method except GetUser
 * @property type Type of the user
 * @property languageCode IETF language tag of the user's language
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("user")
data class TdUser(
    @SerialName("id")
    val id: Int,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("last_name")
    val lastName: String,
    @SerialName("username")
    val username: String,
    @SerialName("phone_number")
    val phoneNumber: String,
    @SerialName("status")
    val status: TdUserStatus,
    @SerialName("profile_photo")
    val profilePhoto: TdProfilePhoto?,
    @SerialName("is_contact")
    val isContact: Boolean,
    @SerialName("is_mutual_contact")
    val isMutualContact: Boolean,
    @SerialName("is_verified")
    val isVerified: Boolean,
    @SerialName("is_support")
    val isSupport: Boolean,
    @SerialName("restriction_reason")
    val restrictionReason: String,
    @SerialName("is_scam")
    val isScam: Boolean,
    @SerialName("have_access")
    val haveAccess: Boolean,
    @SerialName("type")
    val type: TdUserType,
    @SerialName("language_code")
    @TdBotsOnly
    val languageCode: String,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
