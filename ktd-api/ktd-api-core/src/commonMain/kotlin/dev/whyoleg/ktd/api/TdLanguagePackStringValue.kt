package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents the value of a string in a language pack
 */
@Serializable
sealed class TdLanguagePackStringValue : TdResponse {
    /**
     * An ordinary language pack string
     *
     * @property value String value
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("languagePackStringValueOrdinary")
    data class Ordinary(
        @SerialName("value")
        val value: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdLanguagePackStringValue()

    /**
     * A language pack string which has different forms based on the number of some object it mentions
     * See https://www.unicode.org/cldr/charts/latest/supplemental/language_plural_rules.html for more info
     *
     * @property zeroValue Value for zero objects
     * @property oneValue Value for one object
     * @property twoValue Value for two objects
     * @property fewValue Value for few objects
     * @property manyValue Value for many objects
     * @property otherValue Default value
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("languagePackStringValuePluralized")
    data class Pluralized(
        @SerialName("zero_value")
        val zeroValue: String,
        @SerialName("one_value")
        val oneValue: String,
        @SerialName("two_value")
        val twoValue: String,
        @SerialName("few_value")
        val fewValue: String,
        @SerialName("many_value")
        val manyValue: String,
        @SerialName("other_value")
        val otherValue: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdLanguagePackStringValue()

    /**
     * A deleted language pack string, the value should be taken from the built-in english language pack
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("languagePackStringValueDeleted")
    data class Deleted(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdLanguagePackStringValue()
}
