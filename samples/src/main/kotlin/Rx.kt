import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.time.*

//rx3
fun <R : TdResponse> send(request: TdRequest<R>): Single<R> = Single.create { sendCallback(request, it::onSuccess, it::onError) }

//rx2
fun <R : TdResponse> send(request: TdRequest<R>): Single<R> = Single.create { sendCallback(request, it::onSuccess, it::onError) }

//reaktive
fun <R : TdResponse> send(request: TdRequest<R>): Single<R> = single { sendCallback(request, it::onSuccess, it::onError) }

//reactor
fun <R : TdResponse> send(request: TdRequest<R>): Mono<R> = Mono.create { sendCallback(request, it::success, it::error) }
