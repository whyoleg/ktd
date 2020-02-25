package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents the current authorization state of the client
 */
@Serializable
sealed class TdAuthorizationState : TdResponse, TdState {
    /**
     * TDLib needs TdlibParameters for initialization
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateWaitTdlibParameters")
    data class WaitTdlibParameters(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdAuthorizationState()

    /**
     * TDLib needs an encryption key to decrypt the local database
     *
     * @property isEncrypted True, if the database is currently encrypted
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateWaitEncryptionKey")
    data class WaitEncryptionKey(
        @SerialName("is_encrypted")
        val isEncrypted: Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdAuthorizationState()

    /**
     * TDLib needs the user's phone number to authorize
     * Call `setAuthenticationPhoneNumber` to provide the phone number, or use `requestQrCodeAuthentication`, or `checkAuthenticationBotToken` for other authentication options
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateWaitPhoneNumber")
    data class WaitPhoneNumber(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdAuthorizationState()

    /**
     * TDLib needs the user's authentication code to authorize
     *
     * @property codeInfo Information about the authorization code that was sent
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateWaitCode")
    data class WaitCode(
        @SerialName("code_info")
        val codeInfo: TdAuthenticationCodeInfo,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdAuthorizationState()

    /**
     * The user needs to confirm authorization on another logged in device by scanning a QR code with the provided link
     *
     * @property link A tg:// URL for the QR code
     *                The link will be updated frequently
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateWaitOtherDeviceConfirmation")
    data class WaitOtherDeviceConfirmation(
        @SerialName("link")
        val link: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdAuthorizationState()

    /**
     * The user is unregistered and need to accept terms of service and enter their first name and last name to finish registration
     *
     * @property termsOfService Telegram terms of service
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateWaitRegistration")
    data class WaitRegistration(
        @SerialName("terms_of_service")
        val termsOfService: TdTermsOfService,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdAuthorizationState()

    /**
     * The user has been authorized, but needs to enter a password to start using the application
     *
     * @property passwordHint Hint for the password
     * @property hasRecoveryEmailAddress True, if a recovery email address has been set up
     * @property recoveryEmailAddressPattern Pattern of the email address to which the recovery email was sent
     *                                       Empty until a recovery email has been sent
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateWaitPassword")
    data class WaitPassword(
        @SerialName("password_hint")
        val passwordHint: String?,
        @SerialName("has_recovery_email_address")
        val hasRecoveryEmailAddress: Boolean,
        @SerialName("recovery_email_address_pattern")
        val recoveryEmailAddressPattern: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdAuthorizationState()

    /**
     * The user has been successfully authorized
     * TDLib is now ready to answer queries
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateReady")
    data class Ready(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdAuthorizationState()

    /**
     * The user is currently logging out
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateLoggingOut")
    data class LoggingOut(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdAuthorizationState()

    /**
     * TDLib is closing, all subsequent queries will be answered with the error 500
     * Note that closing TDLib can take a while
     * All resources will be freed only after authorizationStateClosed has been received
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateClosing")
    data class Closing(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdAuthorizationState(), TdClosing

    /**
     * TDLib client is in its final state
     * All databases are closed and all resources are released
     * No other updates will be received after this
     * All queries will be responded to with error code 500
     * To continue working, one should create a new instance of the TDLib client
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateClosed")
    data class Closed(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdAuthorizationState(), TdClosed
}
