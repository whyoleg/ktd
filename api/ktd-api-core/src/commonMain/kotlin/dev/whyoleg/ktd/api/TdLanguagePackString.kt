package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents one language pack string
 *
 * @property key String key
 * @property value String value
 */
@Serializable
@SerialName("languagePackString")
data class TdLanguagePackString(
    @SerialName("key")
    val key: String,
    @SerialName("value")
    val value: TdLanguagePackStringValue
) : TdObject
