package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about a public or private message link
 *
 * @property url The message link in the format "https://t.me/c/...", or "tg://privatepost?...", or "https://t.me/username/...", or "tg://resolve?..."
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getMessageLinkInfo(url: String? = null, extra: TdExtra = TdExtra.EMPTY):
        TdMessageLinkInfo = exec(TdGetMessageLinkInfo(url, extra))
