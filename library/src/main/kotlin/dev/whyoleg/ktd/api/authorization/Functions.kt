@file:Suppress("unused")

package dev.whyoleg.ktd.api.authorization

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the current authorization state; this is an offline request. For informational purposes only. Use updateAuthorizationState instead to maintain the current authorization state
 */
suspend fun TelegramClient.authorization(
    f: GetAuthorizationState
): AuthorizationState = execRaw(f) as AuthorizationState
