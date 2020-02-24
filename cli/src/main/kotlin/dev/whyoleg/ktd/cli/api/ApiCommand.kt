package dev.whyoleg.ktd.cli.api

import dev.whyoleg.ktd.cli.*
import dev.whyoleg.ktd.cli.api.generator.*
import dev.whyoleg.ktd.cli.tl.*
import kotlinx.cli.*
import java.io.*

@UseExperimental(ExperimentalCli::class)
class ApiCommand : Subcommand("api") {
    private val version by option(ArgType.String, "version", "v", "Version of TdLib").required()

    override fun execute() {
        println("Generate api for TdLib $version")
        val gitHub = gitHub()
        val tlBytes = gitHub.downloadScheme(version)
        val tdBytes = gitHub.downloadTdCpp(version)
        println("Files downloaded")
        val data = parseData(tdBytes, tlBytes)
        data.forEach { (kind, scheme) ->
            if (kind == TlKind.Ignore) return@forEach
            File("api/ktd-api-${kind.name.toLowerCase()}/src/commonMain/kotlin").deleteRecursively()
            File("api-suspend/ktd-api-${kind.name.toLowerCase()}-suspend/src/commonMain/kotlin").deleteRecursively()

            tdApiFile(version, kind)
            tdApiClasses(scheme, kind)
            builderFile(scheme, kind)
            suspendTdApiFunctions(scheme, kind)
        }
        oldApiFile(data.getValue(TlKind.Core).copy(data = data.flatMap { it.value.data }))
        println("New api saved")
    }

}
