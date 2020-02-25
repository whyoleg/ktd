package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a JSON value
 */
@Serializable
sealed class TdJsonValue : TdResponse {
    /**
     * Represents a null JSON value
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("jsonValueNull")
    data class Null(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdJsonValue()

    /**
     * Represents a boolean JSON value
     *
     * @property value The value
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("jsonValueBoolean")
    data class Boolean(
        @SerialName("value")
        val value: kotlin.Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdJsonValue()

    /**
     * Represents a numeric JSON value
     *
     * @property value The value
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("jsonValueNumber")
    data class Number(
        @SerialName("value")
        val value: Double,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdJsonValue()

    /**
     * Represents a string JSON value
     *
     * @property value The value
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("jsonValueString")
    data class String(
        @SerialName("value")
        val value: kotlin.String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdJsonValue()

    /**
     * Represents a JSON array
     *
     * @property values The list of array elements
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("jsonValueArray")
    data class Array(
        @SerialName("values")
        val values: List<TdJsonValue>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdJsonValue()

    /**
     * Represents a JSON object
     *
     * @property members The list of object members
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("jsonValueObject")
    data class Object(
        @SerialName("members")
        val members: List<TdJsonObjectMember>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdJsonValue()
}
