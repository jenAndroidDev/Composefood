package com.example.composefood.feature.premium.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefood.commons.HeaderSpacing
import com.example.composefood.components.HeaderIcon
import com.example.composefood.components.ProfileIcon
import com.example.composefood.ui.theme.GoldenYellow


@Composable
fun PremiumScreen(
    modifier: Modifier = Modifier,
    onClick:()->Unit
){

    Surface(modifier = modifier.fillMaxSize()) {
        Column(modifier = modifier
            .background(color = GoldenYellow.copy(alpha = 0.1f))) {
            HeaderSpacing(modifier = modifier)
            PremiumHeaderSection(modifier = modifier)
        }
    }

}
@Composable
private fun PremiumHeaderSection(modifier: Modifier){
    Row (modifier = modifier
        .fillMaxWidth()
        .padding()){
        Row(
            modifier = Modifier
                .weight(1f),
            horizontalArrangement = Arrangement.Absolute.Left
        ) {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Previous"
                )
            }

            IconButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Next"
                )
            }
        }


        // Center element
        Button(
            onClick = { }
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Play"
            )
        }

        // Right element
        Box(
            modifier = Modifier
                .weight(1f),
            contentAlignment = Alignment.CenterEnd
        ){
            IconButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Restart"
                )
            }
        }
    }


    }


@Preview
@Composable
fun PreviewPremiumFoodScreen(){
    PremiumScreen {

    }
}