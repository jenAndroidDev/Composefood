package com.example.composefood.feature.foodersHub.presentation

import android.graphics.drawable.shapes.RoundRectShape
import android.preference.PreferenceActivity.Header
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composefood.R
import com.example.composefood.commons.CircleImage
import com.example.composefood.commons.CounterButton
import com.example.composefood.commons.HeaderSpacing
import com.example.composefood.components.CurrencyText
import com.example.composefood.components.HeaderBackIcon
import com.example.composefood.components.LargeHeightText
import com.example.composefood.components.MediumHeightText
import com.example.composefood.components.ProfileIcon
import com.example.composefood.components.SubTitleText
import com.example.composefood.ui.theme.GREY_10
import com.example.composefood.ui.theme.GoldenYellow
import com.example.composefood.ui.theme.InkBlack

@Composable
fun OrderScreen(
    modifier: Modifier = Modifier,
    onClick:()->Unit
){
    Surface(modifier = modifier
        .fillMaxSize()
    ) {
        Column(modifier = modifier.background(
            color = GREY_10
        )) {
            HeaderSpacing(modifier = modifier)
            Header(modifier = modifier)
            OrdersFeed()
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
        MediumHeightText(text = "Card Food")
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


@Composable
fun OrderedItem(modifier: Modifier = Modifier,data:UiModel){

    Box(modifier = modifier
        .fillMaxWidth()
        .height(140.dp)){
        Card(
            modifier = modifier
                .fillMaxWidth(0.85f)
                .height(120.dp)
                .align(Alignment.CenterEnd),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(
                topStart = 40.dp,
                bottomStart = 40.dp,
                topEnd = 10.dp,
                bottomEnd = 10.dp
            ),

            ) {
            Column (
                modifier = modifier.padding(start = 70.dp, top = 16.dp)){
                MediumHeightText(text = data.name)
                Spacer(modifier = modifier.height(6.dp))
                SubTitleText(text = data.description)
                Spacer(modifier = modifier.height(26.dp))
                Row(horizontalArrangement = Arrangement.End) {
                    CurrencyText(price = data.price.toFloat())
                }
            }
        }
        CircleMenuItem(
            modifier = modifier.align(Alignment.CenterStart)
                .padding(start = 24.dp),
            image = data.image

        )
    }
}

@Composable
fun OrdersFeed(viewModel: FoodersHubViewModel = hiltViewModel()){

    val data = viewModel.uiState.collectAsStateWithLifecycle()

    val list = data.value.data
    OrdersList(data = list)
}

@Composable
fun OrdersList(data:SnapshotStateList<UiModel>){

    LazyColumn(modifier = Modifier
        .systemBarsPadding()
        .fillMaxSize(),
        ){
        
        items(data.size){
            OrderedItem(data = data[it])
        }

    }

}

@Preview
@Composable
fun CircleMenuItem(modifier: Modifier=Modifier,
                   image: Int = R.drawable.sample_circle2){
    Box(modifier = modifier
        .height(100.dp)
        .width(100.dp)
        ){
        Image(
            painter = painterResource(id = image),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .shadow(
                    elevation = 12.dp,
                    RoundedCornerShape(80.dp),
                    ambientColor = Color.Black,
                    spotColor = Color.Black

                )
                .clip(CircleShape)
                .border(1.dp, Color.DarkGray, RoundedCornerShape(200.dp))

        )
    }
}



@Preview
@Composable
fun PreviewFoodOrdersScreen(){

    OrderScreen {
    }
}