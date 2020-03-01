package com.alexandersakva.testlt.di

import com.alexandersakva.core.di.scope.ActivityScope
import com.alexandersakva.featuresearchpager.di.SearchModule
import com.alexandersakva.testlt.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppModule {

    @ActivityScope
    @ContributesAndroidInjector (modules = [SearchModule::class])
    fun mainActivity(): MainActivity

}