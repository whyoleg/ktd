package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Creates a new basic group and sends a corresponding messageBasicGroupChatCreate
 * Returns the newly created chat
 *
 * @property userIds Identifiers of users to be added to the basic group
 * @property title Title of the new basic group
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.createNewBasicGroupChat(
    userIds: IntArray = intArrayOf(),
    title: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdChat = exec(TdCreateNewBasicGroupChat(userIds, title, extra))
