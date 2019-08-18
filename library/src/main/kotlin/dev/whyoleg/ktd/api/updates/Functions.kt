@file:Suppress("unused")

package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns all updates needed to restore current TDLib state, i.e. all actual UpdateAuthorizationState/UpdateUser/UpdateNewChat and others. This is especially usefull if TDLib is run in a separate process. This is an offline method. Can be called before authorization
 */
suspend fun TelegramClient.updates(
    f: GetCurrentState
): Updates = execRaw(f) as Updates

/**
 * Informs the server about the number of pending bot updates if they haven't been processed for a long time; for bots only
 */
suspend fun TelegramClient.updates(
    f: SetBotUpdatesStatus
): Ok = execRaw(f) as Ok
