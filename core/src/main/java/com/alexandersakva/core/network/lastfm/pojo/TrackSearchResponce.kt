package com.alexandersakva.core.network.lastfm.pojo

import com.google.gson.annotations.SerializedName

class TrackSearchResponce(
    @SerializedName("results")
    val results: Results = Results()
)