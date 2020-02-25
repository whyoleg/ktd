package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about the availability of a temporary password, which can be used for payments
 *
 * @property hasPassword True, if a temporary password is available
 * @property validFor Time left before the temporary password expires, in seconds
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("temporaryPasswordState")
data class TdTemporaryPasswordState(
    @SerialName("has_password")
    val hasPassword: Boolean,
    @SerialName("valid_for")
    val validFor: Int,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
