package dev.whyoleg.ktd.cli.diff

import dev.whyoleg.ktd.cli.*
import dev.whyoleg.ktd.cli.diff.builder.*
import dev.whyoleg.ktd.cli.tl.*
import io.github.cdimascio.dotenv.*
import kotlinx.cli.*
import org.kohsuke.github.*
import java.io.*

@UseExperimental(ExperimentalCli::class)
object DiffCommand : DotenvCommand("diff") {
    private val previousVersion by option(ArgType.String, "previousVersion", "pv", "A previous version of tdlib").required()
    private val newVersion by option(ArgType.String, "newVersion", "nv", "A new version of tdlib").required()

    override suspend fun execute(dotenv: Dotenv) {
        val gitHub = gitHub()
        val previousScheme = gitHub.scheme(previousVersion)
        val currentScheme = gitHub.scheme(newVersion)
        val file = File("api/CHANGELOG.md")
        val fileText = file.readText()
        val newText = previousScheme stringDiff currentScheme
        val version = "\n\n## $newVersion\n\n"
        val header = fileText.substringBefore("\n")
        val newFileText = header + version + newText!! + fileText.substringAfter("\n")
        file.writeText(newFileText)
    }

    private suspend fun GitHub.scheme(version: String): TlScheme = downloadScheme(version).parseScheme()
}
