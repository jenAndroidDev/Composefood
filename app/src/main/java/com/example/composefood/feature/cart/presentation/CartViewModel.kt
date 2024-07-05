package com.example.composefood.feature.cart.presentation

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composefood.R
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

private const val Tag = "CartViewModel"
class CartViewModel:ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    private val scrollState = MutableSharedFlow<UiAction.Scroll>(1)

    val action:(UiAction)->Unit


    init {
        getUiModels()

        action  = {
            onUiAction(it)
        }
    }
    private fun onUiAction(action: UiAction){
        when(action){
            is UiAction.Scroll->{
                viewModelScope.launch { scrollState.emit(action) }
            }
        }
    }
    private fun getUiModels(){

        viewModelScope.launch {
            val tempList = uiState.value.data.toMutableList()
            tempList.addAll(
                getFakeData()
            )
            _uiState.update {
                it.copy(
                    data = tempList.toMutableStateList()
                )
            }
        }

    }

    private fun getFakeData():ArrayList<UiModel>{
        return arrayListOf(
            UiModel(31, R.drawable.sample_circle2,"Green Salad Recipe","Fresh Greens",
                "9.80"),
            UiModel(32, R.drawable.sample_circle3,"Fruits N nuts Platter","Healthy Diet Meal",
                "6.99"),
            UiModel(33, R.drawable.image_sushi,"Rice Bowl Meat","Delicious Meat",
                "8.62"),
            UiModel(34, R.drawable.image_salman,"Egg Salad","Greens and Panneer Platter",
                "15.50"),
            UiModel(35, R.drawable.sample_item4,"Italian Soup","Soup for the soul",
                "12.50"),
            UiModel(36, R.drawable.sample_circle2,"Green Salad Recipe","Fresh Greens",
                "9.80"),
            UiModel(37, R.drawable.sample_circle3,"Fruits N nuts Platter","Healthy Diet Meal",
                "6.99"),
            UiModel(38, R.drawable.image_sushi,"Rice Bowl Meat","Delicious Meat",
                "8.62"),
            UiModel(39, R.drawable.image_salman,"Egg Salad","Greens and Panneer Platter",
                "15.50"),
            UiModel(34, R.drawable.sample_item4,"Italian Soup","Soup for the soul",
                "12.50"),
        )
            )


    }


}
data class UiModel(
    val id:Int = 0,
    val image:Int = 0,
    val name:String = "",
    val description:String = "",
    val price:String =""
)
data class UiState(
    val data:SnapshotStateList<UiModel> = SnapshotStateList(),

)
sealed class UiAction{
    data class Scroll(val totalItemCount:Int):UiAction()
}