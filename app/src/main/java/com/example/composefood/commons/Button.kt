package com.example.composefood.commons

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefood.ui.theme.GoldenYellow

@Preview
@Composable
fun CounterButton(modifier: Modifier = Modifier){

    /*
    * Rewrite*/

        Row (modifier = modifier
            .height(30.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(color = GoldenYellow)
            .padding(all = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            MediumHeightText(text = "-")
            Spacer(modifier = modifier.width(12.dp))
            MediumHeightText(text = "1")
            Spacer(modifier = modifier.width(12.dp))
            MediumHeightText(text = "+")

        }

}

@Preview
@Composable
fun CommonRoundedCornerBtn(
    modifier: Modifier=Modifier,
    label:String="Add Now"
    ){
    Column(modifier = modifier
        .fillMaxWidth()
        .height(50.dp)
        .background(color = GoldenYellow, shape = RoundedCornerShape(12.dp)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        MediumHeightText(text = label)
    }
}

@Preview
@Composable
fun CommonCircularButton(
    modifier: Modifier=Modifier,

){
    val mContext = LocalContext.current
        OutlinedButton(onClick = { Toast.makeText(mContext, "This is a Circular Button with a + Icon", Toast.LENGTH_LONG).show()},
            modifier= Modifier.size(80.dp),
            shape = CircleShape,
            border= BorderStroke(5.dp, GoldenYellow),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor =  Color.Blue)
        ) {
            Icon(Icons.Default.Add ,contentDescription = "content description", tint= GoldenYellow)
        }

}


