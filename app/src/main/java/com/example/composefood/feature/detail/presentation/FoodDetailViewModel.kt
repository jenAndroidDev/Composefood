package com.example.composefood.feature.detail.presentation

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

private const val Tag = "FoodDetailViewModel"
class FoodDetailViewModel:ViewModel() {

    private val _uiState = MutableStateFlow(FoodDetailUiState())
    val uiState = _uiState.asStateFlow()

    init {

    }



}
data class FoodDetailUiState(
    val data:SnapshotStateList<Ingredient> = SnapshotStateList()
)
data class Ingredient(
    val resId:Int,
    val name:String
)