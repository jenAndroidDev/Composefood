package com.example.composefood.feature.detail.presentation

import androidx.compose.animation.core.exponentialDecay
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefood.components.HeaderBackIcon
import com.example.composefood.components.ProfileIcon

@Composable
fun FoodDetailScreen(
    modifier: Modifier = Modifier,
    onClick:()->Unit
){
    Surface {
        Column {
            Spacer(modifier = modifier.height(16.dp))
            Header()
        }
    }
}
//since this composable is used in many screens move it to components.
@Preview
@Composable
private fun Header(modifier: Modifier = Modifier){

    Row (modifier = modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically){

        Card (elevation = CardDefaults.elevatedCardElevation()){
            HeaderBackIcon(icon = Icons.Default.KeyboardArrowLeft)
        }
        ProfileIcon(modifier = modifier, imageVector = Icons.Default.FavoriteBorder) }
}

@Preview
@Composable
fun PreviewFoodDetailScreen(){
    FoodDetailScreen {
    }
}