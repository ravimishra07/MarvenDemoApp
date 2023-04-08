package com.example.marvendemoapp.Service

import com.example.marvendemoapp.Model.TmdbData
import com.example.marvendemoapp.PopularMovies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("movie/popular")
     fun getMovie(
        @Query("api_key") key:String,
        @Query("page")page:Int
    ):Call<PopularMovies>
     @GET("movie/top_rated")
     fun getTopMovie(
         @Query("api_key") key:String,
         @Query("page")page:Int
     ):Call<PopularMovies>
     @GET("movie/popular")
     fun upcomingMovie(
         @Query("api_key") key:String,
         @Query("page")page:Int
     ):Call<PopularMovies>

}