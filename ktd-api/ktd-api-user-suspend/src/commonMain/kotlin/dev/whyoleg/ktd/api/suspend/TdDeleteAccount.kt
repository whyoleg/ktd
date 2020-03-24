package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Deletes the account of the current user, deleting all information associated with the user from the server
 * The phone number of the account can be used to create a new account
 * Can be called before authorization when the current authorization state is authorizationStateWaitPassword
 *
 * @property reason The reason why the account was deleted
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.deleteAccount(reason: String? = null, extra: TdExtra = TdExtra.EMPTY):
        TdOk = exec(TdDeleteAccount(reason, extra))
