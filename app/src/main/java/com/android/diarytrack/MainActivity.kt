package com.android.diarytrack

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.android.diarytrack.ui.theme.DiaryTrackTheme



class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            DiaryTrackTheme {
                
               Scaffold(
                   topBar = {
                       TopAppBar(title = { Text(text = "App")}, colors = TopAppBarDefaults.topAppBarColors(
                           containerColor = MaterialTheme.colorScheme.primary
                       )

                       )
                   }
               ){
                   Text(text = "App")
               }

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DiaryTrackTheme {

    }
}