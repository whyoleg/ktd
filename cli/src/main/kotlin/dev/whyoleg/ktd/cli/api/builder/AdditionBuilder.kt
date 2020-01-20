package dev.whyoleg.ktd.cli.api.builder

import dev.whyoleg.ktd.cli.tl.*

fun StringBuilder.buildAnnotations(additions: List<TlAddition>) {
    additions
        .filterIsInstance<TlAddition.Annotation>()
        .takeIf(List<*>::isNotEmpty)
        ?.map(TlAddition.Annotation::annotation)
        ?.distinct()
        ?.sorted()
        ?.joinTo(this, "\n@", "@", "\n")
}
