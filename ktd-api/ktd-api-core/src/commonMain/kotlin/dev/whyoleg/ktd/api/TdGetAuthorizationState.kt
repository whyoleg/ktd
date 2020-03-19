package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the current authorization state
 * This is an offline request
 * For informational purposes only
 * Use updateAuthorizationState instead to maintain the current authorization state
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getAuthorizationState")
data class TdGetAuthorizationState(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdAuthorizationState> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetAuthorizationState {
        return copy(extra = extra.copy(id = id))
    }
}
