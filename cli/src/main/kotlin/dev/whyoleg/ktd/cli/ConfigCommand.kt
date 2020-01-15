package dev.whyoleg.ktd.cli

import com.typesafe.config.*
import kotlinx.cli.*
import org.jetbrains.kotlinx.serialization.config.*
import java.io.*

@ExperimentalCli
abstract class ConfigCommand(name: String) : Subcommand(name) {
    val configPath by option(ArgType.String, "config", "c", "Path to .conf file").required()

    inline fun <reified T> config(path: String): T = ConfigParser.parse(ConfigFactory.parseFile(File(configPath)).getConfig(path))
}
