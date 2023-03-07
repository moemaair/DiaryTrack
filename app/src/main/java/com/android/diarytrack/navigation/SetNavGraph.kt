package com.android.diarytrack.navigation

import AuthenticationViewModel
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.diarytrack.diary_feature.presentation.screens.Home.HomeScreen
import com.android.diarytrack.diary_feature.presentation.screens.auth.AuthenticationScreen
import com.android.diarytrack.util.Constants.APP_ID
import com.android.diarytrack.util.Constants.WRITE_SCREEN_ARGUMENT_KEY
import com.stevdzasan.messagebar.rememberMessageBarState
import com.stevdzasan.onetap.rememberOneTapSignInState
import io.realm.kotlin.mongodb.App
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        HomeRoute(
            navigateToWrite = {
                navController.popBackStack()
                navController.navigate(Screen.Write.route)
            },
            navigateToAuthentication = {
                navController.popBackStack()
                navController.navigate(Screen.AuthenticationScreen.route)
            }
        )
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
                        viewModel.setLoading(false)
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

fun NavGraphBuilder.HomeRoute(
    navigateToWrite: () -> Unit,
    navigateToAuthentication : () -> Unit
){
    composable(route = Screen.Home.route){
        val scope= rememberCoroutineScope()
        HomeScreen(
            navigateToWriteScreen = navigateToWrite,
            onMenuClicked = {
                scope.launch(Dispatchers.IO) {
                    val user = App.create(APP_ID).currentUser
                    if (user != null) {
                        user.logOut()
                        withContext(Dispatchers.Main){
                            navigateToAuthentication()
                        }
                    }
                }
            },
        )
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