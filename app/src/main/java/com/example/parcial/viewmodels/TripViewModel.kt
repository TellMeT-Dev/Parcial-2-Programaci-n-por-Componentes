package com.example.parcial.viewmodels

import androidx.lifecycle.ViewModel
import com.example.parcial.data.models.TripModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TripViewModel: ViewModel() {

    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

    private val _model = MutableStateFlow<List<TripModel?>>(emptyList())

    val model: StateFlow<List<TripModel?>> = _model.asStateFlow()

    fun randomCode(): String {
        val chars = alphabet
        return (1..6).map { chars.random() }.joinToString("")
    }

    fun addTrip(trip: TripModel) {
        _model.value = _model.value + trip
    }
}