package dev.whyoleg.ktd.api.benchmarks

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*
import kotlinx.benchmark.*

@State(Scope.Benchmark)
@OutputTimeUnit(BenchmarkTimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
class TestCallEmptyBenchmark {
    private val request = TdTestCallEmpty()
    private lateinit var client: TdClient

    @Volatile
    private var lock = false

    @Setup
    fun setUp() {
        client = TestTdApi.defaultTdClient()
    }

    @TearDown
    fun teardown() {
        client.destroy()
    }

    @Benchmark
    fun run() {
        repeat(100) {
            while (lock) Unit
            lock = true
            client.sendCallback(request) { lock = false }
        }
        while (lock) Unit
    }
}
