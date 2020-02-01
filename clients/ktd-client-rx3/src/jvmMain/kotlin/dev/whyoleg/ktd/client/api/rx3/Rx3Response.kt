package dev.whyoleg.ktd.client.api.rx3

import dev.whyoleg.ktd.api.*
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.subjects.*

typealias Rx3Response = Single<TelegramResponse>
typealias Rx3ResponseHandler = SingleSubject<TelegramResponse>
