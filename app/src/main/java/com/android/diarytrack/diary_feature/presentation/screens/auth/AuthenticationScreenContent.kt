package com.android.diarytrack.diary_feature.presentation.screens.auth
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.diarytrack.R
import com.android.diarytrack.diary_feature.presentation.component.HomeGoogleButtonCustomized
import com.android.diarytrack.diary_feature.presentation.lottie.LootieAuth

@Composable
fun AuthenticationScreenContent(
    loadingState: Boolean,
    onButtonClick: () -> Unit
) {
    Surface() {
        Column(modifier = Modifier.fillMaxSize().padding(20.dp, 0.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Column(
                modifier = Modifier.fillMaxWidth().weight(50f)
                    .wrapContentHeight(align = Alignment.Top),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LootieAuth()
            }
            // sign in with google buttoM
            Column(modifier = Modifier.padding(0.dp, 20.dp)
                .weight(50f),
                verticalArrangement = Arrangement.Bottom )
            {
                Text(
                    text = "DiaryTrack",
                    textAlign = TextAlign.Start,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Track Your Life, Live Your Story with diaryTrack",
                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                )
                Spacer(modifier = Modifier.height(20.dp))
                HomeGoogleButtonCustomized(
                    loadingState = loadingState,
                    onClick = onButtonClick
                )

            }

        }
    }
    }

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun Preview() {
    AuthenticationScreenContent(false, {})
}