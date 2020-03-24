package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Handles a push notification
 * Returns error with code 406 if the push notification is not supported and connection to the server is required to fetch new data
 * Can be called before authorization
 *
 * @property payload JSON-encoded push notification payload with all fields sent by the server, and "google.sent_time" and "google.notification.sound" fields added
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("processPushNotification")
data class TdProcessPushNotification(
    @SerialName("payload")
    val payload: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdProcessPushNotification {
        return copy(extra = extra.copy(id = id))
    }
}
