package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about a Telegram Passport element
 */
@Serializable
sealed class TdPassportElement : TdResponse {
    /**
     * A Telegram Passport element containing the user's personal details
     *
     * @property personalDetails Personal details of the user
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementPersonalDetails")
    data class PersonalDetails(
        @SerialName("personal_details")
        val personalDetails: TdPersonalDetails,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdPassportElement()

    /**
     * A Telegram Passport element containing the user's passport
     *
     * @property passport Passport
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementPassport")
    data class Passport(
        @SerialName("passport")
        val passport: TdIdentityDocument,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdPassportElement()

    /**
     * A Telegram Passport element containing the user's driver license
     *
     * @property driverLicense Driver license
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementDriverLicense")
    data class DriverLicense(
        @SerialName("driver_license")
        val driverLicense: TdIdentityDocument,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdPassportElement()

    /**
     * A Telegram Passport element containing the user's identity card
     *
     * @property identityCard Identity card
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementIdentityCard")
    data class IdentityCard(
        @SerialName("identity_card")
        val identityCard: TdIdentityDocument,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdPassportElement()

    /**
     * A Telegram Passport element containing the user's internal passport
     *
     * @property internalPassport Internal passport
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementInternalPassport")
    data class InternalPassport(
        @SerialName("internal_passport")
        val internalPassport: TdIdentityDocument,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdPassportElement()

    /**
     * A Telegram Passport element containing the user's address
     *
     * @property address Address
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementAddress")
    data class Address(
        @SerialName("address")
        val address: TdAddress,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdPassportElement()

    /**
     * A Telegram Passport element containing the user's utility bill
     *
     * @property utilityBill Utility bill
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementUtilityBill")
    data class UtilityBill(
        @SerialName("utility_bill")
        val utilityBill: TdPersonalDocument,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdPassportElement()

    /**
     * A Telegram Passport element containing the user's bank statement
     *
     * @property bankStatement Bank statement
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementBankStatement")
    data class BankStatement(
        @SerialName("bank_statement")
        val bankStatement: TdPersonalDocument,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdPassportElement()

    /**
     * A Telegram Passport element containing the user's rental agreement
     *
     * @property rentalAgreement Rental agreement
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementRentalAgreement")
    data class RentalAgreement(
        @SerialName("rental_agreement")
        val rentalAgreement: TdPersonalDocument,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdPassportElement()

    /**
     * A Telegram Passport element containing the user's passport registration pages
     *
     * @property passportRegistration Passport registration pages
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementPassportRegistration")
    data class PassportRegistration(
        @SerialName("passport_registration")
        val passportRegistration: TdPersonalDocument,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdPassportElement()

    /**
     * A Telegram Passport element containing the user's temporary registration
     *
     * @property temporaryRegistration Temporary registration
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementTemporaryRegistration")
    data class TemporaryRegistration(
        @SerialName("temporary_registration")
        val temporaryRegistration: TdPersonalDocument,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdPassportElement()

    /**
     * A Telegram Passport element containing the user's phone number
     *
     * @property phoneNumber Phone number
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementPhoneNumber")
    data class PhoneNumber(
        @SerialName("phone_number")
        val phoneNumber: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdPassportElement()

    /**
     * A Telegram Passport element containing the user's email address
     *
     * @property emailAddress Email address
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementEmailAddress")
    data class EmailAddress(
        @SerialName("email_address")
        val emailAddress: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdPassportElement()
}
