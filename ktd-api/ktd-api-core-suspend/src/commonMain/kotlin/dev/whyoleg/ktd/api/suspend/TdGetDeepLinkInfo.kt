package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about a tg:// deep link
 * Use "tg://need_update_for_some_feature" or "tg:some_unsupported_feature" for testing
 * Returns a 404 error for unknown links
 * Can be called before authorization
 *
 * @property link The link
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getDeepLinkInfo(link: String? = null, extra: TdExtra = TdExtra.EMPTY):
        TdDeepLinkInfo = exec(TdGetDeepLinkInfo(link, extra))
