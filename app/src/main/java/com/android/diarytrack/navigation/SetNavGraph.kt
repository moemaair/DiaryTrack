package com.android.diarytrack.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.diarytrack.diary_feature.presentation.screens.auth.AuthenticationScreen
import com.android.diarytrack.util.Constants.WRITE_SCREEN_ARGUMENT_KEY

@Composable
fun SetNavGraph(startDestination: String, navController: NavHostController) {
    NavHost(
        startDestination = startDestination,
        navController = navController
    ){
        authenticationRoute()
        HomeRoute()
        WriteRoute()
    }

}

fun NavGraphBuilder.authenticationRoute(){
    composable(route = Screen.AuthenticationScreen.route){
        AuthenticationScreen(loadingState = false, onButtonClick = {})
    }
}

fun NavGraphBuilder.HomeRoute(){
    composable(route = Screen.Home.route){}
}

fun NavGraphBuilder.WriteRoute(){
    composable(route = Screen.Write.route,
        arguments = listOf(navArgument(name = WRITE_SCREEN_ARGUMENT_KEY){
            type = NavType.StringType
            nullable = true
            defaultValue = null
        })
    ){}
}