package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about a Telegram Passport element to be saved
 */
@Serializable
sealed class TdInputPassportElement : TdObject {
    /**
     * A Telegram Passport element to be saved containing the user's personal details
     *
     * @property personalDetails Personal details of the user
     */
    @Serializable
    @SerialName("inputPassportElementPersonalDetails")
    data class PersonalDetails(
        @SerialName("personal_details")
        val personalDetails: TdPersonalDetails
    ) : TdInputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's passport
     *
     * @property passport The passport to be saved
     */
    @Serializable
    @SerialName("inputPassportElementPassport")
    data class Passport(
        @SerialName("passport")
        val passport: TdInputIdentityDocument
    ) : TdInputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's driver license
     *
     * @property driverLicense The driver license to be saved
     */
    @Serializable
    @SerialName("inputPassportElementDriverLicense")
    data class DriverLicense(
        @SerialName("driver_license")
        val driverLicense: TdInputIdentityDocument
    ) : TdInputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's identity card
     *
     * @property identityCard The identity card to be saved
     */
    @Serializable
    @SerialName("inputPassportElementIdentityCard")
    data class IdentityCard(
        @SerialName("identity_card")
        val identityCard: TdInputIdentityDocument
    ) : TdInputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's internal passport
     *
     * @property internalPassport The internal passport to be saved
     */
    @Serializable
    @SerialName("inputPassportElementInternalPassport")
    data class InternalPassport(
        @SerialName("internal_passport")
        val internalPassport: TdInputIdentityDocument
    ) : TdInputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's address
     *
     * @property address The address to be saved
     */
    @Serializable
    @SerialName("inputPassportElementAddress")
    data class Address(
        @SerialName("address")
        val address: TdAddress
    ) : TdInputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's utility bill
     *
     * @property utilityBill The utility bill to be saved
     */
    @Serializable
    @SerialName("inputPassportElementUtilityBill")
    data class UtilityBill(
        @SerialName("utility_bill")
        val utilityBill: TdInputPersonalDocument
    ) : TdInputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's bank statement
     *
     * @property bankStatement The bank statement to be saved
     */
    @Serializable
    @SerialName("inputPassportElementBankStatement")
    data class BankStatement(
        @SerialName("bank_statement")
        val bankStatement: TdInputPersonalDocument
    ) : TdInputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's rental agreement
     *
     * @property rentalAgreement The rental agreement to be saved
     */
    @Serializable
    @SerialName("inputPassportElementRentalAgreement")
    data class RentalAgreement(
        @SerialName("rental_agreement")
        val rentalAgreement: TdInputPersonalDocument
    ) : TdInputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's passport registration
     *
     * @property passportRegistration The passport registration page to be saved
     */
    @Serializable
    @SerialName("inputPassportElementPassportRegistration")
    data class PassportRegistration(
        @SerialName("passport_registration")
        val passportRegistration: TdInputPersonalDocument
    ) : TdInputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's temporary registration
     *
     * @property temporaryRegistration The temporary registration document to be saved
     */
    @Serializable
    @SerialName("inputPassportElementTemporaryRegistration")
    data class TemporaryRegistration(
        @SerialName("temporary_registration")
        val temporaryRegistration: TdInputPersonalDocument
    ) : TdInputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's phone number
     *
     * @property phoneNumber The phone number to be saved
     */
    @Serializable
    @SerialName("inputPassportElementPhoneNumber")
    data class PhoneNumber(
        @SerialName("phone_number")
        val phoneNumber: String
    ) : TdInputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's email address
     *
     * @property emailAddress The email address to be saved
     */
    @Serializable
    @SerialName("inputPassportElementEmailAddress")
    data class EmailAddress(
        @SerialName("email_address")
        val emailAddress: String
    ) : TdInputPassportElement()
}
