package com.android.diarytrack.navigation

import com.android.diarytrack.util.Constants.WRITE_SCREEN_ARGUMENT_KEY

sealed class Screen(val route: String){
    object AuthenticationScreen: Screen(route = "AuthenticationScreen")
    object Home: Screen(route = "Home")
    object Write: Screen(route = "Write?$WRITE_SCREEN_ARGUMENT_KEY ={$WRITE_SCREEN_ARGUMENT_KEY}"){
        fun passDiaryId(diaryId: String): String{
            return "Write?$WRITE_SCREEN_ARGUMENT_KEY  = $diaryId"
        }
    }
}
