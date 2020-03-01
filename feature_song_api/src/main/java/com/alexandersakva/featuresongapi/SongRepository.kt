package com.alexandersakva.featuresongapi

import io.reactivex.Single

interface SongRepository {
    fun getSongs(title: String): Single<List<Song>>
}