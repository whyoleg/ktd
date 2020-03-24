package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns backgrounds installed by the user
 *
 * @property forDarkTheme True, if the backgrounds needs to be ordered for dark theme
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getBackgrounds")
data class TdGetBackgrounds(
    @SerialName("for_dark_theme")
    val forDarkTheme: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdBackgrounds> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetBackgrounds {
        return copy(extra = extra.copy(id = id))
    }
}
