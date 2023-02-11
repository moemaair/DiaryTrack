package com.android.diarytrack.diary_feature.presentation.screens.Home

import android.annotation.SuppressLint
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import com.android.diarytrack.util.Constants.APP_ID
import io.realm.kotlin.mongodb.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun HomeScreen() {
    val scope = rememberCoroutineScope()
    Button(onClick = {
        scope.launch(Dispatchers.IO) {
            App.Companion.create(APP_ID).currentUser?.logOut()
        }
    }) {
        Text(text = "Log out")
    }
}