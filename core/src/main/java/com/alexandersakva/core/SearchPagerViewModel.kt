package com.alexandersakva.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchPagerViewModel : ViewModel() {
    val query: LiveData<String> = MutableLiveData()

    fun search(queryString: String){
        query as MutableLiveData
        query.value = queryString
    }
}
