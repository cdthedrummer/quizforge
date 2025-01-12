package com.goalforge

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.goalforge.ui.quiz.QuizScreen

@Composable
fun GoalForgeApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "quiz") {
        composable("quiz") {
            QuizScreen(
                onQuizComplete = {
                    // TODO: Navigate to results screen
                }
            )
        }
        // TODO: Add results screen route
    }
}