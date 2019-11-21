package dev.whyoleg.ktd.generator.tdlib

import dev.whyoleg.ktd.generator.*
import dev.whyoleg.ktd.generator.tdlib.jvm.*
import eu.jrie.jetbrains.kotlinshell.shell.*
import org.kohsuke.github.*
import java.io.*

suspend fun main(args: Array<String>) {
    val version = args.first()
    val currentTarget = currentTarget(args.getOrNull(1))
    println("Start build tdlib $version for $currentTarget")
    checkoutVersion(version)
    val result = when (currentTarget) {
        CurrentTarget.Linux      -> buildLinux()
        CurrentTarget.MacOS      -> buildMacOS()
        is CurrentTarget.Windows -> buildWindows(currentTarget.jvm)
    }
    val androidResults = BuildTarget.Jvm.Android.targets.map {
        println("Start build tdlib $version for $it")
        buildAndroid("/home/whyme/Android/Sdk", "/home/whyme/IdeaProjects/ktd/android-openssl", it).toString(it)
    }
    println((androidResults + result.toString(currentTarget.jvm)).joinToString("\n\n", "\n", "\n"))
}

suspend fun checkoutVersion(version: String) {
    @Suppress("BlockingMethodInNonBlockingContext")
    val commitSha = GitHub.connectAnonymously().findCommit(version).shA1
    shell(dir = File("td")) { "git reset --hard $commitSha"() }
}

fun File.mbSize(): String = "%.2f".format(readBytes().size.toDouble() / 1024 / 1024)