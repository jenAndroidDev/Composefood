package com.example.composefood.navigation.navgraphs

import android.util.Log
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composefood.feature.favourites.presentation.FavouritesScreen
import com.example.composefood.feature.foodersHub.presentation.FoodersHubScreen
import com.example.composefood.feature.home.presentation.MainScreen
import com.example.composefood.feature.premium.presentation.PremiumScreen
import com.example.composefood.feature.profile.presentation.ProfileScreen
import com.example.composefood.navigation.BottomBarScreen


@Composable
fun HomeScreenNavGraph(navHostController: NavHostController){

    NavHost(navController = navHostController, startDestination = BottomBarScreen.HOME.route,
    route = Graph.HOME_GRAPH,
        enterTransition = { EnterTransition.None},
        exitTransition = { ExitTransition.None}){

        composable(
            route = BottomBarScreen.HOME.route,
        ){
            MainScreen {

            }
        }
        composable(route = BottomBarScreen.PREMIUM.route){
            PremiumScreen()
        }
        composable(route = BottomBarScreen.FOODERSHUB.route){
            FoodersHubScreen()
        }
        composable(route = BottomBarScreen.FAVOURITES.route){
            FavouritesScreen()
        }

    }

}

private const val Tag = "HomeScreen"