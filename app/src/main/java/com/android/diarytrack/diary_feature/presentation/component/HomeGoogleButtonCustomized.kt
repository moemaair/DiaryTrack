package com.android.diarytrack.diary_feature.presentation.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.tooling.preview.Preview
import com.android.diarytrack.R

@Composable
fun HomeGoogleButtonCustomized(
    modifier: Modifier = Modifier,
    loadingState: Boolean = false,
    primaryText: String = "Sign in with Google",
    secondaryText: String = "Please wait...",
    icon: Int = R.drawable.google_icon,
    shape: Shape = Shapes().extraSmall,
    borderColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    borderStrokeWidth: Dp = 1.dp,
    progressIndicatorColor: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit
) {
    var buttonText by remember { mutableStateOf(primaryText) }

    LaunchedEffect(key1 = loadingState) {
        buttonText = if (loadingState) secondaryText else primaryText
    }

    Surface(
        modifier = modifier
            .clickable(enabled = !loadingState) { onClick() },
        shape = shape,
        border = BorderStroke(width = borderStrokeWidth, color = borderColor),
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Google Logo",
                modifier = modifier.height(32.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = buttonText,
                style = TextStyle(fontSize = MaterialTheme.typography.bodyMedium.fontSize)
            )
            if (loadingState) {
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(16.dp),
                    strokeWidth = 2.dp,
                    color = progressIndicatorColor
                )
            }
        }
    }
}

@Composable
@Preview
fun HomeGoogleButtonCustomized() {
    HomeGoogleButtonCustomized {}
}

@Composable
@Preview
fun HomeGoogleButtonCustomized2() {
    HomeGoogleButtonCustomized(loadingState = true) {}
}