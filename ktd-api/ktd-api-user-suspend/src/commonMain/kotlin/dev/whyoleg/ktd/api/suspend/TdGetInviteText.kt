package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the default text for invitation messages to be used as a placeholder when the current user invites friends to Telegram
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getInviteText(extra: TdExtra = TdExtra.EMPTY): TdText =
        exec(TdGetInviteText(extra))
