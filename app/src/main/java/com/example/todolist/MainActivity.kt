package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.feature.navigation.NavGraph
import com.example.feature.screen.CreateNewTaskScreen
import com.example.feature.screen.HomeScreen
import com.example.todolist.ui.theme.TodoListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            TodoListTheme {
                NavHost(
                    navController = navController,
                    startDestination = NavGraph.HOME.name,
                ) {
                    composable(route = NavGraph.HOME.name) {
                        HomeScreen {
                            navController.navigate(NavGraph.CREATE_TASK.name)
                        }
                    }
                    composable(
                        route = NavGraph.CREATE_TASK.name,
                        enterTransition = {
                            fadeIn(
                                animationSpec = tween(
                                    300, easing = LinearEasing
                                )
                            ) + slideIntoContainer(
                                animationSpec = tween(300, easing = EaseIn),
                                towards = AnimatedContentTransitionScope.SlideDirection.Start
                            )
                        },
                        exitTransition = {
                            fadeOut(
                                animationSpec = tween(
                                    300, easing = LinearEasing
                                )
                            ) + slideOutOfContainer(
                                animationSpec = tween(300, easing = EaseOut),
                                towards = AnimatedContentTransitionScope.SlideDirection.End
                            )
                        }
                    ) {
                        CreateNewTaskScreen()
                    }
                }
            }
        }
    }
}
