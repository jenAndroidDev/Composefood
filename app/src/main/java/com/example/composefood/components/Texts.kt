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
    text:String = "Sample Text1",
    fontFamily:FontFamily = FontFamily(
        Font(R.font.gilroy_regular, FontWeight.Normal),
        Font(R.font.gilroy_thin, FontWeight.Light),
        Font(R.font.gilroy_medium, FontWeight.Medium),
        Font(R.font.gilroy_semibold, FontWeight.SemiBold)

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
        Font(R.font.gilroy_regular, FontWeight.Normal),
        Font(R.font.gilroy_thin, FontWeight.Light),
        Font(R.font.gilroy_medium, FontWeight.Medium),
        Font(R.font.gilroy_semibold, FontWeight.SemiBold)

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
        maxLines = 2
    )


}

@Preview
@Composable
fun SubTitleText(
    color: Color = PaleGrey,
    text: String = "Eat Delicious Pizza",
    fontFamily:FontFamily = FontFamily(
        Font(R.font.gilroy_regular, FontWeight.Normal),
        Font(R.font.gilroy_thin, FontWeight.Light),
        Font(R.font.gilroy_medium, FontWeight.Medium),
        Font(R.font.gilroy_semibold, FontWeight.SemiBold)
    )){
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
    text: String = "78 Calories",
    fontFamily: androidx.compose.ui.text.font.FontFamily = FontFamily(
        Font(R.font.gilroy_regular, FontWeight.Normal),
        Font(R.font.gilroy_thin, FontWeight.Light),
        Font(R.font.gilroy_medium, FontWeight.Medium),
        Font(R.font.gilroy_semibold, FontWeight.SemiBold)

    )


){
    Text(
        text = text,
        color = color,
        fontSize = 12.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.SemiBold
        )
}

@Preview
@Composable
fun CurrencyText(
    currencySymbolColor: Color = GoldenYellow,
    symbolValue:String="$",
    priceColor:Color = InkBlack,
    price: Float = 9.80f,
    modifier: Modifier,
    fontFamily: FontFamily = FontFamily(
        Font(R.font.gilroy_regular, FontWeight.Normal),
        Font(R.font.gilroy_thin, FontWeight.Light),
        Font(R.font.gilroy_medium, FontWeight.Medium),
        Font(R.font.gilroy_semibold, FontWeight.SemiBold)

    )
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(text = symbolValue, color = currencySymbolColor,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium)
        Spacer(modifier = modifier.width(4.dp))
        Text(text = price.toString(),
            color = priceColor,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold)
    }
}
