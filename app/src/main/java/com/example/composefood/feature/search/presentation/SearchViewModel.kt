package com.example.composefood.feature.search.presentation

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composefood.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val Tag = "PremiumFoodViewModel"

class SearchViewModel:ViewModel() {

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
            PremiumFoodModel(21, R.drawable.item_b,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(22, R.drawable.item_b,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(23, R.drawable.sample_circle2,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(24, R.drawable.sample_circle3,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(25, R.drawable.sample_circle2,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(26, R.drawable.sample_circle3,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(27, R.drawable.sample_circle2,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(28, R.drawable.sample_circle2,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(29, R.drawable.sample_circle3,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(30, R.drawable.sample_circle2,"Italian Coffee",
                "Natural Aromatic Coffee","200","20"),
            PremiumFoodModel(31, R.drawable.sample_circle2,"Italian Coffee",
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