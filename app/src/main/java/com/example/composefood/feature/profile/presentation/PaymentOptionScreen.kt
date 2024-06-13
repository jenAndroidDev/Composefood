package com.example.composefood.feature.profile.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composefood.R
import com.example.composefood.commons.MediumHeightText
import com.example.composefood.ui.theme.PaleGrey
import androidx.compose.ui.unit.dp

@Composable
fun PaymentOptionScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize()) {
        Spacer(modifier = modifier.height(12.dp))
        Column(modifier = modifier
            .fillMaxWidth()
            .background(color = PaleGrey)) {
            MediumHeightText(text = "My Cards")
            DebitCard()
        }
    }

}

@Preview
@Composable
private fun DebitCard(modifier: Modifier = Modifier){
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(id = R.drawable.image_debit_card2),
        contentDescription = "debit card"
    )
}

@Preview
@Composable
fun PreviewPaymentOptionScreen(){

    PaymentOptionScreen()
}