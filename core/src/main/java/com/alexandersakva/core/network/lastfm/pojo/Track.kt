package com.alexandersakva.core.network.lastfm.pojo

import com.google.gson.annotations.SerializedName

data class Track(
    @SerializedName("name")
    val title: String = "",
    @SerializedName("artist")
    val artist: String = ""
)