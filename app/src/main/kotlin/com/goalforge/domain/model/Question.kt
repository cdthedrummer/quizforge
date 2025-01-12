package com.goalforge.domain.model

data class Question(
    val id: String,
    val text: String,
    val attributeWeights: Map<Attribute, Int>,
    val options: List<Answer>,
    val category: QuestionCategory
)

data class Answer(
    val id: String,
    val text: String,
    val score: Int
)

enum class QuestionCategory {
    PHYSICAL,
    MENTAL,
    SOCIAL,
    HEALTH,
    CREATIVE,
    PROFESSIONAL
}