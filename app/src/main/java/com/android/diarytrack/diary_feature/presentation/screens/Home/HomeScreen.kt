package com.android.diarytrack.diary_feature.presentation.screens.Home

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.android.diarytrack.util.Constants.APP_ID
import io.realm.kotlin.mongodb.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToWriteScreen: () -> Unit,
    onMenuClicked: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Diary")
                },
                navigationIcon = {
                    IconButton(onClick = { onMenuClicked() }) {
                       Icon(imageVector =  Icons.Default.Menu,
                           contentDescription = "Hamburger menu",
                            tint = MaterialTheme.colorScheme.onSurface
                       )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector =  Icons.Default.DateRange,
                            contentDescription = "date Icom",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }


            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navigateToWriteScreen()}) {

                Icon(imageVector =  Icons.Default.Edit,
                        contentDescription = "edit",
                        tint = MaterialTheme.colorScheme.onSurface
                )

            }
        }
    ) {

    }
}