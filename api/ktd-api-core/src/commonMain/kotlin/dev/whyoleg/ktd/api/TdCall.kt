package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a call
 *
 * @property id Call identifier, not persistent
 * @property userId Peer user identifier
 * @property isOutgoing True, if the call is outgoing
 * @property state Call state
 */
@Serializable
@SerialName("call")
data class TdCall(
    @SerialName("id")
    val id: Int,
    @SerialName("user_id")
    val userId: Int,
    @SerialName("is_outgoing")
    val isOutgoing: Boolean,
    @SerialName("state")
    val state: TdCallState
) : TdObject
