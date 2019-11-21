package dev.whyoleg.ktd.generator.api.tl

sealed class TlData(
    open val type: String,
    open val parentType: String,
    open val metadata: TlMetadata
)

data class TlAbstract(
    override val type: String,
    override val metadata: TlMetadata
) : TlData(type, "Object", metadata)

sealed class TlClass(
    type: String,
    parentType: String,
    metadata: TlMetadata,
    open val crc: Int
) : TlData(type, parentType, metadata)

data class TlObject(
    override val type: String,
    override val parentType: String,
    override val metadata: TlMetadata,
    override val crc: Int
) : TlClass(type, parentType, metadata, crc)

data class TlFunction(
    override val type: String,
    val returnType: String,
    override val metadata: TlMetadata,
    override val crc: Int
) : TlClass(type, "Function", metadata, crc)
