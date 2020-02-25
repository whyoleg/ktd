package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a globally unique push receiver identifier, which can be used to identify which account has received a push notification
 *
 * @property id The globally unique identifier of push notification subscription
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("pushReceiverId")
data class TdPushReceiverId(
    @SerialName("id")
    val id: Long,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
