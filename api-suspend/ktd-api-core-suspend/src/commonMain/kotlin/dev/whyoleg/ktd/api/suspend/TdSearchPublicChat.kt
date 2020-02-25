package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Searches a public chat by its username
 * Currently only private chats, supergroups and channels can be public
 * Returns the chat if found
 * Otherwise an error is returned
 *
 * @property username Username to be resolved
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.searchPublicChat(username: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdChat = exec(TdSearchPublicChat(username, extra))
