package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about a tg:// deep link
 *
 * @property text Text to be shown to the user
 * @property needUpdateApplication True, if user should be asked to update the application
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("deepLinkInfo")
data class TdDeepLinkInfo(
    @SerialName("text")
    val text: TdFormattedText,
    @SerialName("need_update_application")
    val needUpdateApplication: Boolean,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
