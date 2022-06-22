package com.example.nn.ui.pages

import androidx.lifecycle.LiveData
import com.example.nn.bean.TaskBean
import com.example.nn.bean.UserPoint
import com.example.nn.view_models.PrizeViewModel

class PrizeScreenElementState(vm: PrizeViewModel) {
    val userPointState: LiveData<PrizeScreenUserPointState> = vm.userPointState
    val allTasksState: LiveData<PrizeScreenAllTasksState> = vm.allTasksState
}

sealed class PrizeScreenUserPointState {
    object Loading : PrizeScreenUserPointState()
    object Error : PrizeScreenUserPointState()
    class Loaded(val userPoint: UserPoint) : PrizeScreenUserPointState()
}

sealed class PrizeScreenAllTasksState {
    object Loading : PrizeScreenAllTasksState()
    object Error : PrizeScreenAllTasksState()
    class Loaded(val allTasks: List<TaskBean>) : PrizeScreenAllTasksState()
}