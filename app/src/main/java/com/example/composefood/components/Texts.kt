package com.example.composefood.components


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.composefood.R
import com.example.composefood.ui.theme.PaleGrey


@Preview
@Composable
fun MediumHeightText(
    color: Color = Color.White,
    text:String = "Sample Text",
    fontFamily: androidx.compose.ui.text.font.FontFamily = FontFamily(
        Font(R.font.roboto_black, FontWeight.Normal),
        Font(R.font.roboto_light, FontWeight.Light),
        Font(R.font.roboto_medium, FontWeight.Medium),
        Font(R.font.roboto_bold, FontWeight.Bold)

    )

){
    Text(
        text = text,
        color = color,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        overflow = TextOverflow.Ellipsis
        )


}

@Preview
@Composable
fun SubTitleText(
    color: Color = PaleGrey,
    text: String = "Eat Delicious Pizza"

    ){
    Text(
        text = text,
        color = color,
        overflow = TextOverflow.Ellipsis,

    )
}



@RequiresApi(Build.VERSION_CODES.Q)
val fontFamily = FontFamily(
    Font(R.font.roboto_black, FontWeight.Normal),
    Font(R.font.roboto_light, FontWeight.Light),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_bold, FontWeight.Bold)

)