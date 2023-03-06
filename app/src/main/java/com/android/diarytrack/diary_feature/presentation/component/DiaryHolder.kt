package com.android.diarytrack.diary_feature.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.android.diarytrack.diary_feature.model.Diary

@Composable
fun DiaryHolder(diary: Diary, onClick : (String) -> Unit) {
    var componentHeight = remember {
        mutableStateOf(0.dp)
    }
    val localDensity = LocalDensity.current
    Row(modifier =Modifier.clickable { onClick(diary.id.toString()) } )
    {
        // long straight line on left of diary items
            Spacer(modifier = Modifier.width(14.dp))
            Surface(
                modifier = Modifier
                    .width(2.dp)
                    .height(componentHeight.value + 14.dp),
                tonalElevation = com.android.diarytrack.ui.theme.Elevation.Level1
            ) {
                Surface(
                    modifier = Modifier
                        .clip(shape = Shapes().medium)
                        .onGloballyPositioned {
                            //componentHeight = with(localDensity) { it.size.height.toDp() }
                        },
                    tonalElevation = com.android.diarytrack.ui.theme.Elevation.Level1
                ){

                }
            }
            Spacer(modifier = Modifier.width(20.dp))
    }

}