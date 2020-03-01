package com.alexandersakva.featuresonglistapple

import com.alexandersakva.featuresongapi.Song
import com.alexandersakva.featuresongapi.SongRepository
import com.alexandersakva.core.network.apple.AppleApi
import io.reactivex.Single
import javax.inject.Inject

class AppleSongRepository @Inject constructor(private val api: AppleApi) :
    SongRepository {
    override fun getSongs(title: String): Single<List<Song>> {
        return api.search("song", title).map {
            it.songList.map { song ->
                Song(
                    song.title,
                    song.artist,
                    song.album,
                    song.imageUrl
                )
            }
        }
    }
}