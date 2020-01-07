val tdVersions = listOf(
    "1.5.0"
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
        types.forEach { type ->
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
