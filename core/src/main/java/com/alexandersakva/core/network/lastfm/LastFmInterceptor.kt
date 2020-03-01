package com.alexandersakva.core.network.lastfm

import android.util.Log
import com.alexandersakva.core.BuildConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response


class LastFmInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl: HttpUrl = originalRequest.url()

        val url = originalUrl
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.LAST_FM_API_KEY)
            .addQueryParameter("format", "json")
            .build()

        val request = originalRequest
            .newBuilder()
            .url(url)
            .build()

        Log.d("url", url.toString())
        return chain.proceed(request)
    }
}