package com.alexandersakva.testlt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alexandersakva.featuresearchpager.ui.SearchPagerFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    internal lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SearchPagerFragment.newInstance())
                .commitNow()
        }
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}
