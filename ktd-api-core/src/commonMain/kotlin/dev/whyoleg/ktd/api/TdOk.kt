package dev.whyoleg.ktd.api

/**
 * An object of this type is returned on a successful function call for certain functions
 */
data class TdOk(override val extra: TdExtra = TdExtra.EMPTY) : TdResponse
