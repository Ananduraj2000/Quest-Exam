package com.example.assessment2
import NewsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRepository {
    suspend fun getNewsInfo(
        accessKey: String,
    ): List<NewsModel> {

        val api = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(NewsApi::class.java)

        return api.getNews(accessKey).toNewsModel()
    }
}

fun NewsEntity.toNewsModel(): List<NewsModel> {
    return this.data.map { (title, source, description) ->
        NewsModel(title, source, description)

    }
}