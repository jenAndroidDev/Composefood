package com.example.composefood.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
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
        title ="Search",
        icon = Icons.Filled.Search
    )

    object FOODERSHUB:BottomBarScreen(
        route = "HUB",
        title = "Card",
        icon = Icons.Filled.ShoppingCart
    )

    object FAVOURITES:BottomBarScreen(
        route = "LIKED",
        title = "Profile",
        icon = Icons.Filled.Person
    )

    object PROFILE:BottomBarScreen(
        route = "PROFILE",
        title = "Profile",
        icon = Icons.Filled.Person
    )

}