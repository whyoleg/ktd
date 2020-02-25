package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a single button in an inline keyboard
 *
 * @property text Text of the button
 * @property type Type of the button
 */
@Serializable
@SerialName("inlineKeyboardButton")
data class TdInlineKeyboardButton(
    @SerialName("text")
    val text: String,
    @SerialName("type")
    val type: TdInlineKeyboardButtonType
) : TdObject
