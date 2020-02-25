package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about a related article
 *
 * @property url Related article URL
 * @property title Article title
 * @property description Article description
 * @property photo Article photo
 * @property author Article author
 * @property publishDate Point in time (Unix timestamp) when the article was published
 *                       0 if unknown
 */
@Serializable
@SerialName("pageBlockRelatedArticle")
data class TdPageBlockRelatedArticle(
    @SerialName("url")
    val url: String,
    @SerialName("title")
    val title: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("photo")
    val photo: TdPhoto?,
    @SerialName("author")
    val author: String?,
    @SerialName("publish_date")
    val publishDate: Int
) : TdObject
