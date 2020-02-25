package dev.whyoleg.ktd.api

/**
 * Represents [TdRequest] or [TdResponse] which contains extra data.
 */
interface TdPayload : TdObject {
    val extra: TdExtra
}
