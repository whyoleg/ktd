package dev.whyoleg.ktd.api

/**
 * Base interface for any telegram object
 */
interface TdObject


/**
 * Untyped request to tdlib
 */
interface TdApiRequest : TdObject

/**
 * Represents request with associated [TdResponse] of type [R].
 * Response from [TdApi] will be of type [TdResponseOrError]
 *
 * @param R type of associated [TdResponse]
 */
interface TdRequest<R : TdResponse> : TdApiRequest

/**
 * Represents [TdRequest] which can be executed synchronously using [TdApi.execute]
 */
interface TdSyncRequest<R : TdResponse> : TdRequest<R>


/**
 * Represents response from tdlib. Can be of type: [TdUpdate], [TdResponse], [TdError]
 */
interface TdApiResponse : TdObject

/**
 * Represents update from tdlib
 */
interface TdUpdate : TdApiResponse

/**
 * Represents [TdResponse] or [TdError] related to request, linked by request id
 */
interface TdResponseOrError : TdApiResponse

/**
 * Represents untyped response of [TdRequest]
 */
interface TdResponse : TdResponseOrError


/**
 * An object of this type is returned on a successful function call for certain functions
 */
object TdOk : TdResponse

/**
 * An object of this type can be returned on every function call, in case of an error
 * Represents error from [TdApi]
 *
 * @property code Error code
 *                If the error code is 406, the error message must not be processed in any way and must not be displayed to the user
 * @property msg Error message
 */
data class TdError(val code: Int, val msg: String) : Throwable("$code: $msg"), TdResponseOrError

///**
// * Closes the TDLib instance.
// * All databases will be flushed to disk and properly closed.
// * After the close completes, updateAuthorizationState with authorizationStateClosed will be sent
// */
////TODO make internal
//object TdClose : TdRequest<TdOk>
//
///**
// * Closes the TDLib instance, destroying all local data without a proper logout.
// * The current user session will remain in the list of all active sessions.
// * All local data will be destroyed. After the destruction completes updateAuthorizationState with authorizationStateClosed will be sent
// */
////TODO make internal
//object TdDestroy : TdRequest<TdOk>
