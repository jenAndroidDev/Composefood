package com.example.composefood.feature.home.presentation


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefood.R
import com.example.composefood.components.FoodDetailsText
import com.example.composefood.components.HeaderIcon
import com.example.composefood.components.LargeHeightText
import com.example.composefood.components.MediumHeightText
import com.example.composefood.components.ProfileIcon
import com.example.composefood.components.SubTitleText
import com.example.composefood.ui.theme.GreyWhite


@Preview
@Composable
fun MainScreen(
    onClick:()->Unit = {},

){
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(PaleWhite),
//        contentAlignment = Alignment.Center,
//    ) {
//        Text(
//            modifier = Modifier.clickable { onClick() },
//            text = "Home Screen",
//            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
//            fontWeight = FontWeight.Bold
//        )
//    }

    Surface(modifier = Modifier.fillMaxSize()) {

        Column (
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.Start

            ){

            HomeHeaderSection()

            HeaderTitle(title = "Lets Eat Quality Food")

            Spacer(modifier = Modifier.height(12.dp))

            SearchFoodSection()






        }

    }
}

@Composable
fun FeedListItem(){


    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(12.dp)
            .background(Color.White),
        colors = CardDefaults.cardColors(containerColor = Color.White)
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

@Preview
@Composable
fun HomeHeaderSection(modifier: Modifier = Modifier){

    Row(modifier = modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {

        HeaderIcon(icon = Icons.Default.Menu)
        ProfileIcon(modifier = modifier)



    }
}

@Preview
@Composable
fun HeaderTitle(
    title:String = "Lets Eat Quality Food",
    ){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp),
        horizontalAlignment = Alignment.Start,
        ) {
        LargeHeightText(text = title)

    }
}

@Composable
fun SearchFoodSection(modifier: Modifier = Modifier){

    Row (
        modifier = modifier.fillMaxWidth(0.6f),
        horizontalArrangement = Arrangement.SpaceBetween){
        SearchFoodTextField()

        Icon(imageVector = Icons.Default.Search, contentDescription =null )

    }
}

@Preview
@Composable
fun SearchFoodTextField(){

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(color = GreyWhite)
            .padding(12.dp)
            .size(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
        ){

        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {

            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = Icons.Default.Search,
                contentDescription = "search",)
            Spacer(modifier = Modifier.width(12.dp))
            SubTitleText(text = "Search")
        }

    }
}