package com.example.assessment2
import com.google.gson.annotations.SerializedName

data class NewsEntity(
    @SerializedName("data") val data: List<Data>
)

data class Data(
    @SerializedName("author") val author: String?,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("url") val url: String,
    @SerializedName("source") val source: String,
    @SerializedName("image") val image: String,
    @SerializedName("category") val category: String,
    @SerializedName("language") val language: String,
    @SerializedName("country") val country: String,
    @SerializedName("published_at") val publishedAt: String
)