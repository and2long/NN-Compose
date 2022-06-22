package com.example.nn.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nn.api.Api
import com.example.nn.ui.pages.PrizeScreenUserPointState
import kotlinx.coroutines.launch


class PrizeViewModel : ViewModel() {

    private val _userPointState: MutableLiveData<PrizeScreenUserPointState> by lazy {
        MutableLiveData<PrizeScreenUserPointState>().also {
            findUserPoint()
        }
    }
    val userPointState: LiveData<PrizeScreenUserPointState> = _userPointState


    private fun findUserPoint() {
        viewModelScope.launch {
            _userPointState.postValue(PrizeScreenUserPointState.Loading)
            val data = Api.getInstance().findUserPoint(userId = 34758)
            if (data.success) {
                _userPointState.postValue(PrizeScreenUserPointState.Loaded(data.retData!!))
            } else {
                _userPointState.postValue(PrizeScreenUserPointState.Error)
            }
        }
    }
}