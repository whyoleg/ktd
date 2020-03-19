package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * An option changed its value
 *
 * @property name The option name
 * @property value The new option value
 */
@Serializable
@SerialName("updateOption")
data class TdUpdateOption(
    @SerialName("name")
    val name: String,
    @SerialName("value")
    val value: TdOptionValue
) : TdUpdate
