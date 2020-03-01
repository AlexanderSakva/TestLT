package com.alexandersakva.core.network.lastfm.pojo

import com.google.gson.annotations.SerializedName

class TracksMatches(
    @SerializedName("track")
    val tracks: List<Track> = emptyList()
)