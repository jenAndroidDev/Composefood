package com.example.composefood.feature.premium.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composefood.commons.HeaderSpacing
import com.example.composefood.components.FoodDetailCard
import com.example.composefood.components.HeaderBackIcon
import com.example.composefood.components.LargeHeightText
import com.example.composefood.components.MediumHeightText
import com.example.composefood.components.ProfileIcon
import com.example.composefood.feature.home.presentation.CardWithOffsetImage
import com.example.composefood.feature.home.presentation.SearchFoodTextField
import com.example.composefood.ui.theme.GREY_10
import com.example.composefood.ui.theme.GoldenYellow
import dagger.hilt.android.AndroidEntryPoint



@Composable
fun PremiumScreen(
    modifier: Modifier = Modifier,
    onClick:()->Unit
){

    Surface(modifier = modifier.fillMaxSize()) {
        Column(modifier = modifier
            .background(color = GREY_10)) {
            HeaderSpacing(modifier = modifier)
            Header(modifier = modifier)
            Spacer(modifier = Modifier.height(32.dp))
            SearchFood(modifier = modifier)
            Spacer(modifier = modifier.padding(top = 16.dp))
            LargeHeightText(
                modifier = modifier.padding(start = 12.dp),
                text = "Found 80 results"
            )
            SearchFeed(modifier = modifier)
            Spacer(modifier = modifier.height(40.dp))
        }
    }

}
@Composable
private fun Header(modifier: Modifier){
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
                imageVector = Icons.Default.Search,
                size = 40.dp)
        }
    }
}
@Composable
private fun SearchFood(modifier: Modifier){

    Row (modifier = modifier
        .padding(start = 12.dp, end = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)){
        SearchFoodTextField()
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .clip(RoundedCornerShape(6.dp))
                .background(color = GoldenYellow)
                .size(50.dp)) {
            Icon(imageVector = Icons.Default.Menu, contentDescription =null )
        }
    }
}

@Composable
private fun SearchFeed(viewModel: PremiumFoodViewModel = hiltViewModel(),modifier: Modifier){

    val uiState  = viewModel.uiState.collectAsStateWithLifecycle()
    val data = uiState.value.data

    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(start = 12.dp, end = 12.dp,
            bottom = 70.dp)
        ){
        items(data.size){
            Spacer(modifier = Modifier.padding(4.dp))
            FoodDetailCard(
                modifier = modifier,
                name = data[it].foodName,
                description = data[it].foodDescription,
                itemImage = data[it].image,
                price = data[it].price,
                calories = data[it].calories
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}


@Preview
@Composable
fun PreviewPremiumFoodScreen(){
    PremiumScreen {
    }
}