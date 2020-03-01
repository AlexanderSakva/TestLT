package com.alexandersakva.testlt.di

import com.alexandersakva.core.network.NetworkModule
import com.alexandersakva.core.di.viewmodel.ViewModelBindingModule
import com.alexandersakva.testlt.TestLTApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        ViewModelBindingModule::class,
        NetworkModule::class,
        AppModule::class]
)
@Singleton
interface AppComponent : AndroidInjector<TestLTApp> {
    @Component.Factory
    interface Factory : AndroidInjector.Factory<TestLTApp>
}