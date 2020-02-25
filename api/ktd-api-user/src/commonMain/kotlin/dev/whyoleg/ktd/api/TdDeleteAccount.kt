package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Deletes the account of the current user, deleting all information associated with the user from the server
 * The phone number of the account can be used to create a new account
 * Can be called before authorization when the current authorization state is authorizationStateWaitPassword
 *
 * @property reason The reason why the account was deleted
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("deleteAccount")
data class TdDeleteAccount(
    @SerialName("reason")
    val reason: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdDeleteAccount {
        return copy(extra = extra.copy(id = id))
    }
}
