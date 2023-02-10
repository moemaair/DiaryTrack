package com.android.diarytrack.navigation

import AuthenticationViewModel
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.diarytrack.diary_feature.presentation.screens.Home.HomeScreen
import com.android.diarytrack.diary_feature.presentation.screens.auth.AuthenticationScreen
import com.android.diarytrack.util.Constants.WRITE_SCREEN_ARGUMENT_KEY
import com.stevdzasan.messagebar.rememberMessageBarState
import com.stevdzasan.onetap.rememberOneTapSignInState

@Composable
fun SetNavGraph(startDestination: String, navController: NavHostController) {
    NavHost(
        startDestination = startDestination,
        navController = navController
    ){
        authenticationRoute(
            navigateToHome = {
                navController.popBackStack()
                navController.navigate(Screen.Home.route)
            }
        )
        HomeRoute()
        WriteRoute()
    }

}

fun NavGraphBuilder.authenticationRoute(
    navigateToHome: () -> Unit
){
    composable(route = Screen.AuthenticationScreen.route){
        val viewModel:AuthenticationViewModel = viewModel()
        val loadingState by viewModel.loadingState
        val authenticated by viewModel.authenticated
        val oneTapSignInState = rememberOneTapSignInState()
        var messageBarState = rememberMessageBarState()
        AuthenticationScreen(
            authenticated = authenticated,
            oneTapSignInState = oneTapSignInState,
            messageBarState = messageBarState,
            loadingState = loadingState,
            onDialogDismissed = { message->
                messageBarState.addError(Exception(message))
            },
            onTokenReceived ={ tokenid->
                viewModel.signInWithMongoAtlas(
                    tokenId = tokenid,
                    onSuccess = { it->
                       if(it){
                           messageBarState.addSuccess("Succefully Authenticated")
                       }
                        viewModel.setLoading(false)
                    },
                    onError = { it ->
                        messageBarState.addError(it)
                        viewModel.setLoading(true)
                    }
                )
            },
            onButtonClick = {
                        oneTapSignInState.open()
                viewModel.setLoading(true)
            },
            navigateToHome = navigateToHome
        )
    }
}

fun NavGraphBuilder.HomeRoute(){
    composable(route = Screen.Home.route){
        HomeScreen()
    }
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