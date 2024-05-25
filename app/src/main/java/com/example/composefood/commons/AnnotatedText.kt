package com.example.composefood.commons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.composefood.R
import com.example.composefood.navigation.navgraphs.DetailsScreen

@Composable
fun FoodSubDetail(
    modifier: Modifier,
    text:String,
    resId:Int){

    val annotatedString = buildAnnotatedString {
        appendInlineContent(id="imageId")
        append(text)
    }
    val inlineContentMap = mapOf(
        "imageId" to InlineTextContent(
            Placeholder(20.sp,20.sp, PlaceholderVerticalAlign.Center)
        ){
            Image(painterResource(id = resId),
                contentDescription = null,
                modifier = modifier.fillMaxWidth())
        }
    )
    Text(
        text = annotatedString,
        inlineContent = inlineContentMap)

}

@Preview
@Composable
fun PreviewFoodSubDetails(){

    FoodSubDetail(modifier = Modifier, text = "sample", resId =R.drawable.flame_icon )
}