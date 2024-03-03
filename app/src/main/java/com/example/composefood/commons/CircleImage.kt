package com.example.composefood.commons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
    imageHeight:Dp = 70.dp,
    imageSize:Dp = 70.dp
    ) {
    Box(
        modifier = modifier
            .size(50.dp)
            .background(Color.Transparent),
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(70.dp)
                .align(alignment = Alignment.TopCenter)
                .offset(y= (-30).dp)
                .clip(CircleShape)

        )
    }
}

@Composable
fun RoundedCornerAvatar(
    modifier: Modifier = Modifier
){



}