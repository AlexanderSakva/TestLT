package com.alexandersakva.core.network.lastfm.pojo

import com.google.gson.annotations.SerializedName

class Results(
    @SerializedName("trackmatches")
    val trackMatches: TracksMatches = TracksMatches()
)