package dev.whyoleg.ktd.client.api.reaktive

import com.badoo.reaktive.single.*
import com.badoo.reaktive.subject.publish.*
import dev.whyoleg.ktd.api.*

typealias ReaktiveResponse = Single<TelegramResponse>
typealias ReaktiveResponseHandler = PublishSubject<TelegramResponse>
