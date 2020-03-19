package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Finishes user registration
 * Works only when the current authorization state is authorizationStateWaitRegistration
 *
 * @property firstName The first name of the user
 * @property lastName The last name of the user
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("registerUser")
data class TdRegisterUser(
    @SerialName("first_name")
    val firstName: String? = null,
    @SerialName("last_name")
    val lastName: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRegisterUser {
        return copy(extra = extra.copy(id = id))
    }
}
