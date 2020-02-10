package dev.whyoleg.ktd.api.benchmarks

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*
import kotlinx.benchmark.*
import kotlinx.coroutines.*
import kotlin.concurrent.*

private object TestRunner : SynchronizedRunner {
    override fun run(id: Long, onClose: () -> Unit, block: () -> Boolean) {
        thread {
            try {
                do Unit while (block())
            } finally {
                onClose()
            }
        }
    }
}

@State(Scope.Benchmark)
@OutputTimeUnit(BenchmarkTimeUnit.MILLISECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
class GetCurrentStateBenchmark {
    @Suppress("DEPRECATION_ERROR")

    private lateinit var client: DeferredTdClient

    @Setup
    fun setUp() {
        client = DeferredTdClient(TdApi, runner = TestRunner)
        println(client.id)
    }

    @TearDown
    fun teardown() {
        runBlocking {
            client.cancelAndJoin()
        }
    }

    @Benchmark
    fun getCurrentState(): Unit = runBlocking {
        repeat(10) {
            client.exec(TdGetCurrentState()).updates.also(::println)
        }
    }
}
