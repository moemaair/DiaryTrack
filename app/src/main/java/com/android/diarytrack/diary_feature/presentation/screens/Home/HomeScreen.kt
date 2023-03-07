package com.android.diarytrack.diary_feature.presentation.screens.Home

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import java.time.LocalDate

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToWriteScreen: () -> Unit,
    onMenuClicked: () -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
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

        Homecontent()
    }
}