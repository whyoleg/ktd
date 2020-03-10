package dev.whyoleg.ktd.api

/**
 * Represents [TdRequest] or [TdResponse] which contains extra data.
 *
 * @property extra data shared between [TdRequest] and [TdResponse]
 */
interface TdPayload : TdObject {
    val extra: TdExtra
}
