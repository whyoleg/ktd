package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about the payment method chosen by the user
 */
@Serializable
sealed class TdInputCredentials : TdObject {
    /**
     * Applies if a user chooses some previously saved payment credentials
     * To use their previously saved credentials, the user must have a valid temporary password
     *
     * @property savedCredentialsId Identifier of the saved credentials
     */
    @Serializable
    @SerialName("inputCredentialsSaved")
    data class Saved(
        @SerialName("saved_credentials_id")
        val savedCredentialsId: String
    ) : TdInputCredentials()

    /**
     * Applies if a user enters new credentials on a payment provider website
     *
     * @property data Contains JSON-encoded data with a credential identifier from the payment provider
     * @property allowSave True, if the credential identifier can be saved on the server side
     */
    @Serializable
    @SerialName("inputCredentialsNew")
    data class New(
        @SerialName("data")
        val data: String,
        @SerialName("allow_save")
        val allowSave: Boolean
    ) : TdInputCredentials()

    /**
     * Applies if a user enters new credentials using Android Pay
     *
     * @property data JSON-encoded data with the credential identifier
     */
    @Serializable
    @SerialName("inputCredentialsAndroidPay")
    data class AndroidPay(
        @SerialName("data")
        val data: String
    ) : TdInputCredentials()

    /**
     * Applies if a user enters new credentials using Apple Pay
     *
     * @property data JSON-encoded data with the credential identifier
     */
    @Serializable
    @SerialName("inputCredentialsApplePay")
    data class ApplePay(
        @SerialName("data")
        val data: String
    ) : TdInputCredentials()
}
