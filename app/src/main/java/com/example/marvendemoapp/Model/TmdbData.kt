package com.example.marvendemoapp.Model

import com.example.marvendemoapp.Model.Result

data class TmdbData(

    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)

