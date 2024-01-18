package com.example.composefood.feature.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class HomeScreenViewModel:ViewModel() {


    val filterFoodsState:StateFlow<FilterFoodState> =
        getFilterFoodCategoryStream()
            .map(FilterFoodState::Success)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = FilterFoodState.Loading
            )






    private fun getFilterFoodCategoryStream():Flow<List<FilterFoodCategory>> = flow {


        val dataList = arrayListOf(
            FilterFoodCategory(1,"vegetable",1,false),
            FilterFoodCategory(2,"Meat",3,false),
            FilterFoodCategory(3,"Dairy",4,false),
            FilterFoodCategory(4,"Nuts and Spices",7,false)
        )

        emit(dataList)
    }



}

sealed interface FilterFoodState{

    data class Success(val data:List<FilterFoodCategory>):FilterFoodState

    object Loading:FilterFoodState
}

sealed interface RecommendedFoodState{

    data class Success(val data:List<RecommendedFoods>):RecommendedFoodState

    object Loading:RecommendedFoodState
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