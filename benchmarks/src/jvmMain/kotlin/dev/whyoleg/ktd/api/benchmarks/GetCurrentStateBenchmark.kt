package dev.whyoleg.ktd.api.benchmarks

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*
import dev.whyoleg.ktd.api.internal.*
import dev.whyoleg.ktd.client.*
import kotlinx.benchmark.*
import kotlinx.coroutines.*

@State(Scope.Benchmark)
@OutputTimeUnit(BenchmarkTimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
class GetCurrentStateBenchmark {
    @Suppress("DEPRECATION_ERROR")
    private val api = InternalTdApi("1.5.0") {
        polymorphic<TdApiRequest> {
            addSubclass(GetCurrentState.serializer())
            addSubclass(TdClose.serializer())
        }
        polymorphic<TdApiResponse> {
            addSubclass(TdOk.serializer())
            addSubclass(TdError.serializer())
            addSubclass(Updates.serializer())
        }
        polymorphic(TdApiResponse::class, Update::class) {
            addSubclass(UpdateAuthorizationState.serializer())
            addSubclass(UpdateOption.serializer())
        }
        polymorphic(TdApiResponse::class, AuthorizationState::class) {
            addSubclass(AuthorizationStateWaitTdlibParameters.serializer())
            addSubclass(AuthorizationStateClosing.serializer())
            addSubclass(AuthorizationStateClosed.serializer())
        }
        polymorphic(TdApiResponse::class, OptionValue::class) {
            addSubclass(OptionValueBoolean.serializer())
            addSubclass(OptionValueEmpty.serializer())
            addSubclass(OptionValueString.serializer())
            addSubclass(OptionValueInteger.serializer())
        }
    }.value

    private lateinit var client: DeferredTdClient
    private lateinit var runner: SingleThreadRunner

    @Setup
    fun setUp() {
        runner = SingleThreadRunner()
        client = DeferredTdClient(api, runner = runner)
        //        client = DeferredTdClient(api)
        println("setUp: ${client.id}")
    }

    @TearDown
    fun teardown() {
        println("teardown[start]: ${client.id}")
        runBlocking { client.cancelAndJoin() }
        println("teardown[end]: ${client.id}")
        runner.shutdown()
    }

    @Benchmark
    fun getCurrentState(): Unit = runBlocking {
        repeat(10) {
            client.send(GetCurrentState())
        }
    }
}
