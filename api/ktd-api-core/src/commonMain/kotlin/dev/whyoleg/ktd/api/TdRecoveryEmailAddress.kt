package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about the current recovery email address
 *
 * @property recoveryEmailAddress Recovery email address
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("recoveryEmailAddress")
data class TdRecoveryEmailAddress(
    @SerialName("recovery_email_address")
    val recoveryEmailAddress: String,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
