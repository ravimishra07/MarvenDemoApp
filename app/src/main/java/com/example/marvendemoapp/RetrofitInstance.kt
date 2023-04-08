package com.example.marvendemoapp

import com.example.marvendemoapp.Service.ApiClient
//import kotlinx.coroutines.DefaultExecutor.key
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.security.Key

private const val URL="https://api.themoviedb.org/3/"

object RetrofitInstance {
    var retrofit: Retrofit? = null
    @JvmStatic
    val apiClient: Retrofit
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }

//    private val retrofit = Retrofit.Builder().baseUrl(URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build().create(ApiClient::class.java)



//     val movieApi by lazy {
//        retrofit.create(ApiClient::class.java)
//    }
}