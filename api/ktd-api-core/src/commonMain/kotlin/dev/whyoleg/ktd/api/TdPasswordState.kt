package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents the current state of 2-step verification
 *
 * @property hasPassword True, if a 2-step verification password is set
 * @property passwordHint Hint for the password
 * @property hasRecoveryEmailAddress True, if a recovery email is set
 * @property hasPassportData True, if some Telegram Passport elements were saved
 * @property recoveryEmailAddressCodeInfo Information about the recovery email address to which the confirmation email was sent
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("passwordState")
data class TdPasswordState(
    @SerialName("has_password")
    val hasPassword: Boolean,
    @SerialName("password_hint")
    val passwordHint: String?,
    @SerialName("has_recovery_email_address")
    val hasRecoveryEmailAddress: Boolean,
    @SerialName("has_passport_data")
    val hasPassportData: Boolean,
    @SerialName("recovery_email_address_code_info")
    val recoveryEmailAddressCodeInfo: TdEmailAddressAuthenticationCodeInfo?,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
