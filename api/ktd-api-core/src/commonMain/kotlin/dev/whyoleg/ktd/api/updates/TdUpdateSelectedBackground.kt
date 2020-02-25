package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * The selected background has changed
 *
 * @property forDarkTheme True, if background for dark theme has changed
 * @property background The new selected background
 */
@Serializable
@SerialName("updateSelectedBackground")
data class TdUpdateSelectedBackground(
    @SerialName("for_dark_theme")
    val forDarkTheme: Boolean,
    @SerialName("background")
    val background: TdBackground?
) : TdUpdate
