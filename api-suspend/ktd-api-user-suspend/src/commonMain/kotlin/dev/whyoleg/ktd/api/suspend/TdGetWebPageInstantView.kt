package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns an instant view version of a web page if available
 * Returns a 404 error if the web page has no instant view page
 *
 * @property url The web page URL
 * @property forceFull If true, the full instant view for the web page will be returned
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getWebPageInstantView(
    url: String? = null,
    forceFull: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdWebPageInstantView = exec(TdGetWebPageInstantView(url, forceFull, extra))
