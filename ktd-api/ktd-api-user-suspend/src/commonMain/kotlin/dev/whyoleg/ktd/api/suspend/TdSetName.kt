package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the first and last name of the current user
 * If something changes, updateUser will be sent
 *
 * @property firstName The new value of the first name for the user
 * @property lastName The new value of the optional last name for the user
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setName(
    firstName: String? = null,
    lastName: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetName(firstName, lastName, extra))
