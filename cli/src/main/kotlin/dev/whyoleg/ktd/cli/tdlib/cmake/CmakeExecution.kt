package dev.whyoleg.ktd.cli.tdlib.cmake

data class CmakeExecution(
    val crossCompile: CmakeConfig?,
    val build: CmakeConfig,
    val lib: CmakeConfig,
    val before: suspend () -> Unit = {},
    val after: suspend CmakeExecutionResult.() -> Unit = {}
)

operator fun CmakeExecution.plus(other: CmakeExecution): CmakeExecution = CmakeExecution(
    crossCompile = when {
        crossCompile == null -> other.crossCompile
        other.crossCompile == null -> crossCompile
        else -> crossCompile + other.crossCompile
    },
    build = build + other.build,
    lib = lib + other.lib,
    before = {
        before()
        other.before()
    },
    after = {
        after(this)
        other.after(this)
    }
)
