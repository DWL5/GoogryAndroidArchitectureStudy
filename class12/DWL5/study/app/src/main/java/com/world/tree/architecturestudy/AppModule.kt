package com.world.tree.architecturestudy

import com.world.tree.architecturestudy.model.BASE_URL
import com.world.tree.architecturestudy.model.MovieApi
import com.world.tree.architecturestudy.model.repository.remote.NaverRepository
import com.world.tree.architecturestudy.model.repository.remote.NaverRepositoryImpl
import com.world.tree.architecturestudy.model.source.remote.NaverRemoteDataSource
import com.world.tree.architecturestudy.model.source.remote.NaverRemoteDataSourceImpl
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single<MovieApi> {
        Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MovieApi::class.java)
    }
    
    single<NaverRemoteDataSource> { NaverRemoteDataSourceImpl(get())  }
    single<NaverRepository> { NaverRepositoryImpl(get()) }
}