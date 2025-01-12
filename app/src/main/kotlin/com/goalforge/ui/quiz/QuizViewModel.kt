package com.goalforge.ui.quiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goalforge.domain.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@HiltViewModel
class QuizViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(QuizState())
    val state = _state.asStateFlow()

    private val answers = mutableMapOf<String, Answer>()

    init {
        loadQuestions()
    }

    private fun loadQuestions() {
        // TODO: Load questions from repository
        // For now, using mock data
        val mockQuestions = listOf(
            Question(
                id = "1",
                text = "How often do you engage in physical exercise?",
                attributeWeights = mapOf(
                    Attribute.STRENGTH to 2,
                    Attribute.CONSTITUTION to 3
                ),
                options = listOf(
                    Answer("1a", "Never", 1),
                    Answer("1b", "1-2 times per month", 2),
                    Answer("1c", "1-2 times per week", 3),
                    Answer("1d", "3+ times per week", 4)
                ),
                category = QuestionCategory.PHYSICAL
            )
        )

        _state.update { it.copy(
            questions = mockQuestions,
            currentQuestion = mockQuestions.firstOrNull(),
            totalQuestions = mockQuestions.size
        )}
    }

    fun onAnswerSelected(questionId: String, answer: Answer) {
        answers[questionId] = answer
        moveToNextQuestion()
    }

    private fun moveToNextQuestion() {
        val currentIndex = state.value.questionNumber
        val nextIndex = currentIndex + 1
        val nextQuestion = state.value.questions.getOrNull(nextIndex)

        _state.update { it.copy(
            currentQuestion = nextQuestion,
            questionNumber = nextIndex,
            isComplete = nextQuestion == null
        )}
    }
}

data class QuizState(
    val questions: List<Question> = emptyList(),
    val currentQuestion: Question? = null,
    val questionNumber: Int = 0,
    val totalQuestions: Int = 0,
    val isLoading: Boolean = false,
    val isComplete: Boolean = false
)