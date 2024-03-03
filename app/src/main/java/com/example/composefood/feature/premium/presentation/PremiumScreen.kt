package com.example.composefood.feature.premium.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefood.commons.HeaderSpacing
import com.example.composefood.components.HeaderBackIcon
import com.example.composefood.components.MediumHeightText
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
        .padding(),
        verticalAlignment = Alignment.CenterVertically){
        Row(
            modifier = Modifier
                .weight(1f),
            horizontalArrangement = Arrangement.Absolute.Left
        ) {

           HeaderBackIcon(modifier = modifier.padding(start = 12.dp),
               icon = Icons.Default.KeyboardArrowLeft)

        }
        MediumHeightText(text = "Search Food")
        Box(
            modifier = modifier
                .weight(1f)
                .padding(end = 12.dp),
            contentAlignment = Alignment.CenterEnd
        ){
            ProfileIcon(modifier = modifier,
                imageVector = Icons.Default.Search)
        }
    }

}


@Preview
@Composable
fun PreviewPremiumFoodScreen(){
    PremiumScreen {

    }
}