package com.example.composefood.feature.profile.presentation.paymentoption

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.viewModelScope
import com.example.composefood.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

private const val Tag = "PaymentOptionViewModel"
class PaymentOptionViewModel:ViewModel() {

    private val _uiState = MutableStateFlow(PaymentOptionUiState())
    val uiState = _uiState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = PaymentOptionUiState()
    )

    init {
        getPaymentOptions()
    }
    private fun getPaymentOptions(){

        val list = arrayListOf(
            PaymentOptions(1,R.drawable.icon_google_pay,"Google Pay"),
            PaymentOptions(2,R.drawable.icon_phone_pe,"Phone Pe"),
            )
        val tempList = uiState.value.data.toMutableList()
        tempList.addAll(
            list
        )
        _uiState.update {
            it.copy(
                data = tempList.toMutableStateList()
            )
        }
    }

}
data class PaymentOptionUiState(
    val data:SnapshotStateList<PaymentOptions> = SnapshotStateList(),

)
data class PaymentOptions(
    val id:Int = 0,
    val paymentIcon:Int = R.drawable.icon_phone_pe,
    val paymentOption:String="Phone Pe",
    val isSelected:Boolean = false
)