package dev.whyoleg.ktd.cli.diff

import dev.whyoleg.ktd.cli.*
import dev.whyoleg.ktd.cli.diff.builder.*
import dev.whyoleg.ktd.cli.tl.*

import kotlinx.cli.*
import org.kohsuke.github.*
import java.io.*

@UseExperimental(ExperimentalCli::class)
class DiffCommand : Subcommand("diff") {
    private val previousVersion by option(ArgType.String, "previousVersion", "pv", "A previous version of TdLib").required()
    private val newVersion by option(ArgType.String, "newVersion", "nv", "A new version of TdLib").required()

    override fun execute() {
        val gitHub = gitHub()
        val previousScheme = gitHub.scheme(previousVersion)
        val currentScheme = gitHub.scheme(newVersion)

        val file = File("docs/td-api-changelog.md")
        val fileLines = file.readText().lines()

        val newText = previousScheme stringDiff currentScheme

        val versionSectionHeader = "\n## $newVersion\n\n"
        val versionsSectionLine = "- [$newVersion](#${newVersion.filter(Char::isDigit)})"

        val section = fileLines.takeWhile { it.isNotBlank() }
        val start = section.take(2)
        val end = section.drop(2)

        val header = (start + versionsSectionLine + end + versionSectionHeader).joinToString("\n")
        val other = fileLines.drop(section.size).joinToString("\n")
        val newFileText = header + newText!! + other

        file.writeText(newFileText)
    }

    private fun GitHub.scheme(version: String): TlScheme = downloadScheme(version).parseScheme()
}
