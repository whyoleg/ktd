package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a list of chat administrators
 *
 * @property administrators A list of chat administrators
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("chatAdministrators")
data class TdChatAdministrators(
    @SerialName("administrators")
    val administrators: List<TdChatAdministrator>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
