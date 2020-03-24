package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Creates a new supergroup or channel and sends a corresponding messageSupergroupChatCreate
 * Returns the newly created chat
 *
 * @property title Title of the new chat
 * @property isChannel True, if a channel chat should be created
 * @property description Chat description
 * @property location Chat location if a location-based supergroup is being created
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.createNewSupergroupChat(
    title: String? = null,
    isChannel: Boolean = false,
    description: String? = null,
    location: TdChatLocation? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdChat = exec(TdCreateNewSupergroupChat(title, isChannel, description, location, extra))
