package com.example.composefood.feature.detail.presentation


import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composefood.R
import com.example.composefood.commons.CurrencyText
import com.example.composefood.commons.ExpandableText
import com.example.composefood.commons.FoodSubDetail
import com.example.composefood.commons.LargeHeightText
import com.example.composefood.commons.MediumHeightText
import com.example.composefood.components.HeaderBackIcon
import com.example.composefood.ui.theme.PaleWhite
import com.example.composefood.ui.theme.Pink20
import com.example.composefood.ui.theme.fontFamily

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun FoodDetailScreen(
    modifier: Modifier = Modifier,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
    resId: Int,
    itemId: Int,
    onBackClick:()->Unit,
    onClick: () -> Unit
) {
    /*
    TODO Collapsing tool bar layout. and make list scrollable. Ingredients

    * */
    Surface(
        modifier = modifier
            .fillMaxSize()

    ) {
        with(sharedTransitionScope) {
            val scrollState = rememberScrollState()
            Column(
                modifier = modifier
                    .background(color = Color.White)
            ) {
                Header(onClick = onBackClick)
                ContentImage(
                    resId = resId, animatedVisibilityScope = animatedContentScope,
                    itemId = itemId
                )
                Spacer(modifier = modifier.height(24.dp))
                FoodDetailsContent(modifier = modifier)
            }
        }
    }
}
//since this composable is used in many screens move it to components.


@Composable
private fun Header(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {

    Row(
        modifier = modifier
            .background(color = PaleWhite)
            .fillMaxWidth()
            .clickable {
                onClick.invoke()
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = modifier.padding(start = 12.dp, top = 12.dp),
            elevation = CardDefaults.elevatedCardElevation()
        ) {
            HeaderBackIcon(icon = Icons.Default.KeyboardArrowLeft, onClick = onClick)
        }
    }

}

@OptIn(ExperimentalSharedTransitionApi::class)
@Preview
@Composable
private fun SharedTransitionScope.ContentImage(
    modifier: Modifier = Modifier,
    animatedVisibilityScope: AnimatedVisibilityScope,
    resId: Int,
    itemId: Int
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .size(250.dp)
            .background(color = PaleWhite),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.height(12.dp))
        Image(
            painter = painterResource(id = resId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .sharedElement(
                    state = rememberSharedContentState(key = "image/$itemId"),
                    animatedVisibilityScope = animatedVisibilityScope,
                    boundsTransform = { _, _ ->
                        tween(durationMillis = 1000)
                    }
                )
                .size(250.dp)
                .clip(CircleShape)
        )
    }
}

@Preview
@Composable
private fun ContentHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = modifier.width(4.dp))
        LargeHeightText(text = "Spicy Chicken Dimsum", modifier = modifier.fillMaxWidth(0.5f))
        Spacer(modifier = modifier.weight(1f))
        CurrencyText(price = 9.0f, fontSize = 30.sp)
        Spacer(modifier = modifier.width(4.dp))
    }
}

/*
* Poor Naming Conventions*/

@Preview
@Composable
private fun FoodOtherDetails(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        FoodSubDetail(modifier = modifier, text = "2.6", resId = R.drawable.icon_star)
        Spacer(modifier = modifier.weight(1f))
        FoodSubDetail(modifier = modifier, text = "78 calories", resId = R.drawable.flame_icon)
        Spacer(modifier = modifier.weight(1f))
        FoodSubDetail(modifier = modifier, text = "20-30 min", resId = R.drawable.chronometer)
    }
}

@Composable
private fun FoodDetailsContent(modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(start = 12.dp, end = 12.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
    ) {
        ContentHeader()
        Spacer(modifier = modifier.height(24.dp))
        FoodOtherDetails(modifier = modifier)
        Spacer(modifier = modifier.height(24.dp))
        MediumHeightText(text = "Details")
        Spacer(modifier = modifier.height(12.dp))
        ExpandableText(fontFamily = fontFamily, text = stringResource(id = R.string.dummy_text))
        Spacer(modifier = modifier.height(24.dp))
        MediumHeightText(text = "Ingredients")
        IngredientsList(modifier = modifier)
        //MediumHeightText(text = "Ingredients")
    }
}

@Composable
fun IngredientsList(
    modifier: Modifier,
    viewModel: FoodDetailViewModel = hiltViewModel()

) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val ingredientsList = uiState.value.data

    LazyRow(contentPadding = PaddingValues(12.dp)) {

        items(ingredientsList.size) {
            IngredientItem(modifier = modifier, ingredient = ingredientsList[it])
        }
    }
}

@Preview
@Composable
fun IngredientItem(
    modifier: Modifier = Modifier,
    ingredient: Ingredient = Ingredient(R.drawable.cabbage_image, "")
) {
    Column(
        modifier = modifier
            .height(100.dp)
            .width(100.dp)
            .padding(end = 6.dp)
            .background(color = ingredient.color, shape = RoundedCornerShape(12.dp)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = modifier.size(50.dp),
            painter = painterResource(id = ingredient.resId),
            contentDescription = ingredient.name
        )
    }
}
