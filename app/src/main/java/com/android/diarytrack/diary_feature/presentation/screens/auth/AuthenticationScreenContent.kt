package com.android.diarytrack.diary_feature.presentation.screens.auth
import androidx.compose.runtime.Composable
import com.android.diarytrack.diary_feature.presentation.component.HomeGoogleButtonCustomized

@Composable
fun AuthenticationScreenContent(
    loadingState: Boolean,
    onButtonClick: () -> Unit
) {

    //dummy text and icon

    // sign in with google button

    HomeGoogleButtonCustomized(
        loadingState = loadingState,
        onClick = onButtonClick
    )

}