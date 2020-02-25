package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a single button in a bot keyboard
 *
 * @property text Text of the button
 * @property type Type of the button
 */
@Serializable
@SerialName("keyboardButton")
data class TdKeyboardButton(
    @SerialName("text")
    val text: String,
    @SerialName("type")
    val type: TdKeyboardButtonType
) : TdObject
