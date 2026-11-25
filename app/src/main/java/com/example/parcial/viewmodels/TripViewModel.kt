package com.example.parcial.viewmodels

import androidx.lifecycle.ViewModel
import com.example.parcial.data.models.TripModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TripViewModel: ViewModel() {

    private val _model = MutableStateFlow<List<TripModel?>>(emptyList())

    val model: StateFlow<List<TripModel?>> = _model.asStateFlow()

}