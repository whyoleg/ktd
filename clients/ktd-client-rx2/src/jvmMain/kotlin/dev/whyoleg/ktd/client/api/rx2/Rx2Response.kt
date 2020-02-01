package dev.whyoleg.ktd.client.api.rx2

import dev.whyoleg.ktd.api.*
import io.reactivex.*
import io.reactivex.subjects.*

typealias Rx2Response = Single<TelegramResponse>
typealias Rx2ResponseHandler = SingleSubject<TelegramResponse>
