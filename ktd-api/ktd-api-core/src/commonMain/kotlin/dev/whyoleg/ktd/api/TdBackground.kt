package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a chat background
 *
 * @property id Unique background identifier
 * @property isDefault True, if this is one of default backgrounds
 * @property isDark True, if the background is dark and is recommended to be used with dark theme
 * @property name Unique background name
 * @property document Document with the background
 *                    Null only for filled backgrounds
 * @property type Type of the background
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("background")
data class TdBackground(
    @SerialName("id")
    val id: Long,
    @SerialName("is_default")
    val isDefault: Boolean,
    @SerialName("is_dark")
    val isDark: Boolean,
    @SerialName("name")
    val name: String,
    @SerialName("document")
    val document: TdDocument?,
    @SerialName("type")
    val type: TdBackgroundType,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
