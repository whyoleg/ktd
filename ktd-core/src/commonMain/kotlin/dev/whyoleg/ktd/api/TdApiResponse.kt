package dev.whyoleg.ktd.api

/**
 * Represents response from tdlib. Can be of type: [TdUpdate], [TdResponse], [TdError]
 */
interface TdApiResponse : TdObject

/**
 * Represents update from tdlib
 */
interface TdUpdate : TdApiResponse

/**
 * Represents [TdResponse] or [TdError] which will be handled by client
 */
interface TdResponseOrError : TdApiResponse, TdPayload

/**
 * Represents untyped response of [TdRequest]
 */
interface TdResponse : TdResponseOrError
