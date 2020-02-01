package dev.whyoleg.ktd.api

inline fun <T> TelegramApiResponse.map(
    onResponse: (TelegramResponse) -> T,
    onError: (TelegramError) -> T,
    onUpdate: (TelegramUpdate) -> T
): T = when (this) {
    is TelegramError    -> onError(this)
    is TelegramResponse -> onResponse(this)
    is TelegramUpdate   -> onUpdate(this)
    else                -> error("")
}

inline fun <T> TelegramResponseOrError.map(
    onResponse: (TelegramResponse) -> T,
    onError: (TelegramError) -> T
): T = when (this) {
    is TelegramError    -> onError(this)
    is TelegramResponse -> onResponse(this)
    else                -> error("")
}
