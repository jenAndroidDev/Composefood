package com.example.composefood.feature.cart.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composefood.R
import com.example.composefood.commons.CounterButton
import com.example.composefood.commons.CurrencyText
import com.example.composefood.components.HeaderBackIcon
import com.example.composefood.commons.MediumHeightText
import com.example.composefood.components.ProfileIcon
import com.example.composefood.commons.SubTitleText
import com.example.composefood.ui.theme.GREY_10

@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    onClick:()->Unit
){
    Surface(modifier = modifier
        .fillMaxSize()
    ) {
        Column(modifier = modifier.background(
            color = GREY_10
        )) {
            Header(modifier = modifier)
            Spacer(modifier = modifier.height(16.dp))
            OrdersFeed(modifier = modifier)
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
        MediumHeightText(text = "Your Orders")
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
        .wrapContentHeight()){
        Card(
            modifier = modifier
                .fillMaxWidth(0.85f)
                .height(120.dp)
                .align(Alignment.CenterEnd)
                .padding(end = 24.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(
                topStart = 50.dp,
                bottomStart = 50.dp,
                topEnd = 10.dp,
                bottomEnd = 10.dp
            ),

            ) {
            Column (
                modifier = modifier.padding(start = 90.dp, top = 16.dp,
                    end = 16.dp)){
                MediumHeightText(text = data.name)
                Spacer(modifier = modifier.height(6.dp))
                SubTitleText(text = data.description)
                Spacer(modifier = modifier.height(26.dp))
                Row(
                    modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(40.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                    CurrencyText(price = data.price.toFloat())
                    CounterButton()

                }
                Spacer(modifier = modifier.height(6.dp))
            }
        }
        CircleMenuItem(
            modifier = modifier
                .align(Alignment.CenterStart)
                .padding(start = 30.dp),
            image = data.image

        )
    }
}

@Composable
fun OrdersFeed(viewModel: CartViewModel = hiltViewModel(),
               modifier: Modifier){

    val data = viewModel.uiState.collectAsStateWithLifecycle()

    val list = data.value.data
    OrdersList(data = list, modifier = modifier)
}

@Composable
fun OrdersList(data:SnapshotStateList<UiModel>,modifier: Modifier){

    LazyColumn(modifier = modifier
        .systemBarsPadding()
        .fillMaxSize(),
        ){
        
        items(data.size){

            OrderedItem(data = data[it])
            Spacer(modifier = modifier.height(12.dp))
        }

    }

}

@Preview
@Composable
fun CircleMenuItem(modifier: Modifier=Modifier,
                   image: Int = R.drawable.sample_circle2){
    Box(modifier = modifier
        .height(120.dp)
        .width(120.dp)
        ){
        Image(
            painter = painterResource(id = image),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )
    }
}
@Preview
@Composable
fun PreviewFoodOrdersScreen(){
    CartScreen {
    }
}