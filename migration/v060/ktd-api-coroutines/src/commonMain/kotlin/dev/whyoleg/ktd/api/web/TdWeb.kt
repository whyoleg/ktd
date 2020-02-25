@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.web

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.web(f: TdGetWebPagePreview): TdWebPage = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getWebPagePreview(text)",
            "dev.whyoleg.ktd.api.suspend.getWebPagePreview"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getWebPagePreview(text: TdFormattedText? = null): TdWebPage =
        exec(TdGetWebPagePreview(text))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.web(f: TdGetWebPageInstantView): TdWebPageInstantView = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getWebPageInstantView(url, forceFull)",
            "dev.whyoleg.ktd.api.suspend.getWebPageInstantView"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getWebPageInstantView(url: String? = null, forceFull: Boolean = false):
        TdWebPageInstantView = exec(TdGetWebPageInstantView(url, forceFull))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.web(f: TdDisconnectWebsite): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("disconnectWebsite(websiteId)",
            "dev.whyoleg.ktd.api.suspend.disconnectWebsite"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.disconnectWebsite(websiteId: Long = 0L): TdOk =
        exec(TdDisconnectWebsite(websiteId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.web(f: TdDisconnectAllWebsites): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("disconnectAllWebsites()",
            "dev.whyoleg.ktd.api.suspend.disconnectAllWebsites"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.disconnectAllWebsites(): TdOk = exec(TdDisconnectAllWebsites())
