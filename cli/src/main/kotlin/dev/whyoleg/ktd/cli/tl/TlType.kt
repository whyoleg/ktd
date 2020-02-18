package dev.whyoleg.ktd.cli.tl

sealed class TlType(open val default: String) {
    abstract val kotlinType: String
}

sealed class TlPrimitiveType(override val kotlinType: String, override val default: String) : TlType(default) {
    override fun toString(): String = kotlinType
}

object TlIntType : TlPrimitiveType("Int", "0")
object TlLongType : TlPrimitiveType("Long", "0L")
object TlByteType : TlPrimitiveType("Byte", "0")
object TlDoubleType : TlPrimitiveType("Double", "0.0")
object TlBooleanType : TlPrimitiveType("Boolean", "false")

data class TlRefType(override val kotlinType: String) : TlType("null") {
    override fun toString(): String = kotlinType
}

data class TlArrayType(val type: TlType) : TlType(type.arrayDefault) {
    override val kotlinType: String = type.arrayKotlinType
    override fun toString(): String = kotlinType
}

val TlType.arrayKotlinType: String get() = if (this is TlPrimitiveType) "${kotlinType}Array" else "List<${kotlinType}>"
val TlType.arrayDefault: String get() = if (this is TlPrimitiveType) "${kotlinType.decapitalize()}ArrayOf()" else "emptyList()"

fun String.toTlType(): TlType = when (val type = capitalize()) {
    "Int32"          -> TlIntType
    "Int53", "Int64" -> TlLongType
    "Double"         -> TlDoubleType
    "Bool"           -> TlBooleanType
    "Bytes"          -> TlArrayType(TlByteType)
    else             -> when {
        type.startsWith("Vector") -> TlArrayType(type.drop(7).dropLast(1).capitalize().toTlType())
        else                      -> TlRefType(type)
    }
}
