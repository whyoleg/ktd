package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the current authorization state
 * This is an offline request
 * For informational purposes only
 * Use updateAuthorizationState instead to maintain the current authorization state
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getAuthorizationState(extra: TdExtra = TdExtra.EMPTY):
        TdAuthorizationState = exec(TdGetAuthorizationState(extra))
