package com.alexandersakva.core.network.apple.pojo

import com.google.gson.annotations.SerializedName

data class AppleResult(
    @SerializedName("trackName")
    val title: String = "",
    @SerializedName("artistName")
    val artist: String = "",
    @SerializedName("collectionName")
    val album: String = "",
    @SerializedName("artworkUrl100")
    val imageUrl: String = ""
)