package com.example.composefood.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefood.components.LargeHeightText
import com.example.composefood.components.MediumHeightText
import com.example.composefood.ui.theme.GoldenYellow

@Preview
@Composable
fun CounterButton(modifier: Modifier = Modifier){

        Row (modifier = modifier
            .height(60.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(color = GoldenYellow)
            .padding(top = 12.dp, bottom = 12.dp, start = 12.dp,
                end = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            LargeHeightText(text = "-")
            Spacer(modifier = modifier.width(12.dp))
            LargeHeightText(text = "1")
            Spacer(modifier = modifier.width(12.dp))
            LargeHeightText(text = "+")

        }

}