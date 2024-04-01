package com.example.composefood.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefood.commons.CircleAvatarWithShadow
import com.example.composefood.feature.home.presentation.CaloriesDetails
import com.example.composefood.feature.home.presentation.PriceDetails

@Preview
@Composable
fun FoodDetailCard(
    modifier: Modifier = Modifier,
    itemImage:Int=0,
    name:String="",
    description:String="",
    price:String="",
    calories:String=""


){
    Column(modifier = modifier
        .width(180.dp)
        .wrapContentHeight()
        .background(
            shape = RoundedCornerShape(18.dp),
            color = Color.White
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircleAvatarWithShadow(modifier = modifier,itemImage)
        Row(modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Column(modifier = modifier.padding(top = 20.dp,
                bottom = 20.dp
            ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                MediumHeightText(text = name)
                Spacer(modifier =modifier.height(4.dp) )
                SubTitleText(text = description)
                Spacer(modifier =modifier.height(8.dp) )
                CaloriesDetails(modifier = modifier)
                Spacer(modifier =modifier.height(4.dp) )
                PriceDetails(modifier)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}