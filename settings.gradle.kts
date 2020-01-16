val tdOnlyVersion = startParameter.projectProperties["tdOnlyVersion"]

val tdVersions = tdOnlyVersion?.let(::listOf) ?: listOf(
    "1.5.0",
    "1.5.1",
    "1.5.2",
    "1.5.3",
    "1.5.4"
)

val types = listOf(
    "raw",
    "coroutines"
)

modules {
    "client" {
        types.forEach {
            it("client/$it")
        }
    }
    "api" {
        "stub"("api/stub")
        "integration"()
        (types + "lib").forEach { type ->
            type("api/$type") {
                tdVersions.forEach {
                    "v$it"("api/$type/v$it")
                }
            }
        }
    }
    "cli"()
    if (tdOnlyVersion == null) "examples"()
}

enableFeaturePreview("GRADLE_METADATA")
