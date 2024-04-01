package com.example.composefood.feature.premium.presentation

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composefood.R
import com.example.composefood.feature.home.presentation.TrendingFoods
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val Tag = "PremiumFoodViewModel"

class PremiumFoodViewModel:ViewModel() {

    private val _uiState = MutableStateFlow(PremiumFoodUiState())
    val uiState = _uiState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = PremiumFoodUiState()
    )
    init {

        getPremiumFoodFakeData()
    }
    private fun getPremiumFoodFakeData(){

        viewModelScope.launch {

            val tempList = uiState.value.data
            tempList.addAll(
                getTrendingFoodList().toMutableStateList()
            )
            _uiState.update {
                it.copy(
                    data = tempList
                )
            }
        }
    }

    private fun getTrendingFoodList(): ArrayList<PremiumFoodModel> {

        return arrayListOf(
            PremiumFoodModel(1, R.drawable.item_b,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(2, R.drawable.item_b,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(3, R.drawable.sample_circle2,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(4, R.drawable.sample_circle3,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(5, R.drawable.sample_circle2,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(6, R.drawable.sample_circle3,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(7, R.drawable.sample_circle2,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(8, R.drawable.sample_circle2,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(9, R.drawable.sample_circle3,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(10, R.drawable.sample_circle2,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(11, R.drawable.sample_circle2,"Italian Coffee",
                "Natural Aromatic Coffee","200","20")

        )
    }
}
data class PremiumFoodUiState(
    val data:SnapshotStateList<PremiumFoodModel> = SnapshotStateList()
)
data class PremiumFoodModel(
    val id:Int,
    val image:Int,
    val foodName:String,
    val foodDescription:String,
    val calories:String,
    val price: String
)