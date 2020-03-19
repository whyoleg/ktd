package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Toggles sender signatures messages sent in a channel
 * Requires can_change_info rights
 *
 * @property supergroupId Identifier of the channel
 * @property signMessages New value of sign_messages
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.toggleSupergroupSignMessages(
    supergroupId: Int = 0,
    signMessages: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdToggleSupergroupSignMessages(supergroupId, signMessages, extra))
