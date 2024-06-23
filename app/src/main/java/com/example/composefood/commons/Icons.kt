package com.example.composefood.commons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefood.R
import com.example.composefood.ui.theme.PaleGrey
import com.example.composefood.ui.theme.PaleWhite

@Composable
fun IconPaymentOption(
    modifier: Modifier,
    image:Int,
    ){

    Column(modifier = modifier
        .background(color = Color.White, shape = RoundedCornerShape(16.dp))
        .border(border = BorderStroke(width = 1.dp, color = PaleGrey.copy(alpha = 0.7f)), shape = RoundedCornerShape(12.dp))
        .size(80.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        
        Image(painter = painterResource(id = image), contentDescription = null,
            modifier = modifier.size(40.dp))
    }
}

@Preview
@Composable
fun PreviewPaymentIcon(){

}