package com.example.composefood.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefood.ui.theme.GoldenYellow
import com.example.composefood.ui.theme.PaleGrey


@Composable
fun HeaderIcon(
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
fun ProfileIcon(modifier: Modifier){

    Column(modifier = modifier
        .clip(RoundedCornerShape(6.dp))
        .background(GoldenYellow)
        .size(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

//        Icon(imageVector = Icons.Default.Person, contentDescription = null,
//            )


    }
}
