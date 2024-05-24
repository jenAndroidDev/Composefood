package com.example.composefood.feature.detail.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.composefood.commons.LargeHeightText
import com.example.composefood.ui.theme.InkBlack

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun FoodDetailBottomSheet(
    modifier: Modifier =Modifier,
    onDismiss:()->Unit = {},
    ){

    val bottomSheetState = androidx.compose.material3.rememberModalBottomSheetState()

    ModalBottomSheet(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        onDismissRequest = {onDismiss.invoke()
                           },
        sheetState = bottomSheetState,
        contentColor = Color.Yellow
        ) {

        Column {
            LargeHeightText(text = "Spicy Chicken")
        }

    }

}

@Preview
@Composable
fun PreviewFoodDetailSheet(){
    FoodDetailBottomSheet()
}