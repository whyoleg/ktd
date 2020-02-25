package dev.whyoleg.ktd.cli.tl

import dev.whyoleg.ktd.cli.tl.parser.*

data class TlScheme(val data: List<TlData>)

fun ByteArray.parseScheme(): TlScheme = TlScheme(readTlScheme().parseTlData())
