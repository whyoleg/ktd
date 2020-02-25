package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a list of language pack strings
 *
 * @property strings A list of language pack strings
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("languagePackStrings")
data class TdLanguagePackStrings(
    @SerialName("strings")
    val strings: List<TdLanguagePackString>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
