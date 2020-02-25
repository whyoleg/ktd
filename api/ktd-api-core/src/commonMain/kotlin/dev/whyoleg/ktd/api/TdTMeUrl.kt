package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a URL linking to an internal Telegram entity
 *
 * @property url URL
 * @property type Type of the URL
 */
@Serializable
@SerialName("tMeUrl")
data class TdTMeUrl(
    @SerialName("url")
    val url: String,
    @SerialName("type")
    val type: TdTMeUrlType
) : TdObject
