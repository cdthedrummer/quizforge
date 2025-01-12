package com.goalforge.domain.model

data class QuizResult(
    val attributeScores: Map<Attribute, AttributeScore>,
    val timestamp: Long = System.currentTimeMillis(),
    val recommendations: List<Recommendation> = emptyList()
)

data class AttributeScore(
    val value: Int,
    val previousValue: Int? = null,
    val details: List<String> = emptyList()
) {
    val growth: Int? = previousValue?.let { value - it }
}

data class Recommendation(
    val title: String,
    val description: String,
    val primaryAttribute: Attribute,
    val secondaryAttributes: List<Attribute> = emptyList(),
    val difficulty: Int, // 1-3
    val timeInvestment: TimeInvestment,
    val type: RecommendationType
)

enum class TimeInvestment {
    QUICK, // < 1 hour
    SHORT, // 1-3 hours
    MEDIUM, // 3-8 hours
    LONG, // > 8 hours
    ONGOING // Regular commitment
}

enum class RecommendationType {
    COURSE,
    ACTIVITY,
    PRACTICE,
    WORKSHOP,
    MENTOR,
    SELF_STUDY
}