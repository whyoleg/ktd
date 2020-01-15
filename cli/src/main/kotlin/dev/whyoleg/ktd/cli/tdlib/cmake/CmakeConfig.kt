package dev.whyoleg.ktd.cli.tdlib.cmake

data class CmakeConfig(
    val env: Map<String, String> = emptyMap(),
    val configureParams: List<String> = emptyList(),
    val installParams: List<String> = emptyList()
)

operator fun CmakeConfig.plus(other: CmakeConfig) = CmakeConfig(
    env = env + other.env,
    configureParams = configureParams + other.configureParams,
    installParams = installParams + other.installParams
)
