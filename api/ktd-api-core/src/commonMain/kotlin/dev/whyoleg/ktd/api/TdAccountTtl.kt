package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about the period of inactivity after which the current user's account will automatically be deleted
 *
 * @property days Number of days of inactivity before the account will be flagged for deletion
 *                Should range from 30-366 days
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("accountTtl")
data class TdAccountTtl(
    @SerialName("days")
    val days: Int,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
