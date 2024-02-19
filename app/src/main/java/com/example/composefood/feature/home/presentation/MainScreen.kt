package com.example.composefood.feature.home.presentation


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composefood.R
import com.example.composefood.commons.recomposeHighlighter
import com.example.composefood.components.CurrencyText
import com.example.composefood.components.FoodDetailsText
import com.example.composefood.components.HeaderIcon
import com.example.composefood.components.LargeHeightText
import com.example.composefood.components.MediumHeightText
import com.example.composefood.components.ProfileIcon
import com.example.composefood.components.SubTitleText
import com.example.composefood.ui.theme.GoldenYellow
import com.example.composefood.ui.theme.GreyWhite

/*
* 1.Scroll the Entire Screen With Collapsing Mode
* 2.Bottom Navigation Font Style
* 3.
* */

@Preview
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onClick:()->Unit = {},
    ){
    Surface(modifier = modifier
        .fillMaxSize()
        .background(color = Color.Black),
        ) {
        Column (
            modifier = modifier
                .background(color = GoldenYellow.copy(alpha = 0.1f)),
            horizontalAlignment = Alignment.Start,
            ){
            Spacer(modifier = modifier.height(30.dp) )
            HomeHeaderSection(modifier)
            Spacer(modifier = modifier.height(8.dp))
            HeaderTitle(title = "Lets Eat Quality Food",modifier)
            Spacer(modifier = modifier.height(16.dp))
            SearchFoodSection(modifier)
            Spacer(modifier = modifier.height(4.dp))
            FoodCategoryList(modifier = modifier)

        }
    }
}
@Composable
fun HomeHeaderSection(modifier: Modifier){
    Row(modifier = modifier
        .fillMaxWidth()
        .padding(start = 12.dp, end = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {

        Card(elevation = CardDefaults.elevatedCardElevation()) {
            HeaderIcon(icon = Icons.Default.Menu)
        }
        ProfileIcon(modifier = modifier)
    }
}


@Composable
fun HeaderTitle(
    title:String = "Let's Eat \n " +
            "Quality Food 😀 ",
    modifier: Modifier
    ){
    Column(
        modifier = modifier
            .fillMaxWidth(0.5f)
            .padding(start = 18.dp),
        horizontalAlignment = Alignment.Start,
        ) {
        LargeHeightText(text = title)

    }
}

@Composable
fun SearchFoodSection(modifier: Modifier){

    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween){

        SearchFoodTextField()

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .clip(RoundedCornerShape(6.dp))
                .background(color = GoldenYellow)
                .size(50.dp)) {
            Icon(imageVector = Icons.Default.Search, contentDescription =null )
        }
    }
}


@Composable
fun SearchFoodTextField(){
    Column (
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .clip(RoundedCornerShape(12.dp))
            .background(color = GreyWhite.copy(alpha = 0.2f))
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

            Text(text = "Search...")
        }
    }
}


@Composable
fun FilterFoods(modifier: Modifier = Modifier, data:FilterFoodCategory, onClick: (Int) -> Unit){

    val isToggled by rememberUpdatedState(newValue = data.isSelected)

    Row(modifier = modifier
        .clip(RoundedCornerShape(12.dp))
        .background(color = if (isToggled) GoldenYellow else Color.White)
        .height(40.dp)
        .padding(12.dp)
        .clickable {
            onClick.invoke(data.id)
        }
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        Text(text = data.title, textAlign = TextAlign.Center,
            fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}
@Composable
fun FoodCategoryList(viewModel: HomeScreenViewModel = hiltViewModel(),modifier: Modifier){
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val data = uiState.value.data
    val trendingFeed = uiState.value.trendingData
    val onClick = remember {
        { index: Int ->
            viewModel.toggleFilterSelection(index)
        }
    }
    Column {
        LazyRow(contentPadding = PaddingValues(16.dp)){
            items(
                data.size,
            ){
                FilterFoods(data = data[it], onClick = onClick, modifier = Modifier.recomposeHighlighter())
                Spacer(modifier = Modifier.padding(12.dp))
            }
        }
        TrendingFeed(data = trendingFeed, modifier =modifier)
    }
}

@Composable
fun TrendingFeed(data:SnapshotStateList<TrendingFoods>,modifier: Modifier){
    LazyRow(contentPadding = PaddingValues(2.dp)){
        items(
            data.size,
        ){
            Spacer(modifier = Modifier.padding(4.dp))
            CardWithOffsetImage(modifier)
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview
@Composable
fun CardWithOffsetImage(
    modifier: Modifier = Modifier,
    cardWidth:Dp = 80.dp,
    shape:Shape = RoundedCornerShape(12.dp),
    imageSize:Dp = 100.dp,
    offsetImage:Int = R.drawable.sample_circle3,
    ){
    Box (modifier = modifier
        .width(150.dp)
        .wrapContentHeight()
        .padding(top = 36.dp)
        .background(shape = shape, color = Color.White)
        ){
        Image(
            painter = painterResource(id = offsetImage),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(imageSize)
                .align(alignment = Alignment.TopCenter)
                .offset(y = (-25).dp)
                .clip(CircleShape)


        )
        Row(modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Column(modifier = modifier.padding(top = (imageSize-20.dp),
                 ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                MediumHeightText(text = "Italian Coffee")
                Spacer(modifier =modifier.height(4.dp) )
                SubTitleText(text = "Best Aroma Coffee")
                Spacer(modifier =modifier.height(8.dp) )
                CaloriesDetails(modifier = modifier)
                Spacer(modifier =modifier.height(4.dp) )
                PriceDetails(modifier)
            }
        }
    }
}

@Composable
fun CaloriesDetails(modifier:Modifier){
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start){
        Image(painter = painterResource(id = R.drawable.flame_icon), contentDescription = null,
            modifier = modifier.size(18.dp))
        Spacer(modifier = modifier.width(2.dp))
        FoodDetailsText()
    }
}
@Composable
fun PriceDetails(modifier: Modifier){
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start){
        CurrencyText(modifier = modifier)
    }
}



