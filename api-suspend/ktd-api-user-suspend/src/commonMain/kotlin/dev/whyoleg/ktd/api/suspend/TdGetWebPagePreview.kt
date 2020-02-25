package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a web page preview by the text of the message
 * Do not call this function too often
 * Returns a 404 error if the web page has no preview
 *
 * @property text Message text with formatting
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getWebPagePreview(text: TdFormattedText? = null, extra: TdExtra =
        TdExtra.EMPTY): TdWebPage = exec(TdGetWebPagePreview(text, extra))
