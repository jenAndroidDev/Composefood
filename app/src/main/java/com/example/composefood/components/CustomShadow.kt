package com.example.composefood.components

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.composefood.R
import com.example.composefood.ui.theme.GoldenYellow


fun Modifier.customShadow(
    color:Color = Color.Black,
    offsetX: Dp = 0.dp,
    offsetY:Dp = 0.dp,
    blurRadius:Dp = 0.dp,
    shapeRadius:Dp = 100.dp,

) = composed{

    val paint:Paint = remember {
        Paint()
    }
    val blurRadiusPx = blurRadius.px(LocalDensity.current)

    val maskFilter = remember {
        BlurMaskFilter(blurRadiusPx, BlurMaskFilter.Blur.NORMAL)
    }

    drawBehind {
        drawIntoCanvas {
            val frameworkPaint = paint.asFrameworkPaint()
            if (blurRadius != 0.dp) {
                frameworkPaint.maskFilter = maskFilter
            }
            frameworkPaint.color = color.toArgb()
            val leftPixel = offsetX.toPx()
            val topPixel = offsetY.toPx()
            val rightPixel = size.width + leftPixel
            val bottomPixel = size.height + topPixel

            val circleCenter = (shapeRadius/2).toPx()
            val offsetX = (size.width/2)
            val offsetY = (size.height/2)

            it.drawCircle(
                paint = paint,
                center = Offset(offsetX,offsetY),
                radius = circleCenter
            )

        }
    }
}
private fun Dp.px(density: Density): Float =
    with(density) { toPx() }

@Preview
@Composable
fun PreviewCustomShadow(){
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Yellow),
    ) {

        Image(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.White)
                .customShadow(),
            painter = painterResource(id = R.drawable.item_b),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }

    }


@Preview
@Composable
fun CircleButtonShadowed(
    size:Dp = 100.dp,
    image:Int = R.drawable.sample_circle,
){
    Box(
        modifier = Modifier
            .size(120.dp)
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        GoldenYellow,
                        Color.Transparent
                    )
                )
            )
            .padding(bottom = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            shape = CircleShape,
            modifier = Modifier
                .size(size)
                .background(Color.Transparent)
                .clickable { }
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(size)
                    ,
                    painter = painterResource(id = image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }
        }

    }
}
