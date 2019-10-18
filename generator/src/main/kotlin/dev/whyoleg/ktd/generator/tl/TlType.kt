package dev.whyoleg.ktd.generator.tl

sealed class TlType(open val default: String) {
    abstract val kotlinType: String
}

sealed class TlPrimitiveType(override val kotlinType: String, override val default: String) : TlType(default)

object TlIntType : TlPrimitiveType("Int", "0")
object TlLongType : TlPrimitiveType("Long", "0L")
object TlDoubleType : TlPrimitiveType("Double", "0.0")
object TlBooleanType : TlPrimitiveType("Boolean", "false")

object TlByteArrayType : TlPrimitiveType("ByteArray", "null")

sealed class TlNullableType(override val kotlinType: String) : TlType("null")

data class TlRefType(override val kotlinType: String) : TlNullableType(kotlinType)
data class TlArrayType(val type: TlType) : TlNullableType(type.arrayKotlinType)

val TlType.arrayKotlinType: String get() = if (this is TlPrimitiveType) "${kotlinType}Array" else "Array<${kotlinType}>"

fun String.toTlType(): TlType = when (val type = capitalize()) {
    "Int32"          -> TlIntType
    "Int53", "Int64" -> TlLongType
    "Double"         -> TlDoubleType
    "Bool"           -> TlBooleanType
    "Bytes"          -> TlByteArrayType
    else             -> when {
        type.startsWith("Vector") -> TlArrayType(type.drop(7).dropLast(1).capitalize().toTlType())
        else                      -> TlRefType(type)
    }
}
