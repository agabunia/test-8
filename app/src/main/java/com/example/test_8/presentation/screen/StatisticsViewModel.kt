package com.example.test_8.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_8.data.common.Resource
import com.example.test_8.domain.repository.PlacesRepository
import com.example.test_8.presentation.mapper.toPresenter
import com.example.test_8.presentation.state.PlaceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    private val repository: PlacesRepository
) : ViewModel() {

    private val _placeState = MutableStateFlow(PlaceState())
    val placeState: SharedFlow<PlaceState> = _placeState.asStateFlow()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            repository.getPlaces().collect {
                when (it) {
                    is Resource.Success -> _placeState.update { currentState ->
                        currentState.copy(data = it.data.map {
                            it.toPresenter()
                        })
                    }

                    is Resource.Error -> _placeState.update { currentState ->
                        currentState.copy(
                            errorMessage = it.errorMessage
                        )
                    }

                    is Resource.Loading -> _placeState.update { currentState ->
                        currentState.copy(
                            loading = it.loading
                        )
                    }
                }
            }
        }
    }

}
