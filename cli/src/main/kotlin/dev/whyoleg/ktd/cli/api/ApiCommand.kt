package dev.whyoleg.ktd.cli.api

import dev.whyoleg.ktd.cli.*
import dev.whyoleg.ktd.cli.api.generator.*
import dev.whyoleg.ktd.cli.tl.*
import kotlinx.cli.*
import java.io.*

class ApiCommand : Subcommand("api", "Generate API") {
    private val version by option(ArgType.String, "version", "v", "Version of TdLib").required()

    override fun execute() {
        println("Generate api for TdLib $version")
        val gitHub = gitHub()
        val tlBytes = gitHub.downloadScheme(version)
        val tdBytes = gitHub.downloadTdCpp(version)
        println("Files downloaded")
        val data = parseData(tdBytes, tlBytes)
        data.forEach { (kind, scheme) ->
            if (kind == TlKind.Ignore || kind == TlKind.All) return@forEach
            File("ktd-api/ktd-api-${kind.name.toLowerCase()}/src/commonMain/kotlin").deleteRecursively()
            File("ktd-api/ktd-api-${kind.name.toLowerCase()}-suspend/src/commonMain/kotlin").deleteRecursively()

            tdApiFile(version, kind)
            tdApiClasses(scheme, kind)
            builderFile(scheme, kind)
            suspendTdApiFunctions(scheme, kind)
        }
        File("migration/v060/ktd-api-raw/src/commonMain/kotlin").deleteRecursively()
        File("migration/v060/ktd-api-coroutines/src/commonMain/kotlin").deleteRecursively()
        oldApiFile(data.getValue(TlKind.All))
        oldSuspendTdApiFunctions(data.getValue(TlKind.All))
        println("New api saved")
    }

}
