package com.myapp.rakaminnews.api

import com.myapp.rakaminnews.model.News_Respon
import com.myapp.rakaminnews.utils.Constant.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface News_Api {
    @GET("v2/top-headlines")
    suspend fun getNews(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<News_Respon>
}