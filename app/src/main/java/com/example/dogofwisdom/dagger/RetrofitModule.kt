package com.example.dogofwisdom.dagger

import com.example.dogofwisdom.Config
import com.example.dogofwisdom.network.DogsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Config.BASE_URL).build()
    }

    @Singleton
    @Provides
    fun provideDogsApi(retrofit: Retrofit): DogsApi {
        return retrofit.create(DogsApi::class.java)
    }
}