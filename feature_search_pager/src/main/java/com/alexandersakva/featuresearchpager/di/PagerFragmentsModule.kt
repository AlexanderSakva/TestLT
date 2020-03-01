package com.alexandersakva.featuresearchpager.di

import com.alexandersakva.featuresearchpager.ui.SearchPagerElement
import com.alexandersakva.featuresonglistapple.di.AppleSongListBindModule
import com.alexandersakva.featuresonglistapple.ui.AppleSongListFragment
import com.alexandersakva.featuresonglistlastfm.di.LastFmSongListBindModule
import com.alexandersakva.featuresonglistlastfm.ui.LastFmSongListFragment
import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet

@Module(includes = [AppleSongListBindModule::class, LastFmSongListBindModule::class])
object PagerFragmentsModule {

    @JvmStatic
    @Provides
    @ElementsIntoSet
    fun provideLastFmFragment(): Set<SearchPagerElement> {
        return setOf(
            SearchPagerElement(1, AppleSongListFragment::class.java.name),
            SearchPagerElement(2, LastFmSongListFragment::class.java.name)
        )
    }
}