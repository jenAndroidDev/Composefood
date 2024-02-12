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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
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

@Preview
@Composable
fun MainScreen(
    onClick:()->Unit = {},
    ){
    Surface(modifier = Modifier.fillMaxSize()) {
        Column (
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.Start,
            ){
            Spacer(modifier = Modifier.height(30.dp) )
            HomeHeaderSection()
            Spacer(modifier = Modifier.height(12.dp))
            HeaderTitle(title = "Lets Eat Quality Food")
            Spacer(modifier = Modifier.height(16.dp))
            SearchFoodSection()
            Spacer(modifier = Modifier.height(16.dp))
            FoodCategoryList()
            RecommendedFoodsLazyRow()
        }
    }
}
@Composable
fun HomeHeaderSection(modifier: Modifier = Modifier){

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
    ){

    Column(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(start = 18.dp),
        horizontalAlignment = Alignment.Start,
        ) {
        LargeHeightText(text = title)

    }
}

@Composable
fun SearchFoodSection(modifier: Modifier = Modifier){

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
fun FoodCategoryList(viewModel: HomeScreenViewModel = hiltViewModel()){
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val data = uiState.value.data
    val onClick = remember {
        { index: Int ->
            viewModel.toggleFilterSelection(index)
        }
    }
    LazyRow(contentPadding = PaddingValues(16.dp)){
        items(
            data.size,
            ){
            FilterFoods(data = data[it], onClick = onClick, modifier = Modifier.recomposeHighlighter())
            Spacer(modifier = Modifier.padding(12.dp))
        }
    }
}
@Composable
fun RecommendedFoodsLazyRow(){

    val list = arrayListOf(
        FoodCategoryItem(1,"Vegetable"),
        FoodCategoryItem(2,"Fruit"),
        FoodCategoryItem(3,"Meat"),
        FoodCategoryItem(4,"Dairy"),
        FoodCategoryItem(5,"Spices")
    )

   LazyRow(contentPadding = PaddingValues(16.dp)){

       items(list.size){
           RecommendedFoodItem()
           Spacer(modifier = Modifier.padding(12.dp))

       }
   }

}

@Deprecated("Refer Offset Image View")
@Preview
@Composable
fun RecommendedFoodItem(modifier: Modifier = Modifier){

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(200.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.White)
    ) {

        Image(
            painter = painterResource(id = R.drawable.image_sample),
            contentDescription =null,
            modifier = modifier
                .clip(CircleShape)
                .size(100.dp),
            contentScale = ContentScale.Crop

            )

        Spacer(modifier = modifier.height(12.dp))

        MediumHeightText()

        Spacer(modifier = modifier.height(12.dp))

        SubTitleText()

        Spacer(modifier = modifier.height(12.dp))

        Row (modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically){

            Image(painter = painterResource(id = R.drawable.flame_icon),
                contentDescription = null, modifier = modifier.size(18.dp))

            FoodDetailsText(text = "78 Calories")
        }

        Spacer(modifier = modifier.height(12.dp))

        CurrencyText()
    }
}


@Preview
@Composable
fun CardWithOffsetImage(
    cardHeight: Dp = 300.dp,
    cardWidth:Dp = 60.dp,
    shape:Shape = RoundedCornerShape(12.dp),
    imageSize:Dp = 100.dp,
    offsetImage:Int = R.drawable.item_b,
    contentDescription:String = "",
    alignment: Alignment = Alignment.Center,
    modifier: Modifier = Modifier
    ){
    Box (modifier = modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(cardWidth)
        .background(shape = shape, color = Color.White),
        ){
        Image(
            painter = painterResource(id = offsetImage),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(imageSize)
                .align(alignment = Alignment.TopCenter)
                .offset(y = (-30).dp)
                .clip(CircleShape)

        )
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Column(modifier = Modifier.padding(top = (imageSize-20.dp),
                 ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                MediumHeightText(text = "Italian Coffee")
                Spacer(modifier =modifier.height(8.dp) )
                SubTitleText(text = "Best Aroma Coffee")
                Spacer(modifier =modifier.height(8.dp) )
                FoodDetailsText()
                Spacer(modifier =modifier.height(16.dp) )
                CurrencyText()

            }
        }


    }

}



data class FoodCategoryItem(
    val id:Int,
    val name:String
)


