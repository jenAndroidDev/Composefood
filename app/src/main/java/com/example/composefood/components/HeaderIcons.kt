package com.example.composefood.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composefood.ui.theme.GoldenYellow


@Composable
fun HeaderBackIcon(
    modifier: Modifier = Modifier,
    icon: ImageVector
    ){

    Column(modifier = modifier
        .clip(RoundedCornerShape(8.dp))
        .background(Color.White)
        .shadow(6.dp, spotColor = Color.White, ambientColor = Color.Gray.copy(alpha = 0.2f))
        .size(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){

        Icon(imageVector = icon, contentDescription = null)

    }
}

@Composable
fun ProfileIcon(
    modifier: Modifier,
    imageVector:ImageVector = Icons.Default.Person,
    size: Dp = 50.dp,
    onClick:()->Unit = {}
    ){

    Column(modifier = modifier
        .clip(RoundedCornerShape(6.dp))
        .background(GoldenYellow)
        .size(size)
        .clickable {
           onClick.invoke()
        },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        Image(imageVector = imageVector, contentDescription = null)
    }
}

@Preview
@Composable
fun CardDemo(){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Gray),
        verticalArrangement = Arrangement.Center) {

        Box(modifier = Modifier.padding(15.dp),
            contentAlignment = Alignment.TopCenter
        ){

            val textPadding = 15.dp
            val overlapBoxHeight = 20.dp
            Card(elevation = CardDefaults.elevatedCardElevation(),
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(textPadding)
                ) {
                    Text("Card Title")
                    Text("Card Subtitle")
                    Text("Card Content Line 1")
                    Text("Card Content Line 2")
                }
            }

            Box(
                Modifier
                    .height(overlapBoxHeight)
                    .width(40.dp)
                    .offset(x = textPadding, y = -overlapBoxHeight / 2)
                    .background(Color.Red)
            )
        }

    }
}
