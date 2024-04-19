package com.example.composefood.feature.profile.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun UserDetailScreen(modifier: Modifier){
    Box(modifier = modifier.fillMaxWidth()){
        Text(text = "User Detail Screen")
    }
}