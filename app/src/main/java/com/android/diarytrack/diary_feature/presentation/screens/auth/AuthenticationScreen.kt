package com.android.diarytrack.diary_feature.presentation.screens.auth

import androidx.compose.runtime.Composable

@Composable
fun AuthenticationScreen(
    loadingState: Boolean,
    onButtonClick: () -> Unit
) {
    AuthenticationScreenContent(
        loadingState = loadingState,
        onButtonClick = onButtonClick
    )
}