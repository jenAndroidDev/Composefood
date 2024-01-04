package com.example.composefood.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen (
    val route:String,
    val title:String,
    val icon:ImageVector
        ){

    object HOME:BottomBarScreen(
        route = "HOME",
        title = "Home",
        icon = Icons.Filled.Home
    )

    object PREMIUM:BottomBarScreen(
        route ="PREMIUM",
        title ="Premium",
        icon = Icons.Filled.Star
    )

    object FOODERSHUB:BottomBarScreen(
        route = "HUB",
        title = "Hub",
        icon = Icons.Filled.Share
    )

    object FAVOURITES:BottomBarScreen(
        route = "LIKED",
        title = "Liked",
        icon = Icons.Filled.ThumbUp
    )

    object PROFILE:BottomBarScreen(
        route = "PROFILE",
        title = "Profile",
        icon = Icons.Filled.Person
    )

}