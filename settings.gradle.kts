val tdVersions = listOf(
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
        (types + "lib").forEach { type ->
            type("api/$type") {
                tdVersions.forEach {
                    "v$it"("api/$type/v$it")
                }
            }
        }
    }
    "cli"()
    "examples"()
}

enableFeaturePreview("GRADLE_METADATA")
