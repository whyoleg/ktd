package dev.whyoleg.ktd.generator.api.builder

import dev.whyoleg.ktd.generator.api.tl.*

fun StringBuilder.buildAnnotations(additions: List<TlAddition>) {
    additions
        .filterIsInstance<TlAddition.Annotation>()
        .takeIf(List<*>::isNotEmpty)
        ?.map(TlAddition.Annotation::annotation)
        ?.distinct()
        ?.sorted()
        ?.joinTo(this, "\n@", "@", "\n")
}
