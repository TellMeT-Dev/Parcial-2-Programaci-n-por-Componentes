package com.example.parcial.data.models

data class PlacesModel(
    val tripId: String,
    val name: String,
    val description: String,
    val city: String,
    val categoryId: CategoryModel,
    val tentativeDate: String,
)
