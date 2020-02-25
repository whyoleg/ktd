package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Constructs a persistent HTTP URL for a background
 *
 * @property name Background name
 * @property type Background type
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getBackgroundUrl(
    name: String? = null,
    type: TdBackgroundType? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdHttpUrl = exec(TdGetBackgroundUrl(name, type, extra))
