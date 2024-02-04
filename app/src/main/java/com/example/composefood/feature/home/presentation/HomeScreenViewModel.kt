package com.example.composefood.feature.home.presentation

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/*
* Revamp this viewmodel w.r.to R J Jenin Joseph R J*/

private const val Tag = "HomeScreenViewModel"
class HomeScreenViewModel:ViewModel() {

    private val _uiState = MutableStateFlow(FilterFoodUiState())

    val uiState = _uiState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = FilterFoodUiState()
    )
    init {
        getFilterFeedState()
    }
    private fun getFilterFeedState(){

        viewModelScope.launch {
            val tempList = uiState.value.data
            tempList.addAll(
                getFilterFoodList().toMutableStateList()
            )
            _uiState.update {
                it.copy(
                    data = tempList
                )
            }
        }
    }
    private fun getFilterFoodList(): ArrayList<FilterFoodCategory> {
        return arrayListOf(
            FilterFoodCategory(1,"vegetable",1,false),
            FilterFoodCategory(2,"Meat",3,false),
            FilterFoodCategory(3,"Dairy",4,false),
            FilterFoodCategory(4,"Nuts and Spices",7,false),
            FilterFoodCategory(5,"Meat",3,false),
            FilterFoodCategory(6,"Dairy",4,false),
            FilterFoodCategory(7,"Nuts and Spices",7,false),
            FilterFoodCategory(8,"Meat",3,false),
            FilterFoodCategory(9,"Dairy",4,false),
            FilterFoodCategory(10,"Nuts and Spices",7,false)

        )
    }
}
sealed interface FilterFoodState{
    data class Success(val data:List<FilterFoodCategory>):FilterFoodState
    data object Loading:FilterFoodState
}data class FilterFoodUiState(
    val data:SnapshotStateList<FilterFoodCategory> = SnapshotStateList()
)
sealed interface RecommendedFoodState{
    data class Success(val data:List<RecommendedFoods>):RecommendedFoodState
    data object Loading:RecommendedFoodState
}
data class FilterFoodCategory(
    val id:Int,
    val title:String,
    val image:Int,
    val isSelected:Boolean
)
data class RecommendedFoods(
    val id: Int,
    val title:String,
    val price:String,
    val calories:String,
    val description:String
)