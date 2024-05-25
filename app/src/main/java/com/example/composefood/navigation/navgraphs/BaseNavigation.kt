package com.example.composefood.navigation.navgraphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composefood.feature.home.presentation.HomeScreen

@Composable
fun BaseNavGraph(navHostController: NavHostController){

    NavHost(navController = navHostController, route = Graph.BASE_GRAPH, startDestination = Graph.HOME_GRAPH){
        composable(Graph.HOME_GRAPH){
            HomeScreen()
        }

    }
}

object Graph{

    const val BASE_GRAPH = "base_graph"
    const val ONBOARD_GRAPH = "onboard_graph"
    const val HOME_GRAPH = "home_graph"
    const val CORE_GRAPH = "core_graph"
    const val DETAILS_GRAPH="details_graph"

}
private const val START_DESTINATION = 1