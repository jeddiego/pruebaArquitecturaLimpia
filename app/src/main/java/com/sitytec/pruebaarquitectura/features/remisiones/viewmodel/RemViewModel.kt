package com.sitytec.pruebaarquitectura.features.remisiones.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sitytec.pruebaarquitectura.core.IDispatcher
import com.sitytec.pruebaarquitectura.core.Result
import com.sitytec.pruebaarquitectura.features.remisiones.model.RemModel
import com.sitytec.pruebaarquitectura.features.remisiones.model.RemResponse
import com.sitytec.pruebaarquitectura.features.remisiones.usecase.IPostRemUseCase
import com.sitytec.pruebaarquitectura.features.remisiones.usecase.PostRemUseCase
import kotlinx.coroutines.launch

class RemViewModel(private val useCase: IPostRemUseCase, private val iDispatcher: IDispatcher): ViewModel() {
    private val _loadState = MutableLiveData<LoadState>()
    val loadState: LiveData<LoadState> = _loadState

    fun dispatch(action: Actions) {
        when (action) {
            is Actions.DownloadDataAction -> {
                _loadState.postValue(LoadState.Loading)
                viewModelScope.launch(iDispatcher.getIOThread()) {
                    val result = useCase.execute(RemModel(8496, "89027G"))
                    _loadState.postValue(LoadState.LoadRemResult(result))
                }
            }
        }
    }

    sealed class LoadState {
        object Loading: LoadState()
        data class LoadRemResult(val result: Result<RemResponse>): LoadState()
    }

    sealed class Actions {
        object DownloadDataAction : Actions()
    }
}