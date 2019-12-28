package com.example.kotlinapplication.network

import com.example.kotlinapplication.data.model.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NaverApi {

    @GET("v1/search/movie.json")
    fun getMovieCall(@Query("query") query: String): Single<ResponseItems<MovieItem>>

    @GET("v1/search/image")
    fun getImageCall(@Query("query") query: String): Single<ResponseItems<ImageItem>>

    @GET("v1/search/blog.json")
    fun getBlogCall(@Query("query") query: String): Single<ResponseItems<BlogItem>>

    @GET("v1/search/kin.json")
    fun getKinCall(@Query("query") query: String): Single<ResponseItems<KinItem>>
}