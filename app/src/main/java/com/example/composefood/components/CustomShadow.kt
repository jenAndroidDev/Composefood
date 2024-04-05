package com.example.composefood.components

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
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
import androidx.compose.ui.graphics.toArgb
import com.example.composefood.commons.CircleImage

@Preview
@Composable
fun Modifier.CustomShadow(
    color:Color = Color.Black,
    offsetX: Dp = 0.dp,
    offsetY:Dp = 0.dp,
    blurRadius:Dp = 0.dp,
    shapeRadius:Dp = 0.dp,

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

            it.drawCircle(

                paint = paint,
                radius = size.minDimension/4,
                center = Offset(size.width/2,
                    size.width/2),


            )
//            if (shapeRadius > 0.dp) {
//                val radiusPx = shapeRadius.toPx()
//                it.drawRoundRect(
//                    left = leftPixel,
//                    top = topPixel,
//                    right = rightPixel,
//                    bottom = bottomPixel,
//                    radiusX = radiusPx,
//                    radiusY = radiusPx,
//                    paint = paint,
//                )
//            } else {
//                it.drawRect(
//                    left = leftPixel,
//                    top = topPixel,
//                    right = rightPixel,
//                    bottom = bottomPixel,
//                    paint = paint,
//                )
//            }
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
            .requiredSize(100.dp)
            .background(Color.Yellow),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp)
                .CustomShadow(
                    offsetX = 6.dp,
                    offsetY = 6.dp,
                    blurRadius = 8.dp,
                ),

        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Green),
            ) {

            }
        }
    }
}