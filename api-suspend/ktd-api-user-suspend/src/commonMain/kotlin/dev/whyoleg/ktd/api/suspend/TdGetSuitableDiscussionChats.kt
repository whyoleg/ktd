package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a list of basic group and supergroup chats, which can be used as a discussion group for a channel
 * Basic group chats need to be first upgraded to supergroups before they can be set as a discussion group
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getSuitableDiscussionChats(extra: TdExtra = TdExtra.EMPTY): TdChats =
        exec(TdGetSuitableDiscussionChats(extra))
