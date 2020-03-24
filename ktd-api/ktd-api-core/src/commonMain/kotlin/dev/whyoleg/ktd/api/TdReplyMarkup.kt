package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a description of a custom keyboard and actions that can be done with it to quickly reply to bots
 */
@Serializable
sealed class TdReplyMarkup : TdObject {
    /**
     * Instructs clients to remove the keyboard once this message has been received
     * This kind of keyboard can't be received in an incoming message
     * Instead, UpdateChatReplyMarkup with message_id == 0 will be sent
     *
     * @property isPersonal True, if the keyboard is removed only for the mentioned users or the target user of a reply
     */
    @Serializable
    @SerialName("replyMarkupRemoveKeyboard")
    data class RemoveKeyboard(
        @SerialName("is_personal")
        val isPersonal: Boolean
    ) : TdReplyMarkup()

    /**
     * Instructs clients to force a reply to this message
     *
     * @property isPersonal True, if a forced reply must automatically be shown to the current user
     *                      For outgoing messages, specify true to show the forced reply only for the mentioned users and for the target user of a reply
     */
    @Serializable
    @SerialName("replyMarkupForceReply")
    data class ForceReply(
        @SerialName("is_personal")
        val isPersonal: Boolean
    ) : TdReplyMarkup()

    /**
     * Contains a custom keyboard layout to quickly reply to bots
     *
     * @property rows A list of rows of bot keyboard buttons
     * @property resizeKeyboard True, if the client needs to resize the keyboard vertically
     * @property oneTime True, if the client needs to hide the keyboard after use
     * @property isPersonal True, if the keyboard must automatically be shown to the current user
     *                      For outgoing messages, specify true to show the keyboard only for the mentioned users and for the target user of a reply
     */
    @Serializable
    @SerialName("replyMarkupShowKeyboard")
    data class ShowKeyboard(
        @SerialName("rows")
        val rows: List<List<TdKeyboardButton>>,
        @SerialName("resize_keyboard")
        val resizeKeyboard: Boolean,
        @SerialName("one_time")
        val oneTime: Boolean,
        @SerialName("is_personal")
        val isPersonal: Boolean
    ) : TdReplyMarkup()

    /**
     * Contains an inline keyboard layout
     *
     * @property rows A list of rows of inline keyboard buttons
     */
    @Serializable
    @SerialName("replyMarkupInlineKeyboard")
    data class InlineKeyboard(
        @SerialName("rows")
        val rows: List<List<TdInlineKeyboardButton>>
    ) : TdReplyMarkup()
}
