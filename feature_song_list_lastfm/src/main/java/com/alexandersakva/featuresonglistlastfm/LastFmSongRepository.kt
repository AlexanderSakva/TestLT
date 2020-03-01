package com.alexandersakva.featuresonglistlastfm

import com.alexandersakva.featuresongapi.Song
import com.alexandersakva.featuresongapi.SongRepository
import com.alexandersakva.core.network.lastfm.LastFmApi
import io.reactivex.Single
import javax.inject.Inject

class LastFmSongRepository @Inject constructor(private val api: LastFmApi) :
    SongRepository {
    override fun getSongs(title: String): Single<List<Song>> {
        return api.search( "track.search", title).map {
            it.results.trackMatches.tracks.map { song ->
                Song(
                    song.title,
                    song.artist,
                    "",
                    ""
                )
            }
        }
    }
}