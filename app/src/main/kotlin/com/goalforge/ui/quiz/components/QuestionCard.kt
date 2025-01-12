package com.goalforge.ui.quiz.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.goalforge.domain.model.Answer
import com.goalforge.domain.model.Question

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionCard(
    question: Question,
    onAnswerSelected: (String, Answer) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = question.text,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            question.options.forEach { answer ->
                OutlinedButton(
                    onClick = { onAnswerSelected(question.id, answer) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Text(answer.text)
                }
            }
        }
    }
}