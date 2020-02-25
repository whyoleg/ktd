@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.deep

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.deep(f: TdGetDeepLinkInfo): TdDeepLinkInfo = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getDeepLinkInfo(link)",
            "dev.whyoleg.ktd.api.suspend.getDeepLinkInfo"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getDeepLinkInfo(link: String? = null): TdDeepLinkInfo =
        exec(TdGetDeepLinkInfo(link))
