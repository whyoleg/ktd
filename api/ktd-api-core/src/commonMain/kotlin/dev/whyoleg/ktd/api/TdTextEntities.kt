package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a list of text entities
 *
 * @property entities List of text entities
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("textEntities")
data class TdTextEntities(
    @SerialName("entities")
    val entities: List<TdTextEntity>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
