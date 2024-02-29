package com.example.composefood.navigation.navgraphs

import android.util.Log
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composefood.feature.favourites.presentation.FavouritesScreen
import com.example.composefood.feature.foodersHub.presentation.FoodersHubScreen
import com.example.composefood.feature.home.presentation.HomeScreen
import com.example.composefood.feature.premium.presentation.PremiumScreen
import com.example.composefood.feature.profile.presentation.ProfileScreen
import com.example.composefood.navigation.BottomBarScreen
import timber.log.Timber

@Deprecated("Currently not working..Replace with Home Screen Graph")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoreNavigation(navHostController: NavHostController = rememberNavController()){

    Scaffold(bottomBar = { BottomBar(navHostController = navHostController) }) { it->

        Timber.tag(Tag).d("scaffod..$it")

        CoreNavGraph(navHostController = navHostController)
    }

}

@Deprecated("Not in user")
@Composable
fun BottomBar(navHostController: NavHostController){

    val screens = listOf(
        BottomBarScreen.HOME,
        BottomBarScreen.PREMIUM,
        BottomBarScreen.FOODERSHUB,
        BottomBarScreen.FAVOURITES,
        BottomBarScreen.PROFILE
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()

    val currentDestination = navBackStackEntry?.destination

    Log.d(Tag, "BottomBar() called with: navHostController = $currentDestination")

    val bottomBarDesignation = screens.any{it.route==currentDestination?.route}

    if (bottomBarDesignation){

        BottomNavigation(modifier = Modifier.size(20.dp)) {

            screens.forEach { bottomBarScreen ->
                AddItem(screen = bottomBarScreen, currentDestination = currentDestination, navHostController = navHostController)
            }
        }
    }

}

@Composable
fun RowScope.AddItem(
    screen:BottomBarScreen,
    currentDestination: NavDestination?,
    navHostController: NavHostController

){
    
    BottomNavigationItem(

        selected = currentDestination?.hierarchy?.any { it.route==screen.route }!!,
        onClick = {
                  navHostController.navigate(screen.route){
                      popUpTo(navHostController.graph.findStartDestination().id)
                      launchSingleTop = false
                  }
        },
        label = { Text(text = screen.title, textAlign = TextAlign.Center)},
        icon = { Icon(imageVector = screen.icon, contentDescription = "", modifier = Modifier.size(16.dp))},
        selectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),

    )

}

@Composable
fun CoreNavGraph(navHostController: NavHostController){
    NavHost(navController = navHostController, route = Graph.CORE_GRAPH,
    startDestination = BottomBarScreen.HOME.route){

        composable(route = BottomBarScreen.HOME.route){
            //HomeScreen()
        }

        composable(route = BottomBarScreen.PREMIUM.route){
            PremiumScreen(){

            }
        }

        composable(route = BottomBarScreen.FOODERSHUB.route){
            FoodersHubScreen()
        }

        composable(route = BottomBarScreen.FAVOURITES.route){
            FavouritesScreen()
        }

        composable(route = BottomBarScreen.PROFILE.route){
            ProfileScreen()
        }
    }

}
private const val Tag = "CoreNavigationGraph"


