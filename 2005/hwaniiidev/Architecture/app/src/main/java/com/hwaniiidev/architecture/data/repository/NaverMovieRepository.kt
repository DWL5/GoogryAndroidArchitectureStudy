package com.hwaniiidev.architecture.data.repository

import android.content.Context
import com.hwaniiidev.architecture.model.Item
import com.hwaniiidev.architecture.model.ResponseMovieSearchData

interface NaverMovieRepository {
    fun getRemoteMovies(
        query: String,
        //onSuccess : (movies : ArrayList<Item>) -> Unit,
        onSuccess: (response: ResponseMovieSearchData) -> Unit,
        onError: (errorMessage: String) -> Unit,
        onFailure: (t: Throwable) -> Unit
    )

    fun cachingMovies(
        context: Context,
        query: String,
        movies: ArrayList<Item>
    )
}