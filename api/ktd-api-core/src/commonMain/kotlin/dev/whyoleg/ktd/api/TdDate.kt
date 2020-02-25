package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a date according to the Gregorian calendar
 *
 * @property day Day of the month, 1-31
 * @property month Month, 1-12
 * @property year Year, 1-9999
 */
@Serializable
@SerialName("date")
data class TdDate(
    @SerialName("day")
    val day: Int,
    @SerialName("month")
    val month: Int,
    @SerialName("year")
    val year: Int
) : TdObject
