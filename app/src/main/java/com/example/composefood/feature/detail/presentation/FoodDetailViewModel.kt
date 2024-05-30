package com.example.composefood.feature.detail.presentation

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val Tag = "FoodDetailViewModel"
class FoodDetailViewModel:ViewModel() {

    private val _uiState = MutableStateFlow(FoodDetailUiState())
    val uiState = _uiState.asStateFlow()

    init {

    }
    private fun getIngredientsFeed(){
        viewModelScope.launch {

        }
    }



}
data class FoodDetailUiState(
    val data:List<Ingredient> = listOf()
)
data class Ingredient(
    val resId:Int,
    val name:String
)