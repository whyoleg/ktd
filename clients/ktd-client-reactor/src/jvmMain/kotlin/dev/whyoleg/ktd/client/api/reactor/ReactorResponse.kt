package dev.whyoleg.ktd.client.api.reactor

import dev.whyoleg.ktd.api.*
import reactor.core.publisher.*

typealias ReactorResponse = Mono<TelegramResponse>
typealias ReactorResponseHandler = MonoProcessor<TelegramResponse>
