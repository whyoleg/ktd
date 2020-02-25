package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the background selected by the user
 * Adds background to the list of installed backgrounds
 *
 * @property background The input background to use, null for filled backgrounds
 * @property type Background type
 *                Null for default background
 *                The method will return error 404 if type is null
 * @property forDarkTheme True, if the background is chosen for dark theme
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setBackground")
data class TdSetBackground(
    @SerialName("background")
    val background: TdInputBackground? = null,
    @SerialName("type")
    val type: TdBackgroundType? = null,
    @SerialName("for_dark_theme")
    val forDarkTheme: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdBackground> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetBackground {
        return copy(extra = extra.copy(id = id))
    }
}
