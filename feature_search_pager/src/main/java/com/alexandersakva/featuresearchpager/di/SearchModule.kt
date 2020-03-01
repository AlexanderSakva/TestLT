package com.alexandersakva.featuresearchpager.di

import com.alexandersakva.core.di.scope.FeatureScope
import com.alexandersakva.featuresearchpager.ui.SearchPagerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
interface SearchModule {

    @FeatureScope
    @ContributesAndroidInjector(modules = [PagerFragmentsModule::class])
    fun searchFragment(): SearchPagerFragment

}

