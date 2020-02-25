package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains Telegram terms of service
 *
 * @property text Text of the terms of service
 * @property minUserAge The minimum age of a user to be able to accept the terms
 *                      0 if any
 * @property showPopup True, if a blocking popup with terms of service must be shown to the user
 */
@Serializable
@SerialName("termsOfService")
data class TdTermsOfService(
    @SerialName("text")
    val text: TdFormattedText,
    @SerialName("min_user_age")
    val minUserAge: Int,
    @SerialName("show_popup")
    val showPopup: Boolean
) : TdObject
