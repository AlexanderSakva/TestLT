package com.alexandersakva.core.di.viewmodel

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
interface ViewModelBindingModule {
    @Binds
    fun bindViewModelFactory(factory: InjectingViewModelFactory): ViewModelProvider.Factory
}