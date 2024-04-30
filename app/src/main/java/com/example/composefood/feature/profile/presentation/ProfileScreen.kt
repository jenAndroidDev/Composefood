package com.example.composefood.feature.profile.presentation

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefood.commons.MediumHeightText
import com.example.composefood.commons.ProfileTabItem
import com.example.composefood.components.HeaderBackIcon
import com.example.composefood.components.ProfileIcon
import com.example.composefood.feature.cart.presentation.OrdersFeed
import com.example.composefood.ui.theme.GREY_10
import com.example.composefood.ui.theme.GoldenYellow
import kotlinx.coroutines.launch

private const val Tag = "ProfileScreen"
@Composable
fun ProfileScreen(modifier: Modifier = Modifier){
    Surface(modifier = Modifier
        .fillMaxSize()) {

        Column(modifier = modifier.background(color = GREY_10)) {
            Header(modifier = modifier)
            Spacer(modifier = modifier.height(16.dp))
            ProfileTab(modifier)
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
        MediumHeightText(text = "My Profile")
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileTab(modifier: Modifier) {

    val tabItems = listOf(
        TabItem(
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            "Home"
        ),
        TabItem(
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            "Home"
        ),
        TabItem(
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            "Home"
        ),

        )
    val selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    val pagerState = rememberPagerState { tabItems.size }

    val scope = rememberCoroutineScope()

    Column(modifier = modifier.fillMaxSize()) {
        val coroutineScope = rememberCoroutineScope()
        TabRow(selectedTabIndex = pagerState.currentPage,
            indicator = {tabPositions ->
                if (selectedTabIndex<tabPositions.size){
                    TabRowDefaults.Indicator(
                        modifier = modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                        color = GoldenYellow
                    )
                }
            }
            ) {
            tabItems.forEachIndexed { index, tabItem ->
//                ProfileTabItem(
//                    selectedTabIndex = selectedTabIndex,
//                    tabItem = tabItem,
//                    currentIndex = index,
//                    tabSelectedColor = Color.White,
//                    tabUnselectedColor = Color.DarkGray,
//                    onTabItemClicked = {
//                        coroutineScope.launch {
//                            pagerState.animateScrollToPage(selectedTabIndex)
//                        }
//                    }
//                )
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                    text = { Text(text = "Sample") },
                    unselectedContentColor = MaterialTheme.colorScheme.secondary
                )

            }


        }
        HorizontalPager(state = pagerState,
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
        ) {index->
            when(index){
                0->{
                    UserDetailScreen(modifier = modifier)
                }
                1->{
                    WalletScreen()
                }
                2->{
                    PaymentHistoryScreen()
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewProfileScreen(){
    ProfileScreen()
}