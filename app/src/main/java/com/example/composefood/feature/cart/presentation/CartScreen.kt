package com.example.composefood.feature.cart.presentation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
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
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composefood.commons.CounterButton
import com.example.composefood.commons.CurrencyText
import com.example.composefood.components.HeaderBackIcon
import com.example.composefood.commons.MediumHeightText
import com.example.composefood.components.ProfileIcon
import com.example.composefood.commons.SubTitleText
import com.example.composefood.components.CircleButtonShadowed
import com.example.composefood.ui.theme.GREY_10

private const val Tag = "CartScreen"
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.CartScreen(
    modifier: Modifier = Modifier,
    onProfileClick:()->Unit = {},
    onBackClick:()->Unit = {},
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionScope: SharedTransitionScope,
    onItemClick:(Int,Int)->Unit,
    onClick:()->Unit
){
    Surface(modifier = modifier
        .fillMaxSize()
    ) {
        Column(modifier = modifier.background(color = GREY_10)) {
            Header(modifier = modifier,onProfileClick = onProfileClick,onBackClick)
            Spacer(modifier = modifier.height(16.dp))
            CartFeed(
                modifier = modifier,
                animatedVisibilityScope = animatedVisibilityScope,
                sharedTransitionScope = sharedTransitionScope,
                onItemClick = onItemClick
            )
        }
    }
}

@Composable
private fun Header(modifier: Modifier, onProfileClick: () -> Unit,
                   onBackClick: () -> Unit,){
    Row (modifier = modifier
        .background(color = Color.White, shape = RoundedCornerShape(12.dp))
        .fillMaxWidth()
        .height(120.dp)
        .padding(),
        verticalAlignment = Alignment.CenterVertically,){
        Row(
            modifier = Modifier
                .weight(1f)
            ,
            horizontalArrangement = Arrangement.Absolute.Left
        ) {

            HeaderBackIcon(modifier = modifier.padding(start = 12.dp),
                icon = Icons.Default.KeyboardArrowLeft){
                onBackClick.invoke()
            }

        }
        MediumHeightText(text = "Your Orders")
        Box(
            modifier = modifier
                .weight(1f)
                .padding(end = 12.dp),
            contentAlignment = Alignment.CenterEnd
        ){
            ProfileIcon(
                modifier = modifier,
                imageVector = Icons.Default.Person,
                size = 40.dp,
                onClick = onProfileClick
                )
        }
    }
}


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun CartItem(
    modifier: Modifier = Modifier,
    data: UiModel,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    onItemClick: (Int, Int) -> Unit){

    Box(modifier = modifier
        .fillMaxWidth()
        .wrapContentHeight()){
        Card(
            modifier = modifier
                .fillMaxWidth(0.85f)
                .height(140.dp)
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
                modifier = modifier.padding(start = 100.dp, top = 16.dp,
                    end = 16.dp)){
                Spacer(modifier = modifier.height(12.dp))
                MediumHeightText(text = data.name)
                SubTitleText(text = data.description)
                Spacer(modifier = modifier.height(26.dp))
                Row(
                    modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically) {
                    CurrencyText(price = data.price.toFloat())
                    Spacer(modifier = modifier.weight(1f))
                    CounterButton()
                }
                Spacer(modifier = modifier.height(12.dp))
            }
        }
        with(sharedTransitionScope){
            CircleMenuItem(
                modifier = modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 10.dp),
                image = data.image,
                animatedVisibilityScope = animatedVisibilityScope,
                sharedTransitionScope = this,
                itemId = data.id,
                onItemClick = onItemClick
            )
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.CartFeed(
    viewModel: CartViewModel = hiltViewModel(),
    modifier: Modifier,
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionScope: SharedTransitionScope,
    onItemClick: (Int, Int) -> Unit
) {

    val data = viewModel.uiState.collectAsStateWithLifecycle()
    val action = viewModel.action
    val list = data.value.data
    CartList(
        data = list, modifier = modifier, animatedVisibilityScope = animatedVisibilityScope,
        sharedTransitionScope = sharedTransitionScope,
        onItemClick
    )
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun CartList(
    data: SnapshotStateList<UiModel>,
    modifier: Modifier,
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionScope: SharedTransitionScope,
    onItemClick: (Int, Int) -> Unit,
) {
    LazyColumn(
        modifier = modifier
            .systemBarsPadding()
            .fillMaxSize(),
    ) {
        items(data.size) {
            CartItem(
                data = data[it],
                animatedVisibilityScope = animatedVisibilityScope,
                sharedTransitionScope = sharedTransitionScope,
                onItemClick = onItemClick
            )
            Spacer(modifier = modifier.height(12.dp))
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun CircleMenuItem(
    modifier: Modifier = Modifier,
    image: Int,
    itemId: Int,
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionScope: SharedTransitionScope,
    onItemClick: (Int, Int) -> Unit
) {
    Box(
        modifier = modifier
            .height(140.dp)
            .width(140.dp)
    ) {
        with(sharedTransitionScope) {
            CircleButtonShadowed(animatedVisibilityScope = animatedVisibilityScope,
                itemId = itemId,
                onItemClick = onItemClick,)
        }
    }
}
@Preview
@Composable
fun PreviewFoodOrdersScreen(){

}