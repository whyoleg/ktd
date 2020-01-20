package dev.whyoleg.ktd.cli.diff.data

enum class StringDiffChange {
    Removed, Added, NoChange
}

data class StringDiff(
    val value: String,
    val change: StringDiffChange
)
