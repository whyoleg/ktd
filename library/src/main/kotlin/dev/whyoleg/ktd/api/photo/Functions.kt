@file:Suppress("unused")

package dev.whyoleg.ktd.api.photo

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Uploads a new profile photo for the current user. If something changes, updateUser will be sent
 */
suspend fun TelegramClient.photo(
    f: SetProfilePhoto
): Ok = execRaw(f) as Ok

/**
 * Deletes a profile photo. If something changes, updateUser will be sent
 */
suspend fun TelegramClient.photo(
    f: DeleteProfilePhoto
): Ok = execRaw(f) as Ok
