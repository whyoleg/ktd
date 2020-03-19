package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Part of the face, relative to which a mask should be placed
 */
@Serializable
sealed class TdMaskPoint : TdObject {
    /**
     * A mask should be placed relatively to the forehead
     */
    @Serializable
    @SerialName("maskPointForehead")
    object Forehead : TdMaskPoint()

    /**
     * A mask should be placed relatively to the eyes
     */
    @Serializable
    @SerialName("maskPointEyes")
    object Eyes : TdMaskPoint()

    /**
     * A mask should be placed relatively to the mouth
     */
    @Serializable
    @SerialName("maskPointMouth")
    object Mouth : TdMaskPoint()

    /**
     * A mask should be placed relatively to the chin
     */
    @Serializable
    @SerialName("maskPointChin")
    object Chin : TdMaskPoint()
}
