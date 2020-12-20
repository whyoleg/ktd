package dev.whyoleg.ktd.api

sealed class TdResult {
    data class Update(val update: TdUpdate) : TdResult()
    sealed class ResponseOrError(open val id: Long) : TdResult() {
        data class Response(override val id: Long, val response: TdResponse) : ResponseOrError(id)
        data class Error(override val id: Long, val error: TdError) : ResponseOrError(id)
    }
}

sealed class TdTypedResult<out R : TdResponse> {
    data class Error(val error: TdError) : TdTypedResult<Nothing>()
    data class Response<R : TdResponse>(val response: R) : TdTypedResult<R>()
}

@Suppress("FunctionName")
internal fun TdResult(requestId: Long, response: TdApiResponse): TdResult = when (response) {
    is TdUpdate -> TdResult.Update(response)
    is TdError -> TdResult.ResponseOrError.Error(requestId, response)
    else -> TdResult.ResponseOrError.Response(requestId, response as TdResponse)
}

@Suppress("FunctionName")
internal fun <R : TdResponse> TdTypedResult(response: TdApiResponse): TdTypedResult<R> = when (response) {
    is TdError -> TdTypedResult.Error(response)
    else -> TdTypedResult.Response(@Suppress("UNCHECKED_CAST") (response as R))
}

internal fun <R : TdResponse> TdResult.ResponseOrError.typed(): TdTypedResult<R> = when (this) {
    is TdResult.ResponseOrError.Response -> TdTypedResult.Response(@Suppress("UNCHECKED_CAST") (response as R))
    is TdResult.ResponseOrError.Error -> TdTypedResult.Error(error)
}
