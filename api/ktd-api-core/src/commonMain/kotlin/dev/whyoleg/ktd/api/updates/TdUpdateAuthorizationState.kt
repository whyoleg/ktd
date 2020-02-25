package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * The user authorization state has changed
 *
 * @property authorizationState New authorization state
 */
@Serializable
@SerialName("updateAuthorizationState")
data class TdUpdateAuthorizationState(
    @SerialName("authorization_state")
    val authorizationState: TdAuthorizationState
) : TdUpdate, TdUpdateState {
    override val state: TdState
        get() = authorizationState
}
