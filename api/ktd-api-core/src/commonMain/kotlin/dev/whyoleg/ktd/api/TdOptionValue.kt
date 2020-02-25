package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents the value of an option
 */
@Serializable
sealed class TdOptionValue : TdResponse {
    /**
     * Represents a boolean option
     *
     * @property value The value of the option
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("optionValueBoolean")
    data class Boolean(
        @SerialName("value")
        val value: kotlin.Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdOptionValue()

    /**
     * Represents an unknown option or an option which has a default value
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("optionValueEmpty")
    data class Empty(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdOptionValue()

    /**
     * Represents an integer option
     *
     * @property value The value of the option
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("optionValueInteger")
    data class Integer(
        @SerialName("value")
        val value: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdOptionValue()

    /**
     * Represents a string option
     *
     * @property value The value of the option
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("optionValueString")
    data class String(
        @SerialName("value")
        val value: kotlin.String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdOptionValue()
}
