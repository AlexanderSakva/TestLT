package com.alexandersakva.core.network.apple

import com.alexandersakva.core.network.apple.pojo.AppleResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AppleApi {

    @GET("/search")
    fun search(@Query("entity") entity: String, @Query("term") searchTerm: String ): Single<AppleResponse>
}