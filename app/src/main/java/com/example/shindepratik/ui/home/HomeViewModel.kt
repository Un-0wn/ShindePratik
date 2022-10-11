package com.example.shindepratik.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.shindepratik.ui.repo.PgRespos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    pagingRepository: PgRespos
) : ViewModel() {

    val user = pagingRepository
        .getUser()
        .cachedIn(viewModelScope)
        .flowOn(Dispatchers.IO)

    val unknown = pagingRepository
        .getUnknown()
        .cachedIn(viewModelScope)
        .flowOn(Dispatchers.IO)


}