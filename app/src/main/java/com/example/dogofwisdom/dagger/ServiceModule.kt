package com.example.dogofwisdom.dagger

import com.example.dogofwisdom.model.service.DogsService
import com.example.dogofwisdom.network.DogsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideDogsService(dogsApi: DogsApi): DogsService {
        return DogsService(dogsApi)
    }

}