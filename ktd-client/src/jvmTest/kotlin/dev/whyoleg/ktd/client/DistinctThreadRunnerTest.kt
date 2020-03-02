package dev.whyoleg.ktd.client

import kotlin.test.*
import kotlin.time.*

class DistinctThreadRunnerTest {

    @Test
    fun concurrentRunners() {
        val runner = DistinctThreadRunner()
        val duration = measureTime {
            repeat(3) {
                runner.run(1) {
                    Thread.sleep(1000)
                    false
                }
            }
        }
        assertTrue(duration < 0.5.seconds)
    }

    @Test
    fun cleanupRunner() {
        val runner = DistinctThreadRunner()
        runner.run(0) { false }
        runner.cleanup()
        assertFailsWith<IllegalStateException> { runner.run(0) { true } }
    }

    @Test
    fun runnerFinishAfterFalse() {
        val runner = DistinctThreadRunner()
        val locker = Locker()
        runner.run(1) {
            locker.lock()
            val v = locker.checkAtomic()
            while (locker.isLocked) Unit
            v
        }
        repeat(3) {
            Thread.sleep(100)
            assertEquals(2 - it, locker.atomicValue)
            Thread.sleep(100)
            assertEquals(2 - it, locker.atomicValue)
            locker.unlock()
        }
        Thread.sleep(100)
        assertEquals(0, locker.atomicValue)
        Thread.sleep(100)
        assertEquals(0, locker.atomicValue)
        assertFalse(locker.isLocked)
    }

    @Test
    fun independentRunners() {
        val runner = DistinctThreadRunner()
        val lockers = List(3) { Locker() }
        lockers.forEach { locker ->
            runner.run(1) {
                locker.lock()
                val v = locker.checkAtomic()
                while (locker.isLocked) Unit
                v
            }
        }
        fun check(f: Int, s: Int, t: Int) {
            Thread.sleep(100)
            assertEquals(f, lockers[0].atomicValue)
            assertEquals(s, lockers[1].atomicValue)
            assertEquals(t, lockers[2].atomicValue)
        }
        check(2, 2, 2)
        lockers[0].unlock()
        check(1, 2, 2)
        lockers[1].unlock()
        check(1, 1, 2)
        lockers[0].unlock()
        check(0, 1, 2)
        lockers[0].unlock()
        Thread.sleep(100)
        assertFalse(lockers[0].isLocked)
        lockers[2].unlock()
        check(0, 1, 1)
        lockers[2].unlock()
        lockers[1].unlock()
        check(0, 0, 0)
        lockers[2].unlock()
        lockers[1].unlock()
        Thread.sleep(100)
        lockers.forEach { assertFalse(it.isLocked) }
    }

}
