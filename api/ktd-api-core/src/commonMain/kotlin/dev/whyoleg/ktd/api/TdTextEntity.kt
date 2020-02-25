package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a part of the text that needs to be formatted in some unusual way
 *
 * @property offset Offset of the entity in UTF-16 code units
 * @property length Length of the entity, in UTF-16 code units
 * @property type Type of the entity
 */
@Serializable
@SerialName("textEntity")
data class TdTextEntity(
    @SerialName("offset")
    val offset: Int,
    @SerialName("length")
    val length: Int,
    @SerialName("type")
    val type: TdTextEntityType
) : TdObject
