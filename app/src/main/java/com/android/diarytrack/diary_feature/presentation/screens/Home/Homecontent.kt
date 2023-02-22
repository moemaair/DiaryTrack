package com.android.diarytrack.diary_feature.presentation.screens.Home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp

@Composable
fun Homecontent() {
    var contentHeight = remember {
        mutableStateOf(0.dp)
    }

}