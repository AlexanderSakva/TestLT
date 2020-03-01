package com.alexandersakva.featuresonglistlastfm.di

import androidx.lifecycle.ViewModel
import com.alexandersakva.core.di.scope.FragmentScope
import com.alexandersakva.core.di.viewmodel.ViewModelKey
import com.alexandersakva.featuresongapi.SongRepository
import com.alexandersakva.featuresonglistlastfm.LastFmSongRepository
import com.alexandersakva.featuresonglistlastfm.ui.LastFmSongListFragment
import com.alexandersakva.featuresonglistlastfm.ui.LastFmSongListViewModel
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Named


@Module
interface LastFmSongListBindModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun songListFragment(): LastFmSongListFragment

    @Binds
    @Reusable
    @Named("LastFmRepository")
    fun bindSongRepository(songRepository: LastFmSongRepository): SongRepository

    @Binds
    @IntoMap
    @ViewModelKey(LastFmSongListViewModel::class)
    fun bindSongListViewModel(viewModel: LastFmSongListViewModel): ViewModel
}
