package com.android.diarytrack.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetNavGraph(startDestination: String, navController: NavHostController) {
    NavHost(
        startDestination = startDestination,
        navController = navController
    ){

    }

}

fun NavGraphBuilder.authenticationRoute(){
    composable(route = Screen.AuthenticationScreen.route){}
}