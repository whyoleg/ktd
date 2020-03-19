package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a globally unique push notification subscription identifier for identification of an account, which has received a push notification
 * This is an offline method
 * Can be called before authorization
 *
 * @property payload JSON-encoded push notification payload
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getPushReceiverId")
data class TdGetPushReceiverId(
    @SerialName("payload")
    val payload: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdSyncRequest<TdPushReceiverId> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetPushReceiverId {
        return copy(extra = extra.copy(id = id))
    }
}
