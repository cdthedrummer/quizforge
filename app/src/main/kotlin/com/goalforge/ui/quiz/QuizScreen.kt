package com.goalforge.ui.quiz

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.goalforge.ui.quiz.components.QuestionCard
import com.goalforge.ui.quiz.components.ProgressIndicator

@Composable
fun QuizScreen(
    viewModel: QuizViewModel = hiltViewModel(),
    onQuizComplete: () -> Unit
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProgressIndicator(
            currentQuestion = state.questionNumber,
            totalQuestions = state.totalQuestions,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        state.currentQuestion?.let { question ->
            QuestionCard(
                question = question,
                onAnswerSelected = viewModel::onAnswerSelected,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
        }

        if (state.isComplete) {
            onQuizComplete()
        }
    }
}