package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about an inline button of type inlineKeyboardButtonTypeLoginUrl
 */
@Serializable
sealed class TdLoginUrlInfo : TdResponse {
    /**
     * An HTTP url needs to be open
     *
     * @property url The URL to open
     * @property skipConfirm True, if there is no need to show an ordinary open URL confirm
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("loginUrlInfoOpen")
    data class Open(
        @SerialName("url")
        val url: String,
        @SerialName("skip_confirm")
        val skipConfirm: Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdLoginUrlInfo()

    /**
     * An authorization confirmation dialog needs to be shown to the user
     *
     * @property url An HTTP URL to be opened
     * @property domain A domain of the URL
     * @property botUserId User identifier of a bot linked with the website
     * @property requestWriteAccess True, if the user needs to be requested to give the permission to the bot to send them messages
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("loginUrlInfoRequestConfirmation")
    data class RequestConfirmation(
        @SerialName("url")
        val url: String,
        @SerialName("domain")
        val domain: String,
        @SerialName("bot_user_id")
        val botUserId: Int,
        @SerialName("request_write_access")
        val requestWriteAccess: Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdLoginUrlInfo()
}
