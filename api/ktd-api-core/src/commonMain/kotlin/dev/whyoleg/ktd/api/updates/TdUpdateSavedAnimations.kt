package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * The list of saved animations was updated
 *
 * @property animationIds The new list of file identifiers of saved animations
 */
@Serializable
@SerialName("updateSavedAnimations")
data class TdUpdateSavedAnimations(
    @SerialName("animation_ids")
    val animationIds: IntArray
) : TdUpdate
