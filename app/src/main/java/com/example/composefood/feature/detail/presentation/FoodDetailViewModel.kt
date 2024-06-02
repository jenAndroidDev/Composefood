package com.example.composefood.feature.detail.presentation

import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composefood.R
import com.example.composefood.ui.theme.GREEN20
import com.example.composefood.ui.theme.Pink20
import com.example.composefood.ui.theme.Pink40
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val Tag = "FoodDetailViewModel"
class FoodDetailViewModel:ViewModel() {

    private val _uiState = MutableStateFlow(FoodDetailUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getIngredientsFeed()
    }
    private fun getIngredientsFeed(){
        viewModelScope.launch {

            val ingredientsList = arrayListOf(
                Ingredient(R.drawable.radish_image,"pumpkin", color = GREEN20),
                Ingredient(R.drawable.cabbage_image,"pumpkin", color = Pink20),
                Ingredient(R.drawable.casicums_image,"pumpkin", color = GREEN20),
                Ingredient(R.drawable.carrot_image,"pumpkin", color = Pink20)
            )

            val tempList = uiState.value.data.toMutableList()
            tempList.addAll(ingredientsList)
            _uiState.update {
                it.copy(
                    data = tempList
                )
            }
        }
    }
}
data class FoodDetailUiState(
    val data:List<Ingredient> = listOf()
)
data class Ingredient(
    val resId:Int,
    val name:String,
    val color: Color = Pink20
)