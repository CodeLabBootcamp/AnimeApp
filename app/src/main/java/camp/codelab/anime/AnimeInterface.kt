package camp.codelab.anime

import camp.codelab.anime.models.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeInterface {

    @GET("search/anime")
    fun searchAnime(@Query("q") searchQuery: String) : Call<SearchResponse>

}