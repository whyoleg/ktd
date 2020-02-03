package dev.whyoleg.ktd.api

/**
 * Represents any response from [StaticTdApi]: [TdUpdate], [TdResponse], [TdError].
 */
interface TdApiResponse : TdPayload

/**
 * Represents update from [StaticTdApi].
 */
interface TdUpdate : TdApiResponse

/**
 * Represents [TdResponse] or [TdError] which will be handled by client.
 */
interface TdResponseOrError : TdApiResponse

/**
 * Represents untyped response of [TdRequest].
 */
interface TdResponse : TdResponseOrError
