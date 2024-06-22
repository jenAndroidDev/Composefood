package com.example.composefood.feature.profile.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefood.commons.MediumHeightText
import com.example.composefood.commons.SmallHeightText
import com.example.composefood.components.HeaderBackIcon
import com.example.composefood.components.ProfileIcon
import com.example.composefood.feature.profile.presentation.paymentoption.PaymentOptionScreen
import com.example.composefood.ui.theme.GREY_10
import com.example.composefood.ui.theme.GREY_80
import com.example.composefood.ui.theme.GoldenYellow
import com.example.composefood.ui.theme.InkBlack
import com.example.composefood.ui.theme.PaleGrey
import com.example.composefood.ui.theme.WhiteGrey
import kotlinx.coroutines.launch
import timber.log.Timber

private const val Tag = "ProfileScreen"
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    onBackClick:()->Unit
    ){
    val scrollBehaviour = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehaviour.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(title = {
                MediumHeightText(text = "My Profile")

            },
                navigationIcon = {
                    HeaderBackIcon(
                        modifier = modifier.padding(start = 12.dp),
                        icon = Icons.Default.KeyboardArrowLeft,
                        onClick = onBackClick
                    )
                },
                actions = {
                    ProfileIcon(
                        modifier = modifier,
                        imageVector = Icons.Default.Create,
                        size = 40.dp,
                        backgroundColor = WhiteGrey,
                    )
                }
            )
        }) { innerPadding ->
        Timber.tag(Tag).d("$innerPadding")

        Column(modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(paddingValues = innerPadding)
            .background(color = GREY_10)) {
            Spacer(modifier = modifier.height(16.dp))
            ProfileDetails(modifier = modifier)
            Spacer(modifier = modifier.height(16.dp))
            ProfileTab(modifier)
        }
    }
}
@Composable
private fun ProfileDetails(modifier: Modifier){
    Column (modifier = modifier.fillMaxWidth()){
        Row (modifier = modifier.padding(start = 16.dp)){
            ProfileIcon(modifier = modifier, size = 60.dp)
            Spacer(modifier = modifier.width(16.dp))
            Column(modifier = modifier.wrapContentSize()) {
                MediumHeightText(text = "Jenin Joseph R J")
                SmallHeightText(text = "rjjeninjoseph@gmail.com", color = GREY_80)
                SmallHeightText(text = "ph 7010347243", color = GREY_80)
            }
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
            "Account"
        ),
        TabItem(
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            "Payment Method"
        ),
        TabItem(
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            "History"
        ),)
    val pagerState = rememberPagerState(pageCount = { tabItems.size })

    Column(modifier.fillMaxWidth()) {
        val coroutineScope = rememberCoroutineScope()
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = {tabPositions->
                if (pagerState.currentPage < tabPositions.size) {
                    TabRowDefaults.SecondaryIndicator(
                        Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                        color = GoldenYellow
                    )
                }
            }
        ) {
            tabItems.forEachIndexed { index, page ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                    text = { Text(text = page.description) },
                    selectedContentColor = InkBlack,
                    unselectedContentColor = GREY_80
                )
            }
        }
        HorizontalPager(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { index ->
            when (index) {

                0->{
                     WalletScreen()
                }
                1->{
                    PaymentOptionScreen(modifier = modifier)
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
    ProfileScreen{

    }
}