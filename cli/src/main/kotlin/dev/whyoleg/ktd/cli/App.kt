package dev.whyoleg.ktd.cli

import dev.whyoleg.ktd.cli.api.*
import dev.whyoleg.ktd.cli.tdlib.*
import kotlinx.cli.*

@UseExperimental(ExperimentalCli::class)
fun main(args: Array<String>) {
    val args: Array<String> = arrayOf("tdlib", "-v", "1.5.1", "-p", "jvm", "-t", "android-armv7") //tdlib android
    //    val args: Array<String> = arrayOf("tdlib", "-v", "1.5.1", "-p", "jvm", "-t", "linux") //tdlib linux
    //    val args: Array<String> = arrayOf("api", "-v", "1.4.0") //api
    val parser = ArgParser("ktd")
    parser.subcommands(TdlibCommand, ApiCommand)
    parser.parse(args)
}