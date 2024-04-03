package com.example.composefood.feature.cart.presentation

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composefood.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val Tag = "CartViewModel"
class CartViewModel:ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()
    init {
        getUiModels()
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
            UiModel(1, R.drawable.sample_circle2,"Italian Coffee","Hot Special Coffee ",
                "10"),
            UiModel(2, R.drawable.sample_circle2,"Italian Coffee","Hot Special Coffee ",
                "10"),
            UiModel(3, R.drawable.sample_circle2,"Italian Coffee","Hot Special Coffee ",
                "10"),
            UiModel(4, R.drawable.sample_circle2,"Italian Coffee","Hot Special Coffee ",
                "10"),
            UiModel(5, R.drawable.sample_circle2,"Italian Coffee","Hot Special Coffee ",
                "10"),
            UiModel(6, R.drawable.sample_circle3,"Italian Coffee","Hot Special Coffee ",
                "10"),
            UiModel(7, R.drawable.sample_circle3,"Italian Coffee","Hot Special Coffee ",
                "10"),
            UiModel(8, R.drawable.sample_circle3,"Italian Coffee","Hot Special Coffee ",
                "10"),
            UiModel(9, R.drawable.sample_circle3,"Italian Coffee","Hot Special Coffee ",
                "10"),
            UiModel(10, R.drawable.sample_circle3,"Italian Coffee","Hot Special Coffee ",
                "10"),

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