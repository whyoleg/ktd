package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a single result of an inline query
 */
@Serializable
sealed class TdInputInlineQueryResult : TdObject
