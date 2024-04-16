package com.example.composefood.feature.profile.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefood.commons.MediumHeightText
import com.example.composefood.components.HeaderBackIcon
import com.example.composefood.components.ProfileIcon
import com.example.composefood.feature.cart.presentation.OrdersFeed
import com.example.composefood.ui.theme.GREY_10

@Composable
fun ProfileScreen(modifier: Modifier = Modifier){
    Surface(modifier = Modifier
        .fillMaxSize()) {

        Column(modifier = modifier.background(color = GREY_10)) {
            Header(modifier = modifier)
            Spacer(modifier = modifier.height(16.dp))
        }

    }
}

@Composable
private fun Header(modifier: Modifier){
    Row (modifier = modifier
        .background(color = Color.White, shape = RoundedCornerShape(12.dp))
        .fillMaxWidth()
        .height(120.dp)
        .padding(),
        verticalAlignment = Alignment.CenterVertically,){
        Row(
            modifier = Modifier
                .weight(1f),
            horizontalArrangement = Arrangement.Absolute.Left
        ) {

            HeaderBackIcon(modifier = modifier.padding(start = 12.dp),
                icon = Icons.Default.KeyboardArrowLeft)

        }
        MediumHeightText(text = "Your Profile")
        Box(
            modifier = modifier
                .weight(1f)
                .padding(end = 12.dp),
            contentAlignment = Alignment.CenterEnd
        ){
            ProfileIcon(modifier = modifier,
                imageVector = Icons.Default.Person,
                size = 40.dp)
        }
    }
}

@Preview
@Composable
fun PreviewProfileScreen(){
    ProfileScreen()
}