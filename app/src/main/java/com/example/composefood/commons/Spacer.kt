package com.example.composefood.commons

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SpacerVertical16Dp(modifier: Modifier){
    Spacer(modifier = modifier.height(16.dp))
}

@Composable
fun HeaderSpacing(modifier: Modifier){
    Spacer(modifier = modifier.height(30.dp))
}