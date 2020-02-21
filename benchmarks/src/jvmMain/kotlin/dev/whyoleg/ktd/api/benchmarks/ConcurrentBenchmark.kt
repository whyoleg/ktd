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
class ConcurrentBenchmark {
    private val request = TdTestCallEmpty()

    @Param("1", "10", "100")
    var count = 0

    private lateinit var runner: SynchronizedRunner
    private lateinit var clients: List<TdClient>

    @Setup
    fun setup() {
        runner = ExecutorThreadRunner()
        clients = List(count) { TestTdApi.defaultSuspendClient(runner = runner) }
    }

    @TearDown
    fun tearDown() {
        clients.forEach { it.close() }
        runner.cleanup()
    }

    @Setup(Level.Invocation)
    fun await() {
        Thread.sleep(count * 5L)
    }

    @Benchmark
    fun run() {
        val lock = AtomicInteger()
        clients.forEach {
            it.sendCallback(request) { lock.incrementAndGet() }
        }
        while (lock.get() != count) Unit
    }
}
