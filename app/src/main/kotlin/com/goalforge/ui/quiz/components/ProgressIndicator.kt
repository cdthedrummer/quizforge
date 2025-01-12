package com.goalforge.ui.quiz.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProgressIndicator(
    currentQuestion: Int,
    totalQuestions: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(
            progress = if (totalQuestions > 0) currentQuestion.toFloat() / totalQuestions else 0f,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )
        
        Text(
            text = "Question ${currentQuestion + 1} of $totalQuestions",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}