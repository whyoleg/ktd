package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a keyboard button type
 */
@Serializable
sealed class TdKeyboardButtonType : TdObject {
    /**
     * A simple button, with text that should be sent when the button is pressed
     */
    @Serializable
    @SerialName("keyboardButtonTypeText")
    object Text : TdKeyboardButtonType()

    /**
     * A button that sends the user's phone number when pressed
     * Available only in private chats
     */
    @Serializable
    @SerialName("keyboardButtonTypeRequestPhoneNumber")
    object RequestPhoneNumber : TdKeyboardButtonType()

    /**
     * A button that sends the user's location when pressed
     * Available only in private chats
     */
    @Serializable
    @SerialName("keyboardButtonTypeRequestLocation")
    object RequestLocation : TdKeyboardButtonType()

    /**
     * A button that allows the user to create and send a poll when pressed
     * Available only in private chats
     *
     * @property forceRegular If true, only regular polls must be allowed to create
     * @property forceQuiz If true, only polls in quiz mode must be allowed to create
     */
    @Serializable
    @SerialName("keyboardButtonTypeRequestPoll")
    data class RequestPoll(
        @SerialName("force_regular")
        val forceRegular: Boolean,
        @SerialName("force_quiz")
        val forceQuiz: Boolean
    ) : TdKeyboardButtonType()
}
