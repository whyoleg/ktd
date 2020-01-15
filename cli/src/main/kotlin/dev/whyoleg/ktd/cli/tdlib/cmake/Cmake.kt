package dev.whyoleg.ktd.cli.tdlib.cmake

import eu.jrie.jetbrains.kotlinshell.processes.process.*
import eu.jrie.jetbrains.kotlinshell.shell.*
import java.io.*
import kotlin.time.*

private fun List<String>.join(): String = if (isEmpty()) "" else joinToString(" ", " ")

class Cmake(private val cmd: String) {
    suspend fun Shell.exec(cmd: String): Duration = cmd.also(::println).invoke().measure()
    suspend fun Shell.configure(args: List<String>): Duration = exec("$cmd${args.join()} ..")
    suspend fun Shell.buildTarget(target: String, args: List<String>): Duration = exec("$cmd --build . --target $target${args.join()}")
    suspend fun Shell.install(args: List<String>): Duration = buildTarget("install", args)
    suspend fun Shell.crossCompile(args: List<String>): Duration = buildTarget("prepare_cross_compiling", args)
}

suspend fun Cmake.run(buildDir: File, config: CmakeConfig, target: String): Pair<Duration, Duration> {
    var duration1: Duration? = null
    var duration2: Duration? = null
    shell(config.env, buildDir) {
        duration1 = configure(config.configureParams)
        duration2 = buildTarget(target, config.installParams)
    }
    return duration1!! to duration2!!
}

fun Process.measure(): Duration {
    var duration = Duration.ZERO
    pcb.apply {
        startTime?.let { st ->
            endTime?.let { et ->
                duration = (et.toEpochMilli() - st.toEpochMilli()).milliseconds
                println("Execution time: $duration")
            }
        } ?: println("Can't measure execution time")
    }
    if (pcb.exitCode != 0) throw ExitCodeException(pcb.exitCode)
    return duration
}


class ExitCodeException(exitCode: Int) : Throwable("Finished with exit code: $exitCode")

