package dev.whyoleg.ktd.api.benchmarks

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*
import org.openjdk.jmh.annotations.*
import java.util.concurrent.*
import java.util.concurrent.atomic.*

@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 2, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
class LifecycleBenchmark {
    @Benchmark
    fun run() {
        val request = TdTestCallEmpty()
        val lock = AtomicBoolean(false)
        val destroyed = AtomicBoolean(false)
        val client = TestTdApi.defaultTdClient(onClose = { destroyed.set(true) })
        repeat(100) {
            lock.set(true)
            client.sendCallback(request) { lock.set(false) }
            while (lock.get()) Unit
        }
        client.close()
        while (!destroyed.get()) Unit
    }
}
