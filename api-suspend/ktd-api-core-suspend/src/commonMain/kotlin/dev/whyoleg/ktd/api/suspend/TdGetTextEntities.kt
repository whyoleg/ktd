package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns all entities (mentions, hashtags, cashtags, bot commands, URLs, and email addresses) contained in the text
 * This is an offline method
 * Can be called before authorization
 *
 * @property text The text in which to look for entites
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getTextEntities(text: String? = null, extra: TdExtra = TdExtra.EMPTY):
        TdTextEntities = exec(TdGetTextEntities(text, extra))
