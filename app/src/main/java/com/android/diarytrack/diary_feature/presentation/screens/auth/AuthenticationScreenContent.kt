package com.android.diarytrack.diary_feature.presentation.screens.auth
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.diarytrack.R
import com.android.diarytrack.diary_feature.presentation.component.HomeGoogleButtonCustomized

@Composable
fun AuthenticationScreenContent(
    loadingState: Boolean,
    onButtonClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier.padding(30.dp, 0.dp),verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            //dummy text and icon
            Column(
                modifier = Modifier.weight(weight = 10f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(120.dp),
                    painter = painterResource(id = R.drawable.google_icon),
                    contentDescription = "Google Logo"
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Welcome To DiaryTrack",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
            }

            // sign in with google buttoM
            Column(modifier = Modifier.weight(2f), verticalArrangement = Arrangement.Bottom ) {
                HomeGoogleButtonCustomized(
                    loadingState = loadingState,
                    onClick = onButtonClick
                )
            }
        }
    }

}