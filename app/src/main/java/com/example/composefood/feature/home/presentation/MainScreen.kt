package com.example.composefood.feature.home.presentation


import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
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
import com.example.composefood.commons.CurrencyText
import com.example.composefood.components.FoodDetailCard
import com.example.composefood.commons.FoodDetailsText
import com.example.composefood.components.HeaderBackIcon
import com.example.composefood.commons.LargeHeightText
import com.example.composefood.commons.MediumHeightText
import com.example.composefood.components.ProfileIcon
import com.example.composefood.commons.SubTitleText
import com.example.composefood.components.CircleButtonShadowed
import com.example.composefood.ui.theme.GREY_10
import com.example.composefood.ui.theme.GoldenYellow
import com.example.composefood.ui.theme.GreyWhite

/*
* 1.Scroll the Entire Screen With Collapsing Mode
* 2.Bottom Navigation Font Style==Done
* 3.Filter with Dummy Feed
* 4.Use Scaffold for header
* */
private const val Tag = "MainScreen"
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.MainScreen(
    modifier: Modifier = Modifier,
    animatedVisibilityScope: AnimatedContentScope,
    sharedTransitionScope: SharedTransitionScope,
    onProfileClick:()->Unit,
    onSearchClick:()->Unit,
    onClick:(Int,Int)->Unit = { i: Int, i1: Int -> },
    ){
    Surface(modifier = modifier
        .fillMaxSize(),
        ) {
        Column (
            modifier = modifier
                .background(color = GREY_10),
            horizontalAlignment = Alignment.Start,
            ){
            Spacer(modifier = modifier.height(30.dp) )
            HomeHeaderSection(modifier,onProfileClick)
            Spacer(modifier = modifier.height(16.dp))
            HeaderTitle(title = "Lets Eat Quality Food 😋",modifier)
            Spacer(modifier = modifier.height(24.dp))
            SearchFoodSection(modifier,onSearchClick)
            Spacer(modifier = modifier.height(16.dp))
            FoodCategoryList(
                modifier = modifier,
                animatedVisibilityScope = animatedVisibilityScope,
                sharedTransitionScope = sharedTransitionScope,
                onItemClicked = onClick)
        }
    }
}
@Composable
fun HomeHeaderSection(modifier: Modifier, onProfileClick: () -> Unit){
    Row(modifier = modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Card(elevation = CardDefaults.elevatedCardElevation()) {
            HeaderBackIcon(icon = Icons.Default.Menu)
        }
        ProfileIcon(modifier = modifier, onClick = onProfileClick)
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
            .fillMaxWidth(0.7f)
            .padding(start = 18.dp),
        horizontalAlignment = Alignment.Start,
        ) {
        LargeHeightText(text = title)

    }
}

@Composable
fun SearchFoodSection(modifier: Modifier, onSearchClick: () -> Unit){

    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        SearchFoodTextField()
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .clip(RoundedCornerShape(6.dp))
                .background(color = GoldenYellow)
                .size(50.dp)
                .clickable {
                    onSearchClick.invoke()
                }) {
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
//        .clip(RoundedCornerShape(12.dp))
        .background(color = if (isToggled) GoldenYellow else Color.White, shape = RoundedCornerShape(12.dp))
        .border(border = BorderStroke(width = 1.dp, color = GoldenYellow), shape = RoundedCornerShape(12.dp))
        .wrapContentHeight()
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
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.FoodCategoryList(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    modifier: Modifier,
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionScope: SharedTransitionScope,
    onItemClicked: (Int,Int) -> Unit,

){
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
        TrendingFeed(
            data = trendingFeed,
            modifier =modifier,
            animatedVisibilityScope = animatedVisibilityScope,
            sharedTransitionScope = sharedTransitionScope,
            onClick = onItemClicked)
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun TrendingFeed(
    data: SnapshotStateList<TrendingFoods>,
    modifier: Modifier,
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionScope: SharedTransitionScope,
    onClick: (Int,Int) -> Unit,
    ) {
    val lazyListState = rememberLazyListState()
    LazyRow(contentPadding = PaddingValues(2.dp), state = lazyListState) {
        itemsIndexed(
            data,
        ) {index,it->
            key(data[index].id) {
                Spacer(modifier = Modifier.padding(4.dp))
                FoodDetailCard(
                    modifier = modifier,
                    itemId = it.id,
                    itemImage = it.image,
                    name = it.foodName,
                    description = it.foodDescription,
                    price = it.price,
                    calories = it.calories,
                    animatedVisibilityScope = animatedVisibilityScope,
                    sharedTransitionScope = sharedTransitionScope,
                    onItemClick = onClick
                )
                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun CaloriesDetails(modifier:Modifier,calories:String){
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start){
        Image(painter = painterResource(id = R.drawable.flame_icon), contentDescription = null,
            modifier = modifier.size(18.dp))
        Spacer(modifier = modifier.width(2.dp))
        FoodDetailsText(text = calories)
    }
}
@Composable
fun PriceDetails(modifier: Modifier,price:String){
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start){
        CurrencyText(modifier = modifier)
    }
}



