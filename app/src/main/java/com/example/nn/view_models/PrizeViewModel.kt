package com.example.nn.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nn.ui.pages.PrizeScreenAllTasksState
import com.example.nn.ui.pages.PrizeScreenUserPointState
import com.example.nn.use_cases.PrizeUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PrizeViewModel : ViewModel(), KoinComponent {

    private val useCase: PrizeUseCase by inject()

    private val _userPointState: MutableStateFlow<PrizeScreenUserPointState> =
        MutableStateFlow(PrizeScreenUserPointState.Loading)
    val userPointState: Flow<PrizeScreenUserPointState> = _userPointState

    private val _allTasksState: MutableStateFlow<PrizeScreenAllTasksState> =
        MutableStateFlow(PrizeScreenAllTasksState.Loading)
    val allTasksState: Flow<PrizeScreenAllTasksState> = _allTasksState

    init {
        loadUserPoint()
    }

    fun loadUserPoint() {
        viewModelScope.launch {
            // TODO: 2022/7/3 and2long 更换真实用户id
            try {
                val result = useCase.findUserPoint(userId = 34758)
                if (result.success) {
                    _userPointState.emit(PrizeScreenUserPointState.Loaded(result.retData!!))
                } else {
                    _userPointState.emit(PrizeScreenUserPointState.Error)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _userPointState.emit(PrizeScreenUserPointState.Error)
            }
        }
    }
}