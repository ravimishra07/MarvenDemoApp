package com.example.marvendemoapp

data class PopularMovies(
    val results : List<Result>
)
data class Result(
    val id: Int,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)
