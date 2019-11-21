package dev.whyoleg.ktd.cli

import dev.whyoleg.ktd.cli.api.*
import dev.whyoleg.ktd.cli.tdlib.*
import kotlinx.cli.*

@UseExperimental(ExperimentalCli::class)
fun main(args: Array<String>) {
    val api = arrayOf("api", "-v", "1.4.0", "-e", "config/api")
    val tdlibAndroid = arrayOf("tdlib", "-v", "1.5.1", "-p", "jvm", "-t", "android-armv7", "-e", "config/tdlib")
    val tdlibLinux = arrayOf("tdlib", "-v", "1.5.1", "-p", "jvm", "-t", "linux", "-e", "config/tdlib")
    val args = api
    val parser = ArgParser("ktd")
    parser.subcommands(TdlibCommand, ApiCommand)
    parser.parse(args)
}