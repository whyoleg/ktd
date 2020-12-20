package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns an existing chat corresponding to a known basic group
 *
 * @property basicGroupId Basic group identifier
 * @property force If true, the chat will be created without network request
 *                 In this case all information about the chat except its type, title and photo can be incorrect
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.createBasicGroupChat(
    basicGroupId: Int = 0,
    force: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdChat = exec(TdCreateBasicGroupChat(basicGroupId, force, extra))
