package com.example.composefood.feature.profile.presentation.paymentoption

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composefood.R
import com.example.composefood.commons.MediumHeightText
import com.example.composefood.ui.theme.PaleGrey
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composefood.commons.IconPaymentOption
import com.example.composefood.ui.theme.PaleWhite

@Composable
fun PaymentOptionScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize()) {
        Spacer(modifier = modifier.height(12.dp))
        Column(modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)) {
            MyCards()
            AddPaymentCards(modifier = modifier)
        }
    }

}

@Composable
private fun MyCards(modifier: Modifier=Modifier){
    Column(modifier = modifier
        .fillMaxWidth()
        .background(color = PaleWhite)) {
        MediumHeightText(text = "My Cards", modifier = modifier.padding(start = 12.dp))
        DebitCard()
    }
}

@Preview
@Composable
private fun DebitCard(modifier: Modifier = Modifier){
    Image(
        modifier = modifier.wrapContentSize(),
        painter = painterResource(id = R.drawable.image_debit_card2),
        contentDescription = "debit card"
    )
}

@Composable
private fun AddPaymentCards(
    modifier: Modifier,
    viewModel: PaymentOptionViewModel = hiltViewModel()
) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val data = uiState.value.data.toList()

    Column(modifier = modifier.fillMaxWidth()) {
        MediumHeightText(text = "Add New Card", modifier = modifier.padding(start = 12.dp))
        PaymentOptionsList(modifier = modifier, data = data)
    }
}

@Composable
private fun PaymentOptionsList(
    modifier: Modifier,
    data: List<PaymentOptions>
) {

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(data.size) {
            PaymentOption(modifier = modifier, item = data[it])
            Spacer(modifier = modifier.height(12.dp))
        }
    }
}


@Composable
private fun PaymentOption(modifier: Modifier,
                          item:PaymentOptions){

    var checked by remember {
        mutableStateOf(false)
    }
    Row (modifier = modifier
        .fillMaxWidth()
        .wrapContentHeight(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically){

        IconPaymentOption(modifier = modifier,
            image = item.paymentIcon)
        Spacer(modifier = modifier.width(6.dp))
        MediumHeightText(text = item.paymentOption)
        Spacer(modifier = modifier.weight(1f))
        RadioButton(
            selected = checked,
            onClick = {
            checked=!checked
        },
        )
    }
}



@Preview
@Composable
fun PreviewPaymentOptionScreen(){
    PaymentOptionScreen()
}