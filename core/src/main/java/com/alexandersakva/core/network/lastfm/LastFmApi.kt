package com.alexandersakva.core.network.lastfm

import com.alexandersakva.core.network.lastfm.pojo.TrackSearchResponce
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface LastFmApi {

    @GET("/2.0")
    fun search(@Query("method") method: String, @Query("track") searchTerm: String ): Single<TrackSearchResponce>
}