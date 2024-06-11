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
            UiModel(31, R.drawable.sample_circle,"Italian Coffee","Hot Special Coffee ",
                "10"),
            UiModel(32, R.drawable.sample_circle,"Italian Coffee","Hot Special Coffee ",
                "10"),
            UiModel(33, R.drawable.sample_circle,"Italian Coffee","Hot Special Coffee ",
                "10"),
            UiModel(34, R.drawable.sample_circle,"Italian Coffee","Hot Special Coffee ",
                "10"),
            UiModel(35, R.drawable.sample_circle,"Italian Coffee","Hot Special Coffee ",
                "10"),
            UiModel(36, R.drawable.sample_circle,"Italian Coffee","Hot Special Coffee ",
                "10"),
            UiModel(37, R.drawable.sample_circle,"Italian Coffee","Hot Special Coffee ",
                "10"),
            UiModel(38, R.drawable.sample_circle,"Italian Coffee","Hot Special Coffee ",
                "10"),
            UiModel(39, R.drawable.sample_circle,"Italian Coffee","Hot Special Coffee ",
                "10"),
            UiModel(40, R.drawable.sample_circle,"Italian Coffee","Hot Special Coffee ",
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
sealed class UiAction{
    data class Scroll(val totalItemCount:Int):UiAction()
}