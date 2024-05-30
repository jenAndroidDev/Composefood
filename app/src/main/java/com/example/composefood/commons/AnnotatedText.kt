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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
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
        withStyle(style = SpanStyle(fontFamily = fontFamily, fontWeight = FontWeight.Bold)){
            appendInlineContent(id="imageId")
            append(" ".plus(text))
        }
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
        inlineContent = inlineContentMap,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold
    )

}

val fontFamily = FontFamily(
    Font(R.font.roboto_thin),
    Font(R.font.roboto_black),
    Font(R.font.roboto_bold),
)

@Preview
@Composable
fun PreviewFoodSubDetails(){

    FoodSubDetail(modifier = Modifier, text = "sample", resId =R.drawable.flame_icon )
}

