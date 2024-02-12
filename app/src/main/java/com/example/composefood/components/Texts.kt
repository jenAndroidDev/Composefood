package com.example.composefood.components


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composefood.R
import com.example.composefood.ui.theme.GoldenYellow
import com.example.composefood.ui.theme.InkBlack
import com.example.composefood.ui.theme.OrangeRed
import com.example.composefood.ui.theme.PaleGrey


@Preview
@Composable
fun MediumHeightText(
    color: Color = InkBlack,
    text:String = "Sample Text",
    fontFamily:FontFamily = FontFamily(
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
        fontWeight = FontWeight.Bold,
        overflow = TextOverflow.Ellipsis,
        fontSize = 16.sp
        )


}

@Preview
@Composable
fun LargeHeightText(
    color: Color = InkBlack,
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
        fontWeight = FontWeight.Bold,
        overflow = TextOverflow.Ellipsis,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        maxLines = 1
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
        fontSize = 10.sp,

    )
}

@Preview
@Composable
fun FoodDetailsText(
    color: Color = OrangeRed,
    text: String = "78 Calories"

){
    Text(text = text, color = color, fontSize = 12.sp)
}

@Preview
@Composable
fun CurrencyText(
    currencySymbolColor: Color = GoldenYellow,
    symbolValue:String="$",
    priceColor:Color = InkBlack,
    price: Float = 9.80f,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(text = symbolValue, color = currencySymbolColor)
        Spacer(modifier = modifier.width(8.dp))
        Text(text = price.toString(), color = priceColor,
            fontSize = 24.sp)
    }
}






@RequiresApi(Build.VERSION_CODES.Q)
val fontFamily = FontFamily(
    Font(R.font.roboto_black, FontWeight.Normal),
    Font(R.font.roboto_light, FontWeight.Light),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_bold, FontWeight.Bold)

)