package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns storage usage statistics
 * Can be called before authorization
 *
 * @property chatLimit The maximum number of chats with the largest storage usage for which separate statistics should be returned
 *                     All other chats will be grouped in entries with chat_id == 0
 *                     If the chat info database is not used, the chat_limit is ignored and is always set to 0
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getStorageStatistics(chatLimit: Int = 0, extra: TdExtra =
        TdExtra.EMPTY): TdStorageStatistics = exec(TdGetStorageStatistics(chatLimit, extra))
