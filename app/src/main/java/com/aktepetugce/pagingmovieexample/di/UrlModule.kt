package com.aktepetugce.pagingmovieexample.di

import com.aktepetugce.pagingmovieexample.util.ApiConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UrlModule {

    @Provides
    @Singleton
    fun provideUrl(): String = ApiConstants.BASE_URL
}