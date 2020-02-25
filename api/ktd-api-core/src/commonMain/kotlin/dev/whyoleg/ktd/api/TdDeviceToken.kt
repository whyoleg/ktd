package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a data needed to subscribe for push notifications through registerDevice method
 * To use specific push notification service, you must specify the correct application platform and upload valid server authentication data at https://my.telegram.org
 */
@Serializable
sealed class TdDeviceToken : TdObject {
    /**
     * A token for Firebase Cloud Messaging
     *
     * @property token Device registration token
     *                 May be empty to de-register a device
     * @property encrypt True, if push notifications should be additionally encrypted
     */
    @Serializable
    @SerialName("deviceTokenFirebaseCloudMessaging")
    data class FirebaseCloudMessaging(
        @SerialName("token")
        val token: String?,
        @SerialName("encrypt")
        val encrypt: Boolean
    ) : TdDeviceToken()

    /**
     * A token for Apple Push Notification service
     *
     * @property deviceToken Device token
     *                       May be empty to de-register a device
     * @property isAppSandbox True, if App Sandbox is enabled
     */
    @Serializable
    @SerialName("deviceTokenApplePush")
    data class ApplePush(
        @SerialName("device_token")
        val deviceToken: String?,
        @SerialName("is_app_sandbox")
        val isAppSandbox: Boolean
    ) : TdDeviceToken()

    /**
     * A token for Apple Push Notification service VoIP notifications
     *
     * @property deviceToken Device token
     *                       May be empty to de-register a device
     * @property isAppSandbox True, if App Sandbox is enabled
     * @property encrypt True, if push notifications should be additionally encrypted
     */
    @Serializable
    @SerialName("deviceTokenApplePushVoIP")
    data class ApplePushVoIP(
        @SerialName("device_token")
        val deviceToken: String?,
        @SerialName("is_app_sandbox")
        val isAppSandbox: Boolean,
        @SerialName("encrypt")
        val encrypt: Boolean
    ) : TdDeviceToken()

    /**
     * A token for Windows Push Notification Services
     *
     * @property accessToken The access token that will be used to send notifications
     *                       May be empty to de-register a device
     */
    @Serializable
    @SerialName("deviceTokenWindowsPush")
    data class WindowsPush(
        @SerialName("access_token")
        val accessToken: String?
    ) : TdDeviceToken()

    /**
     * A token for Microsoft Push Notification Service
     *
     * @property channelUri Push notification channel URI
     *                      May be empty to de-register a device
     */
    @Serializable
    @SerialName("deviceTokenMicrosoftPush")
    data class MicrosoftPush(
        @SerialName("channel_uri")
        val channelUri: String?
    ) : TdDeviceToken()

    /**
     * A token for Microsoft Push Notification Service VoIP channel
     *
     * @property channelUri Push notification channel URI
     *                      May be empty to de-register a device
     */
    @Serializable
    @SerialName("deviceTokenMicrosoftPushVoIP")
    data class MicrosoftPushVoIP(
        @SerialName("channel_uri")
        val channelUri: String?
    ) : TdDeviceToken()

    /**
     * A token for web Push API
     *
     * @property endpoint Absolute URL exposed by the push service where the application server can send push messages
     *                    May be empty to de-register a device
     * @property p256dhBase64url Base64url-encoded P-256 elliptic curve Diffie-Hellman public key
     * @property authBase64url Base64url-encoded authentication secret
     */
    @Serializable
    @SerialName("deviceTokenWebPush")
    data class WebPush(
        @SerialName("endpoint")
        val endpoint: String?,
        @SerialName("p256dh_base64url")
        val p256dhBase64url: String,
        @SerialName("auth_base64url")
        val authBase64url: String
    ) : TdDeviceToken()

    /**
     * A token for Simple Push API for Firefox OS
     *
     * @property endpoint Absolute URL exposed by the push service where the application server can send push messages
     *                    May be empty to de-register a device
     */
    @Serializable
    @SerialName("deviceTokenSimplePush")
    data class SimplePush(
        @SerialName("endpoint")
        val endpoint: String?
    ) : TdDeviceToken()

    /**
     * A token for Ubuntu Push Client service
     *
     * @property token Token
     *                 May be empty to de-register a device
     */
    @Serializable
    @SerialName("deviceTokenUbuntuPush")
    data class UbuntuPush(
        @SerialName("token")
        val token: String?
    ) : TdDeviceToken()

    /**
     * A token for BlackBerry Push Service
     *
     * @property token Token
     *                 May be empty to de-register a device
     */
    @Serializable
    @SerialName("deviceTokenBlackBerryPush")
    data class BlackBerryPush(
        @SerialName("token")
        val token: String?
    ) : TdDeviceToken()

    /**
     * A token for Tizen Push Service
     *
     * @property regId Push service registration identifier
     *                 May be empty to de-register a device
     */
    @Serializable
    @SerialName("deviceTokenTizenPush")
    data class TizenPush(
        @SerialName("reg_id")
        val regId: String?
    ) : TdDeviceToken()
}
