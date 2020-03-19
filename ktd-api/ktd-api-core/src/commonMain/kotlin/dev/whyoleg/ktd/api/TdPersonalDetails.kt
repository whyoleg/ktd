package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains the user's personal details
 *
 * @property firstName First name of the user written in English
 * @property middleName Middle name of the user written in English
 * @property lastName Last name of the user written in English
 * @property nativeFirstName Native first name of the user
 * @property nativeMiddleName Native middle name of the user
 * @property nativeLastName Native last name of the user
 * @property birthdate Birthdate of the user
 * @property gender Gender of the user, "male" or "female"
 * @property countryCode A two-letter ISO 3166-1 alpha-2 country code of the user's country
 * @property residenceCountryCode A two-letter ISO 3166-1 alpha-2 country code of the user's residence country
 */
@Serializable
@SerialName("personalDetails")
data class TdPersonalDetails(
    @SerialName("first_name")
    val firstName: String,
    @SerialName("middle_name")
    val middleName: String,
    @SerialName("last_name")
    val lastName: String,
    @SerialName("native_first_name")
    val nativeFirstName: String,
    @SerialName("native_middle_name")
    val nativeMiddleName: String,
    @SerialName("native_last_name")
    val nativeLastName: String,
    @SerialName("birthdate")
    val birthdate: TdDate,
    @SerialName("gender")
    val gender: String,
    @SerialName("country_code")
    val countryCode: String,
    @SerialName("residence_country_code")
    val residenceCountryCode: String
) : TdObject
