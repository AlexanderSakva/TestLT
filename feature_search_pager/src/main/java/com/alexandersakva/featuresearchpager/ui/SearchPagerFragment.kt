package com.alexandersakva.featuresearchpager.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

import androidx.fragment.app.viewModels
import com.alexandersakva.core.HasTitle
import com.alexandersakva.core.SearchPagerViewModel
import com.alexandersakva.featuresearchpager.R
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.search_fragment.*
import javax.inject.Inject


class SearchPagerFragment : Fragment(), HasAndroidInjector {

    companion object {
        fun newInstance() =
            SearchPagerFragment()
    }

    @Inject
    lateinit var pagerFragments: Set<SearchPagerElement>
    @Inject
    internal lateinit var androidInjector: DispatchingAndroidInjector<Any>
    private val searchViewModel by viewModels<SearchPagerViewModel>({ this }, null)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        pager.adapter = ListPagerAdapter(childFragmentManager, pagerFragments.sortedBy { it.order })
        tabs.setupWithViewPager(pager, true)

        searchViewSong.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query == null) return false
                searchViewModel.search(query)
                searchViewSong.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }


    inner class ListPagerAdapter(
        private val fragmentManager: FragmentManager,
        private val pagerFragments: List<SearchPagerElement>
    ) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getItem(position: Int): Fragment {
            return fragmentManager.fragmentFactory.instantiate(
                ClassLoader.getSystemClassLoader(),
                pagerFragments.elementAt(position).fragmentClassName
            )
        }

        override fun getCount(): Int = pagerFragments.size

        override fun getPageTitle(position: Int): CharSequence? {
            val fragment = getItem(position)
            return if (fragment is HasTitle) getString(fragment.getTitleResId()) else "Unknown"
        }
    }


}
