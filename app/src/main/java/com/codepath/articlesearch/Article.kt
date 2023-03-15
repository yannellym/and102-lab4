package com.codepath.articlesearch

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class SearchNewsResponse(
//     The annotation (with the @ symbol) marks it as Serializable,
//     and will be the initial response we get from the server. It will map to the
//     top level key "response" that we see in the JSON.
    @SerialName("response")
    val response: BaseResponse?
)

// Next we will represent "docs" with another data class.
// This will map to the base response, which will include the array of documents (articles)
// Each array element will be an individual article.
@Keep
@Serializable
data class BaseResponse(
    @SerialName("docs")
    val docs: List<Article>?
)

//We've made it down to the Article layer! Now, we will need to identify
// which pieces of information we need from the JSON response for each of the pieces
// that will be displayed on screen.
@Keep
@Serializable
data class Article(
    @SerialName("abstract")
    val abstract: String?,
    @SerialName("byline")
    val byline: Byline?,
    @SerialName("headline")
    val headline: HeadLine?,
    @SerialName("multimedia")
    val multimedia: List<MultiMedia>?,
)
    : java.io.Serializable {
    val mediaImageUrl = "https://www.nytimes.com/${multimedia?.firstOrNull { it.url != null }?.url ?: ""}"
}

@Keep
@Serializable
data class HeadLine(
    @SerialName("main")
    val main: String
) : java.io.Serializable

@Keep
@Serializable
data class Byline(
    @SerialName("original")
    val original: String? = null
) : java.io.Serializable

@Keep
@Serializable
data class MultiMedia(
    @SerialName("url")
    val url: String?
) : java.io.Serializable