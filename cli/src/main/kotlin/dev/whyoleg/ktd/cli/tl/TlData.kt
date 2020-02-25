package dev.whyoleg.ktd.cli.tl

sealed class TlData(
    open val type: String,
    open val parentType: String?,
    open val metadata: TlMetadata
)

data class TlSealed(
    override val type: String,
    override val metadata: TlMetadata
) : TlData(type, null, metadata)

sealed class TlClass(
    type: String,
    parentType: String?,
    metadata: TlMetadata
) : TlData(type, parentType, metadata)

data class TlSealedChild(
    override val type: String,
    override val parentType: String,
    override val metadata: TlMetadata
) : TlClass(type, parentType, metadata)

data class TlObject(
    override val type: String,
    override val metadata: TlMetadata
) : TlClass(type, null, metadata)

data class TlFunction(
    override val type: String,
    val returnType: String,
    override val metadata: TlMetadata
) : TlClass(type, null, metadata)
