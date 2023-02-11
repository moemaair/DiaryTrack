package com.android.diarytrack.diary_feature.presentation.lottie

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*


@Composable
fun LootieAuth() {
    val compositionResult: LottieCompositionResult =
        rememberLottieComposition(LottieCompositionSpec.Asset("lottie/lottie_auth.json"))

    val progress by animateLottieCompositionAsState(
        compositionResult.value,
        isPlaying = true,
        iterations = LottieConstants.IterateForever,
        speed = 1.0f
    )

    Column(

        modifier = Modifier.scale(1.7f).background(
            Brush.linearGradient(
                colors = listOf(Color.Red,Color.Blue)
            )
        ).shadow(4.dp, clip = true, ambientColor = Color.Red, spotColor = Color.Blue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        LottieAnimation(
            compositionResult.value,
            progress,
            modifier = Modifier.size(300.dp)
        )
    }
}


