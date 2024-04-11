package com.example.composefood.feature.home.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composefood.commons.MediumHeightText
import com.example.composefood.navigation.BottomBarScreen
import com.example.composefood.navigation.navgraphs.HomeScreenNavGraph
import com.example.composefood.ui.theme.GoldenYellow
import com.example.composefood.ui.theme.InkBlack
import timber.log.Timber


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navHostController: NavHostController = rememberNavController()){

    Scaffold(
        bottomBar = { CustomBottomBar(navHostController) }
    ) {it->
        HomeScreenNavGraph(navHostController)
        Timber.tag(Tag).d("homeScreen...$it")
    }
}

@Composable
fun CustomBottomBar(navHostController: NavHostController){

    val screens = listOf(
        BottomBarScreen.HOME,
        BottomBarScreen.PREMIUM,
        BottomBarScreen.FOODERSHUB,
        BottomBarScreen.FAVOURITES,
    )
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val bottomBarDestination = screens.any { it.route==currentDestination?.route }
    
    Row (modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .padding(8.dp)
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ){
        screens.forEach {screen->
            CustomBottomNavigationItem(
                screen = screen,
                currentDestination = currentDestination,
                navHostController = navHostController,
            )
        }
    }
}
@Deprecated("Not in use only for M3 bottom navigation")
@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navHostController: NavHostController
){
    BottomNavigationItem(
        label = { MediumHeightText(text = screen.title) },
        icon = { Icon(imageVector = screen.icon, contentDescription = "") },
        selected = currentDestination?.hierarchy?.any { it.route==screen.route }!!,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navHostController.navigate(screen.route){
                popUpTo(navHostController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        })
}

@Composable
fun RowScope.CustomBottomNavigationItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navHostController: NavHostController,
){

    val isSelected = currentDestination?.hierarchy?.any { it.route==screen.route }
        ?:false
    val backgroundColor = if (isSelected) GoldenYellow.copy(alpha = 0.3f)else Color.Transparent
    val contentColor = if (isSelected) InkBlack else MaterialTheme.colorScheme.onBackground

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable {
                navHostController.navigate(screen.route) {
                    popUpTo(navHostController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            },
    ){
        Row(modifier = Modifier
            .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(imageVector = screen.icon, contentDescription = "")
            AnimatedVisibility(visible = isSelected ) {
                Text(text = screen.title, color = contentColor,)
            }
        }
    }
}


private const val Tag = "HomeScreen"