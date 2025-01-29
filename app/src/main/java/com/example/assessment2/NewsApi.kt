import com.example.assessment2.Constants
import com.example.assessment2.NewsEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("news")
    suspend fun getNews(
        @Query("access_key") apiKey: String = Constants.API_KEY,
        @Query("country") country: String = "us,au",
        @Query("source") source: String = "cnn,bbc"

    ): NewsEntity

}

