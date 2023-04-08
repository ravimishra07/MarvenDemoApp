package com.example.marvendemoapp

import com.example.marvendemoapp.Service.ApiClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private  const val  URL="https://api.themoviedb.org/3/"

object TopNewsRetrofitInstance {
 private var retrofit:Retrofit?=null
    @JvmStatic
    val apiClient:Retrofit
    get() {
        if (retrofit == null) {
            RetrofitInstance.retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return RetrofitInstance.retrofit!!
    }

}