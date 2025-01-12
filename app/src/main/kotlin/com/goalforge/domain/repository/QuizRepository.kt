package com.goalforge.domain.repository

import com.goalforge.domain.model.Question
import com.goalforge.domain.model.QuizResult

interface QuizRepository {
    suspend fun getQuestions(): List<Question>
    suspend fun saveResult(result: QuizResult)
    suspend fun getLastResult(): QuizResult?
    suspend fun getAllResults(): List<QuizResult>
}