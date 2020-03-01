package com.alexandersakva.featuresonglistlastfm.ui

import com.alexandersakva.core.SongListViewModel
import com.alexandersakva.featuresongapi.SongRepository
import javax.inject.Inject
import javax.inject.Named

class LastFmSongListViewModel @Inject constructor(@Named("LastFmRepository") repository: SongRepository) :
    SongListViewModel(repository) {
}