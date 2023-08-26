package com.lan.sanbercodefinalproject.ui.shared

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.lan.sanbercodefinalproject.ui.theme.SanbercodeFinalProjectTheme
import kotlinx.coroutines.delay

@Composable
fun ShowProgressIndicator(
    isLoading: Boolean,
    circleColor: Color = MaterialTheme.colorScheme.primary,
    circleSize: Dp = 20.dp,
    animationDelay: Int = 750,
    initialAlpha: Float = 0.3f
) {
    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.DarkGray.copy(alpha = .75f)),
            contentAlignment = Center
        ) {
            // 3 circles
            val circles = listOf(
                remember {
                    Animatable(initialValue = initialAlpha)
                },
                remember {
                    Animatable(initialValue = initialAlpha)
                },
                remember {
                    Animatable(initialValue = initialAlpha)
                }
            )

            circles.forEachIndexed { index, animatable ->
                LaunchedEffect(Unit) {

                    // Use coroutine delay to sync animations
                    delay(timeMillis = (animationDelay / circles.size).toLong() * index)

                    animatable.animateTo(
                        targetValue = 1f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(
                                durationMillis = animationDelay
                            ),
                            repeatMode = RepeatMode.Reverse
                        )
                    )
                }
            }

            Box(
                modifier = Modifier
                    .size((circleSize.value * 6.4f).dp)
                    .clip(shape = RoundedCornerShape(corner = CornerSize(24.dp)))
                    .background(color = MaterialTheme.colorScheme.background),
                contentAlignment = Center
            ) {
                // container for circles
                Row(
                    modifier = Modifier
                    //.border(width = 2.dp, color = Color.Magenta)
                ) {
                    // adding each circle
                    circles.forEachIndexed { index, animatable ->

                        // gap between the circles
                        if (index != 0) {
                            Spacer(modifier = Modifier.width(width = 10.dp))
                        }

                        Box(
                            modifier = Modifier
                                .size(size = circleSize)
                                .clip(shape = CircleShape)
                                .background(
                                    color = circleColor
                                        .copy(alpha = animatable.value)
                                )
                        ) {
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SanbercodeFinalProjectTheme {
        ShowProgressIndicator(true)
    }
}