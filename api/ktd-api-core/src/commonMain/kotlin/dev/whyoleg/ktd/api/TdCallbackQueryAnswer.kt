package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a bot's answer to a callback query
 *
 * @property text Text of the answer
 * @property showAlert True, if an alert should be shown to the user instead of a toast notification
 * @property url URL to be opened
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("callbackQueryAnswer")
data class TdCallbackQueryAnswer(
    @SerialName("text")
    val text: String,
    @SerialName("show_alert")
    val showAlert: Boolean,
    @SerialName("url")
    val url: String,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
