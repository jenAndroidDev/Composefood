package com.example.composefood.feature.home.presentation

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefood.R
import com.example.composefood.components.FoodDetailsText
import com.example.composefood.components.MediumHeightText
import com.example.composefood.components.SubTitleText
import com.example.composefood.ui.theme.PaleWhite


@Composable
fun MainScreen(
    onClick:()->Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PaleWhite),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            modifier = Modifier.clickable { onClick() },
            text = "Home Screen",
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun FeedListItem(){


    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(12.dp)
            .background(Color.White),
        ) {

        Column(
            modifier = Modifier
                .size(250.dp)
                .padding(top = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {

            Image(
                painter = painterResource(id = R.drawable.image_sample),
                contentDescription = "",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(100.dp))
            MediumHeightText(text = "HamBurger")
            SubTitleText(text = "Barbeque Chicken Burger")
            FoodDetailsText(text="78 Calories")

        }
    }
}