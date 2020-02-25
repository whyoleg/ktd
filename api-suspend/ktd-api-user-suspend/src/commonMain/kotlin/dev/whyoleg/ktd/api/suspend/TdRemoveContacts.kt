package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Removes users from the contact list
 *
 * @property userIds Identifiers of users to be deleted
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.removeContacts(userIds: IntArray = intArrayOf(), extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdRemoveContacts(userIds, extra))
