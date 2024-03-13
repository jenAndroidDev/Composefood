package com.example.composefood.navigation.navgraphs

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composefood.feature.favourites.presentation.FavouritesScreen
import com.example.composefood.feature.foodersHub.presentation.OrderScreen
import com.example.composefood.feature.home.presentation.MainScreen
import com.example.composefood.feature.premium.presentation.PremiumScreen
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
            PremiumScreen(){

            }
        }
        composable(route = BottomBarScreen.FOODERSHUB.route){
            OrderScreen(){

            }
        }
        composable(route = BottomBarScreen.FAVOURITES.route){
            FavouritesScreen()
        }

    }

}

private const val Tag = "HomeScreen"