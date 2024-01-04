package com.example.composefood.navigation.navgraphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation

fun NavGraphBuilder.onboardNavGraph(navHostController: NavHostController){

    navigation(route = Graph.ONBOARD_GRAPH, startDestination = OnBoardScreen.Login.route){


    }



}

sealed class OnBoardScreen(val route:String){

    object Login:OnBoardScreen("LOGIN")
    object SIGNUP:OnBoardScreen("SIGNUP")
}