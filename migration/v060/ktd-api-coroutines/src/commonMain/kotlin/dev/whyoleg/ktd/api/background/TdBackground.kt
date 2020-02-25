@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.background

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.background(f: TdGetBackgrounds): TdBackgrounds = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getBackgrounds(forDarkTheme)",
            "dev.whyoleg.ktd.api.suspend.getBackgrounds"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getBackgrounds(forDarkTheme: Boolean = false): TdBackgrounds =
        exec(TdGetBackgrounds(forDarkTheme))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.background(f: TdGetBackgroundUrl): TdHttpUrl = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getBackgroundUrl(name, type)",
            "dev.whyoleg.ktd.api.suspend.getBackgroundUrl"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getBackgroundUrl(name: String? = null, type: TdBackgroundType? = null):
        TdHttpUrl = exec(TdGetBackgroundUrl(name, type))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.background(f: TdSearchBackground): TdBackground = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("searchBackground(name)",
            "dev.whyoleg.ktd.api.suspend.searchBackground"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.searchBackground(name: String? = null): TdBackground =
        exec(TdSearchBackground(name))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.background(f: TdSetBackground): TdBackground = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setBackground(background, type, forDarkTheme)",
            "dev.whyoleg.ktd.api.suspend.setBackground"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setBackground(
    background: TdInputBackground? = null,
    type: TdBackgroundType? = null,
    forDarkTheme: Boolean = false
): TdBackground = exec(TdSetBackground(background, type, forDarkTheme))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.background(f: TdRemoveBackground): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("removeBackground(backgroundId)",
            "dev.whyoleg.ktd.api.suspend.removeBackground"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.removeBackground(backgroundId: Long = 0L): TdOk =
        exec(TdRemoveBackground(backgroundId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.background(f: TdResetBackgrounds): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("resetBackgrounds()", "dev.whyoleg.ktd.api.suspend.resetBackgrounds"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.resetBackgrounds(): TdOk = exec(TdResetBackgrounds())
