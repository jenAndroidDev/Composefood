package com.example.composefood.commons

import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.composefood.feature.profile.presentation.TabItem

@Composable
fun ProfileTabItem(
    modifier: Modifier=Modifier,
    selectedTabIndex:Int,
    tabItem: TabItem,
    currentIndex:Int,
    tabSelectedColor:Color,
    tabUnselectedColor:Color,
    onTabItemClicked:(Int)->Unit,
    ){
    Tab(
        selected = selectedTabIndex == currentIndex,
        onClick = {
            onTabItemClicked.invoke(currentIndex)
        },
        text = { MediumHeightText(text = tabItem.description) },
        icon = {
            Icon(
                imageVector =
                if (currentIndex == selectedTabIndex) {
                    tabItem.selectedIcon
                } else {
                    tabItem.unselectedIcon
                },
                contentDescription = tabItem.description
            )
        },

        )



}