package com.example.composefood.commons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composefood.R

@Preview
@Composable
fun CircleImage(
    modifier: Modifier = Modifier,
    image: Int = R.drawable.item_b,
    imageWidth:Dp = 70.dp,
    imageHeight:Dp = 70.dp
    ) {
    Box(
        modifier = modifier
            .height(imageWidth)
            .width(imageHeight)
            .background(Color.White, shape = RoundedCornerShape(200.dp)),
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
        )
    }
}