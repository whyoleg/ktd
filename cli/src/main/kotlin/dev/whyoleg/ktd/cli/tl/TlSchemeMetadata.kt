package dev.whyoleg.ktd.cli.tl

import dev.whyoleg.ktd.cli.tl.parser.*

data class TlScheme(
    val data: List<TlData>,
    val metadata: TlSchemeMetadata
)

data class TlSchemeMetadata(
    val datas: List<TlData>,
    val responses: Set<String>,
    val requests: Map<String, String>,
    val sealedResponses: Map<String, List<TlData>>
)

fun List<TlData>.extractMetadata(): TlSchemeMetadata {
    val requests = filterIsInstance<TlFunction>()
    val responseTypes = requests.map(TlFunction::returnType).toSet()
    val requestsTypes = requests.associate { it.type to it.returnType }
    val sealedResponses = filterIsInstance<TlAbstract>().map(TlAbstract::type).associateWith { t -> filter { it.parentType == t } }
    return TlSchemeMetadata(this, responseTypes, requestsTypes, sealedResponses)
}

fun ByteArray.parseScheme(): TlScheme {
    val tlData = readTlScheme().parseTlData()
    val metadata = tlData.extractMetadata()
    return TlScheme(tlData, metadata)
}
