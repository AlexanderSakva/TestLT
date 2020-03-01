package com.alexandersakva.featuresonglistlastfm.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexandersakva.core.HasTitle
import com.alexandersakva.core.SearchPagerViewModel
import com.alexandersakva.featuresonglistlastfm.R
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.lastfm_song_list_fragment.*
import javax.inject.Inject


open class LastFmSongListFragment : Fragment(), HasTitle {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<LastFmSongListViewModel>({ this }, { viewModelFactory })
    private val searchViewModel by viewModels<SearchPagerViewModel>(
        { requireParentFragment() },
        null
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lastfm_song_list_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerSongs.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val adapter = SongsRecyclerAdapter()
        recyclerSongs.adapter = adapter
        val divider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        recyclerSongs.addItemDecoration(divider)
        swipeRefresh.isEnabled = false

        searchViewModel.query.observe(viewLifecycleOwner, Observer {
            viewModel.getSongs(it)
        })
        viewModel.songs.observe(viewLifecycleOwner, Observer {
            adapter.items = it
            if (it.isEmpty()) showToast(getString(R.string.lastfm_songs_not_found))
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            swipeRefresh.isRefreshing = it
        })
        viewModel.isFetchSuccessful.observe(viewLifecycleOwner, Observer {
            if (!it) {
                showToast(getString(R.string.lastfm_songs_error))
            }
        })
    }

    private fun showToast(message: String) {
        if (lifecycle.currentState != Lifecycle.State.RESUMED) return
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun getTitleResId(): Int {
        return R.string.lastfm
    }
}
