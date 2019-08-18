@file:Suppress("unused")

package dev.whyoleg.ktd.api.poll

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Changes user answer to a poll
 */
suspend fun TelegramClient.poll(
    f: SetPollAnswer
): Ok = execRaw(f) as Ok

/**
 * Stops a poll. A poll in a message can be stopped when the message has can_be_edited flag set
 */
suspend fun TelegramClient.poll(
    f: StopPoll
): Ok = execRaw(f) as Ok
