package com.android.diarytrack.diary_feature.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDate

@Composable
fun DateHeader(local: LocalDate) {
    //date
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.padding(vertical = 16.dp)) {
            Text(text = local.dayOfMonth.toString(),
                style = MaterialTheme.typography.titleLarge)
            Text(text = local.dayOfWeek.toString().take(3).uppercase(),
                style = MaterialTheme.typography.bodyLarge)
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.padding(vertical = 16.dp)) {
            Text(text = local.month.toString().lowercase().replaceFirstChar { it.titlecase() },
                style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Light
            )
            Text(text = local.year.toString(),
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DiaryHolder1() {
    DateHeader(local = LocalDate.now())
}