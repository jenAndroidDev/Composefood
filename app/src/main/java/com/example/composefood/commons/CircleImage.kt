package com.example.composefood.commons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composefood.R
import com.example.composefood.ui.theme.GoldenYellow

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
                .offset(y = (-30).dp)
                .clip(CircleShape)

        )
    }
}

@Preview
@Composable
fun RoundedCornerAvatar(
    modifier: Modifier = Modifier
){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.item_b),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .border(6.dp, Color.Magenta, CircleShape)
                .shadow(
                    elevation = 24.dp,
                    shape = CircleShape,
                    ambientColor = Color.White,
                    spotColor = Color.Black
                )
                .size(128.dp)
        )

    }
}

@Preview
@Composable
private fun ShadowSample2(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Clipping with Shadow")
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .shadow(
                    elevation = 10.dp,
                    RoundedCornerShape(8.dp)
                )
                .border(1.dp, Color.Green)
                .background(Color.White)
                .size(100.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Hello World")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier

                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(8.dp)
                )
                .clip(RoundedCornerShape(8.dp))
                .border(1.dp, Color.Green)
                .background(Color.White)
                .size(100.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Hello World")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .border(1.dp, Color.Green)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(8.dp)
                )
                .background(Color.White)
                .size(100.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Hello World")
        }
    }

    Column(
        modifier = Modifier
            .width(120.dp)
            .height(120.dp)
            .background(GoldenYellow.copy()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(8.dp),
                    ambientColor = Color.Green,
                    spotColor = Color.Cyan
                )
                .background(Color.White)
                .size(110.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Hello World")
        }
    }
}

@Preview
@Composable
fun CircleImageWithShadow(){

    Column(modifier = Modifier
        .width(120.dp)
        .height(120.dp)
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {

        Image(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.White)
                .size(100.dp),
            painter = painterResource(id = R.drawable.item_b),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}


@Composable
fun CircleAvatarWithShadow(
    modifier: Modifier = Modifier,
    itemImage: Int
){


    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(top = 12.dp)) {
        Image(
            painter = painterResource(id = itemImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .shadow(
                    shape = CircleShape,
                    elevation = 16.dp,
                    ambientColor = GoldenYellow,
                    spotColor = GoldenYellow
                )
                .clip(CircleShape)
        )
    }
}

