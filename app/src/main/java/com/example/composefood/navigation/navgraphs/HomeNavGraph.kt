package com.example.composefood.navigation.navgraphs

import android.telecom.Call.Details
import android.util.Log
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.composefood.feature.favourites.presentation.FavouritesScreen
import com.example.composefood.feature.cart.presentation.CartScreen
import com.example.composefood.feature.detail.presentation.FoodDetailScreen
import com.example.composefood.feature.home.presentation.MainScreen
import com.example.composefood.feature.profile.presentation.ProfileScreen
import com.example.composefood.feature.search.presentation.SearchScreen
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
                Log.d(Tag, "HomeScreenNavGraph() called")
                navHostController.navigate(Graph.DETAILS_GRAPH)
            }
        }
        composable(route = BottomBarScreen.PREMIUM.route){
            SearchScreen{

            }
        }
        composable(route = BottomBarScreen.FOODERSHUB.route){
            CartScreen{

            }
        }
        composable(route = BottomBarScreen.FAVOURITES.route){
           ProfileScreen()
        }
        detailsNavGraph(navController = navHostController)

    }

}
fun NavGraphBuilder.detailsNavGraph(navController:NavHostController){
    navigation(
        route = Graph.DETAILS_GRAPH,
        startDestination = DetailsScreen.FoodDetails.route

    ){
        composable(route = DetailsScreen.FoodDetails.route ){
            FoodDetailScreen {

            }
        }
    }

}
sealed class DetailsScreen(val route:String){
    data object FoodDetails:DetailsScreen(route = "DETAILS")
}

private const val Tag = "HomeScreen"