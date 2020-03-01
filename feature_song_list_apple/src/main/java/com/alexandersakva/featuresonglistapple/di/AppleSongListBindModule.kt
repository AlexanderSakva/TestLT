package com.alexandersakva.featuresonglistapple.di

import androidx.lifecycle.ViewModel
import com.alexandersakva.core.di.scope.FragmentScope
import com.alexandersakva.core.di.viewmodel.ViewModelKey
import com.alexandersakva.featuresonglistapple.AppleSongRepository
import com.alexandersakva.featuresonglistapple.ui.AppleSongListFragment
import com.alexandersakva.featuresonglistapple.ui.AppleSongListViewModel
import com.alexandersakva.featuresongapi.SongRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Named


@Module
interface AppleSongListBindModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun songListFragment(): AppleSongListFragment

    @Binds
    @Reusable
    @Named("AppleRepository")
    fun bindSongRepository(songRepository: AppleSongRepository): SongRepository

    @Binds
    @IntoMap
    @ViewModelKey(AppleSongListViewModel::class)
    fun bindSongListViewModel(viewModel: AppleSongListViewModel): ViewModel
}
