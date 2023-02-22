package com.android.diarytrack


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.android.diarytrack.navigation.Screen
import com.android.diarytrack.navigation.SetNavGraph
import com.android.diarytrack.ui.theme.DiaryTrackTheme
import com.android.diarytrack.util.Constants.APP_ID
import io.realm.kotlin.mongodb.App


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            DiaryTrackTheme {
                    val navController = rememberNavController()
                    SetNavGraph(
                        startDestination = Screen.Home.route,
                        navController = navController
                    )
            }
        }
    }
}

private fun getStartDestination(): String{
    val user = App.create(APP_ID).currentUser
    return if(user != null && user.loggedIn)
        Screen.Home.route else
            Screen.AuthenticationScreen.route

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DiaryTrackTheme {

    }
}