package com.alexandersakva.core.network.apple.pojo

import com.google.gson.annotations.SerializedName

class AppleResponse(
    @SerializedName("resultCount")
    val count: Int,
    @SerializedName("results")
    val songList: List<AppleResult>
)