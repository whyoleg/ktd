package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Creates a new temporary password for processing payments
 *
 * @property password Persistent user password
 * @property validFor Time during which the temporary password will be valid, in seconds
 *                    Should be between 60 and 86400
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("createTemporaryPassword")
data class TdCreateTemporaryPassword(
    @SerialName("password")
    val password: String? = null,
    @SerialName("valid_for")
    val validFor: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdTemporaryPasswordState> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCreateTemporaryPassword {
        return copy(extra = extra.copy(id = id))
    }
}
