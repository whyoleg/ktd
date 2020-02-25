package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains the type of a Telegram Passport element
 */
@Serializable
sealed class TdPassportElementType : TdObject {
    /**
     * A Telegram Passport element containing the user's personal details
     */
    @Serializable
    @SerialName("passportElementTypePersonalDetails")
    object PersonalDetails : TdPassportElementType()

    /**
     * A Telegram Passport element containing the user's passport
     */
    @Serializable
    @SerialName("passportElementTypePassport")
    object Passport : TdPassportElementType()

    /**
     * A Telegram Passport element containing the user's driver license
     */
    @Serializable
    @SerialName("passportElementTypeDriverLicense")
    object DriverLicense : TdPassportElementType()

    /**
     * A Telegram Passport element containing the user's identity card
     */
    @Serializable
    @SerialName("passportElementTypeIdentityCard")
    object IdentityCard : TdPassportElementType()

    /**
     * A Telegram Passport element containing the user's internal passport
     */
    @Serializable
    @SerialName("passportElementTypeInternalPassport")
    object InternalPassport : TdPassportElementType()

    /**
     * A Telegram Passport element containing the user's address
     */
    @Serializable
    @SerialName("passportElementTypeAddress")
    object Address : TdPassportElementType()

    /**
     * A Telegram Passport element containing the user's utility bill
     */
    @Serializable
    @SerialName("passportElementTypeUtilityBill")
    object UtilityBill : TdPassportElementType()

    /**
     * A Telegram Passport element containing the user's bank statement
     */
    @Serializable
    @SerialName("passportElementTypeBankStatement")
    object BankStatement : TdPassportElementType()

    /**
     * A Telegram Passport element containing the user's rental agreement
     */
    @Serializable
    @SerialName("passportElementTypeRentalAgreement")
    object RentalAgreement : TdPassportElementType()

    /**
     * A Telegram Passport element containing the registration page of the user's passport
     */
    @Serializable
    @SerialName("passportElementTypePassportRegistration")
    object PassportRegistration : TdPassportElementType()

    /**
     * A Telegram Passport element containing the user's temporary registration
     */
    @Serializable
    @SerialName("passportElementTypeTemporaryRegistration")
    object TemporaryRegistration : TdPassportElementType()

    /**
     * A Telegram Passport element containing the user's phone number
     */
    @Serializable
    @SerialName("passportElementTypePhoneNumber")
    object PhoneNumber : TdPassportElementType()

    /**
     * A Telegram Passport element containing the user's email address
     */
    @Serializable
    @SerialName("passportElementTypeEmailAddress")
    object EmailAddress : TdPassportElementType()
}
