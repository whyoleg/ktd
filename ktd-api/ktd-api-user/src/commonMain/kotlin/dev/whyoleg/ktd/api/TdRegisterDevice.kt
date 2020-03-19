package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Registers the currently used device for receiving push notifications
 * Returns a globally unique identifier of the push notification subscription
 *
 * @property deviceToken Device token
 * @property otherUserIds List of user identifiers of other users currently using the client
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("registerDevice")
data class TdRegisterDevice(
    @SerialName("device_token")
    val deviceToken: TdDeviceToken? = null,
    @SerialName("other_user_ids")
    val otherUserIds: IntArray = intArrayOf(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdPushReceiverId> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRegisterDevice {
        return copy(extra = extra.copy(id = id))
    }
}
