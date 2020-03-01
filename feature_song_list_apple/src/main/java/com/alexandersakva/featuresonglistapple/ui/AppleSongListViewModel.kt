package com.alexandersakva.featuresonglistapple.ui

import com.alexandersakva.core.SongListViewModel
import com.alexandersakva.featuresongapi.SongRepository
import javax.inject.Inject
import javax.inject.Named

class AppleSongListViewModel @Inject constructor(@Named("AppleRepository") repository: SongRepository) :
    SongListViewModel(repository) {
}