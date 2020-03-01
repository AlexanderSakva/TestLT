package com.alexandersakva.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexandersakva.featuresongapi.Song
import com.alexandersakva.featuresongapi.SongRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


open class SongListViewModel(private val repository: SongRepository) : ViewModel() {

    private var disposable = CompositeDisposable()

    val songs: LiveData<List<Song>> = MutableLiveData()
    val isLoading: LiveData<Boolean> = MutableLiveData()
    val isFetchSuccessful: LiveData<Boolean> = MutableLiveData()

    fun getSongs(title: String) {
        isLoading as MutableLiveData
        isLoading.value = true
        isFetchSuccessful as MutableLiveData
        isFetchSuccessful.value = true

        disposable.add(
            repository.getSongs(title).subscribeOn(Schedulers.io()).observeOn(
                AndroidSchedulers.mainThread()
            ).subscribeWith(object : DisposableSingleObserver<List<Song>>() {
                override fun onSuccess(t: List<Song>) {
                    songs as MutableLiveData
                    songs.value = t
                    isLoading.value = false
                }

                override fun onError(e: Throwable) {
                    isFetchSuccessful.value = false
                    isLoading.value = false
                }
            })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
