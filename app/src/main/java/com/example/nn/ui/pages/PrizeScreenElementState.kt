package com.example.nn.ui.pages

import androidx.lifecycle.LiveData
import com.example.nn.bean.UserPoint
import com.example.nn.view_models.PrizeViewModel

class PrizeScreenElementState(vm: PrizeViewModel) {
    val userPointState: LiveData<PrizeScreenUserPointState> = vm.userPointState
}

sealed class PrizeScreenUserPointState {
    object Loading : PrizeScreenUserPointState()
    class Loaded(val userPoint: UserPoint) : PrizeScreenUserPointState()
    object Error : PrizeScreenUserPointState()
}