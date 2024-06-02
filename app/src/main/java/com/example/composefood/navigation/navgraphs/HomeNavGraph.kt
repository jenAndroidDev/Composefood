package com.example.composefood.navigation.navgraphs

import android.telecom.Call.Details
import android.util.Log
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.composefood.feature.favourites.presentation.FavouritesScreen
import com.example.composefood.feature.cart.presentation.CartScreen
import com.example.composefood.feature.detail.presentation.FoodDetailScreen
import com.example.composefood.feature.home.presentation.MainScreen
import com.example.composefood.feature.profile.presentation.ProfileScreen
import com.example.composefood.feature.search.presentation.SearchScreen
import com.example.composefood.navigation.BottomBarScreen


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun HomeScreenNavGraph(navHostController: NavHostController) {

    SharedTransitionLayout {
        NavHost(navController = navHostController, startDestination = BottomBarScreen.HOME.route,
            route = Graph.HOME_GRAPH,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ) {
            composable(
                route = BottomBarScreen.HOME.route,
            ) {
                MainScreen(
                    animatedVisibilityScope = this,
                    sharedTransitionScope = this@SharedTransitionLayout,
                    onProfileClick = {
                        navHostController.navigate(BottomBarScreen.FAVOURITES.route)
                    },
                    onSearchClick = {
                        navHostController.navigate(BottomBarScreen.PREMIUM.route)
                    }
                ) { itemId, resId ->
                    Log.d(Tag, "HomeScreenNavGraph() called")
                    //navHostController.navigate(Graph.DETAILS_GRAPH)
                    navHostController.navigate("details/$itemId/$resId")
                }
            }
            composable(route = BottomBarScreen.PREMIUM.route) {
                SearchScreen(animatedVisibilityScope = this) {

                }
            }
            composable(route = BottomBarScreen.FOODERSHUB.route) {
                CartScreen(onProfileClick = {
                    navHostController.navigate(BottomBarScreen.FAVOURITES.route)
                },
                onBackClick = {
                    navHostController.popBackStack()
                }
                ) {

                }
            }
            composable(route = BottomBarScreen.FAVOURITES.route) {
                ProfileScreen()
            }
            composable(route = "details/{itemId}/{resId}",
                arguments = listOf(
                    navArgument("resId") {
                        type = NavType.IntType
                    },
                    navArgument("itemId") {
                        type = NavType.IntType
                    }
                )
            ) {
                val resId = it.arguments?.getInt("resId") ?: 0
                val itemId = it.arguments?.getInt("itemId") ?: 0
                FoodDetailScreen(
                    animatedContentScope = this,
                    sharedTransitionScope = this@SharedTransitionLayout,
                    resId = resId,
                    itemId = itemId
                ) {
                    navHostController.popBackStack()
                }
            }

            //detailsNavGraph(navController = navHostController)

        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.detailsNavGraph(
    navController: NavHostController,
) {
    navigation(
        route = Graph.DETAILS_GRAPH,
        startDestination = DetailsScreen.FoodDetails.route

    ) {
        composable(route = DetailsScreen.FoodDetails.route) {
            SharedTransitionLayout {

            }
        }
    }

}

sealed class DetailsScreen(val route: String) {
    data object FoodDetails : DetailsScreen(route = "DETAILS")
}

private const val Tag = "HomeScreen"