package dev.whyoleg.ktd.api.benchmarks

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*
import kotlinx.coroutines.*
import org.openjdk.jmh.annotations.*
import java.util.concurrent.*

@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 2, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
class ConcurrentSuspendBenchmark {
    private val request = TdTestCallEmpty()

    @Param("1", "10", "100")
    var count = 0

    private lateinit var runner: SynchronizedRunner
    private lateinit var clients: List<SuspendTdClient>

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
    fun run(): Unit = runBlocking {
        GlobalScope.launch {
            clients.forEach { client ->
                launch { client.exec(request) }
            }
        }.join()
    }
}
