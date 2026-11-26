package com.example.parcial.viewmodels

import androidx.lifecycle.ViewModel
import com.example.parcial.data.models.PlacesModel
import com.example.parcial.data.models.TripModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PlacesViewModel: ViewModel() {

    private val _model = MutableStateFlow<List<PlacesModel?>>(emptyList())

    val model: StateFlow<List<PlacesModel?>> = _model.asStateFlow()
}