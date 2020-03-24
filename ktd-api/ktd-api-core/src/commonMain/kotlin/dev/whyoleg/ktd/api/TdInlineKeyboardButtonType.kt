package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes the type of an inline keyboard button
 */
@Serializable
sealed class TdInlineKeyboardButtonType : TdObject {
    /**
     * A button that opens a specified URL
     *
     * @property url HTTP or tg:// URL to open
     */
    @Serializable
    @SerialName("inlineKeyboardButtonTypeUrl")
    data class Url(
        @SerialName("url")
        val url: String
    ) : TdInlineKeyboardButtonType()

    /**
     * A button that opens a specified URL and automatically logs in in current user if they allowed to do that
     *
     * @property url An HTTP URL to open
     * @property id Unique button identifier
     * @property forwardText If non-empty, new text of the button in forwarded messages
     */
    @Serializable
    @SerialName("inlineKeyboardButtonTypeLoginUrl")
    data class LoginUrl(
        @SerialName("url")
        val url: String,
        @SerialName("id")
        val id: Int,
        @SerialName("forward_text")
        val forwardText: String
    ) : TdInlineKeyboardButtonType()

    /**
     * A button that sends a special callback query to a bot
     *
     * @property data Data to be sent to the bot via a callback query
     */
    @Serializable
    @SerialName("inlineKeyboardButtonTypeCallback")
    data class Callback(
        @SerialName("data")
        val data: ByteArray
    ) : TdInlineKeyboardButtonType()

    /**
     * A button with a game that sends a special callback query to a bot
     * This button must be in the first column and row of the keyboard and can be attached only to a message with content of the type messageGame
     */
    @Serializable
    @SerialName("inlineKeyboardButtonTypeCallbackGame")
    object CallbackGame : TdInlineKeyboardButtonType()

    /**
     * A button that forces an inline query to the bot to be inserted in the input field
     *
     * @property query Inline query to be sent to the bot
     * @property inCurrentChat True, if the inline query should be sent from the current chat
     */
    @Serializable
    @SerialName("inlineKeyboardButtonTypeSwitchInline")
    data class SwitchInline(
        @SerialName("query")
        val query: String,
        @SerialName("in_current_chat")
        val inCurrentChat: Boolean
    ) : TdInlineKeyboardButtonType()

    /**
     * A button to buy something
     * This button must be in the first column and row of the keyboard and can be attached only to a message with content of the type messageInvoice
     */
    @Serializable
    @SerialName("inlineKeyboardButtonTypeBuy")
    object Buy : TdInlineKeyboardButtonType()
}
