package com.android.diarytrack.diary_feature.presentation.screens.auth

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.android.diarytrack.util.Constants.CLIENT_ID
import com.stevdzasan.onetap.OneTapSignInState
import com.stevdzasan.onetap.OneTapSignInWithGoogle

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthenticationScreen(
    oneTapSignInState: OneTapSignInState,
    loadingState: Boolean,
    onButtonClick: () -> Unit
) {
    Scaffold(
        content = {
            AuthenticationScreenContent(
                loadingState = loadingState,
                onButtonClick = onButtonClick,
            )
        }
    )
    //stevdza-san
    //OneTapCompose Library

    OneTapSignInWithGoogle(
        state = oneTapSignInState,
        clientId = CLIENT_ID ,
        onTokenIdReceived = {tokenId->

        },
        onDialogDismissed = {message->

        }
    )
}