package com.example.composefood.feature.foodersHub.presentation

import android.graphics.drawable.shapes.RoundRectShape
import android.preference.PreferenceActivity.Header
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefood.R
import com.example.composefood.commons.CircleImage
import com.example.composefood.commons.HeaderSpacing
import com.example.composefood.components.HeaderBackIcon
import com.example.composefood.components.MediumHeightText
import com.example.composefood.components.ProfileIcon
import com.example.composefood.ui.theme.GoldenYellow
import com.example.composefood.ui.theme.InkBlack

@Composable
fun OrderScreen(
    modifier: Modifier = Modifier,
    onClick:()->Unit
){

    Surface(modifier = modifier
        .fillMaxSize()
    ) {
        Column(modifier = modifier.background(
            color = GoldenYellow.copy(alpha = 0.3f)
        )) {
            HeaderSpacing(modifier = modifier)
            Header(modifier = modifier)
        }

    }
}

@Composable
private fun Header(modifier: Modifier){
    Row (modifier = modifier
        .fillMaxWidth()
        .padding(),
        verticalAlignment = Alignment.CenterVertically){
        Row(
            modifier = Modifier
                .weight(1f),
            horizontalArrangement = Arrangement.Absolute.Left
        ) {

            HeaderBackIcon(modifier = modifier.padding(start = 12.dp),
                icon = Icons.Default.KeyboardArrowLeft)

        }
        MediumHeightText(text = "Card Food")
        Box(
            modifier = modifier
                .weight(1f)
                .padding(end = 12.dp),
            contentAlignment = Alignment.CenterEnd
        ){
            ProfileIcon(modifier = modifier,
                imageVector = Icons.Default.Person,
                size = 40.dp)
        }
    }

}

@Preview
@Composable
fun OrderedItem(modifier: Modifier = Modifier){

    Box(modifier = modifier
        .fillMaxWidth()
        .height(200.dp)){

        Card(modifier = modifier
            .fillMaxWidth(0.85f)
            .height(150.dp)
            .align(Alignment.CenterEnd),
            shape = RoundedCornerShape(topStart = 20.dp,
                bottomStart = 20.dp,
                topEnd = 10.dp,
                bottomEnd = 10.dp)
        ) {
            Text(text = "hello world")
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End,
                modifier = modifier.padding(start = 70.dp)){
                MediumHeightText()
                Spacer(modifier = modifier.height(12.dp))
                MediumHeightText()
            }


        }
        CircleMenuItem(
            modifier = modifier.align(Alignment.CenterStart)

        )

    }
}

@Preview
@Composable
fun CircleMenuItem(modifier: Modifier=Modifier){
    Box(modifier = modifier
        .height(140.dp)
        .width(140.dp)
        .background(Color.White, RoundedCornerShape(200.dp))){
        Image(
            painter = painterResource(id = R.drawable.item_b),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(140.dp)
                .clip(CircleShape)
        )


    }
}



@Preview
@Composable
fun PreviewFoodOrdersScreen(){

    OrderScreen {

    }
}