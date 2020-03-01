package com.alexandersakva.core.network

import com.alexandersakva.core.network.lastfm.LastFmInterceptor
import com.alexandersakva.core.network.apple.AppleApi
import com.alexandersakva.core.network.lastfm.LastFmApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {
    private const val APPLE_BASE_URL = "https://itunes.apple.com"
    private const val BASE_URL = "http://ws.audioscrobbler.com"


    @JvmStatic
    @Provides
    @Singleton
    fun provideAppleApi(): AppleApi {
        return Retrofit.Builder().baseUrl(APPLE_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(AppleApi::class.java)
    }


    @JvmStatic
    @Provides
    @Singleton
    fun provideLastFmApi(): LastFmApi {
        val client = OkHttpClient.Builder().addInterceptor(LastFmInterceptor()).build()
        return Retrofit.Builder().baseUrl(BASE_URL)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LastFmApi::class.java)
    }
}