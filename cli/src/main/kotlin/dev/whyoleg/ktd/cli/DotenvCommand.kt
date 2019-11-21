package dev.whyoleg.ktd.cli

import io.github.cdimascio.dotenv.*
import kotlinx.cli.*
import kotlinx.coroutines.*

@ExperimentalCli
abstract class DotenvCommand(name: String) : Subcommand(name) {
    private val env by option(ArgType.String, "env", "e", "Path to folder with .env").required()
    abstract suspend fun execute(dotenv: Dotenv)
    override fun execute() {
        val dotenv = dotenv {
            directory = env
        }
        runBlocking {
            execute(dotenv)
        }
    }
}
