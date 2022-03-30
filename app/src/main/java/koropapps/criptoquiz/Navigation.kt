package koropapps.criptoquiz

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import koropapps.criptoquiz.data.quizzes.local.model.QuizName
import koropapps.criptoquiz.feature.quiz.ui.Quiz
import koropapps.criptoquiz.feature.quizzes.ui.Quizzes
import koropapps.criptoquiz.feature.result.ui.Result
import kotlinx.coroutines.InternalCoroutinesApi

const val QUIZ_NAME_ARG = "EXERCISE_NAME_ARG"

sealed class Screen(val route: String) {
    object Quizzes : Screen("Quizzes")
}

private sealed class LeafScreen(
    private val route: String,
) {
    fun createRoute(root: Screen) = "${root.route}/$route"

    object QuizzesList : LeafScreen("QuizzesList")

    object Result : LeafScreen("Result")

    object Quiz : LeafScreen("Quiz/{${QUIZ_NAME_ARG}}") {
        fun createRoute(root: Screen, quizName: QuizName): String {
            return "${root.route}/Quiz/$quizName"
        }
    }
}

@InternalCoroutinesApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
internal fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Quizzes.route,
        modifier = modifier,
    ) {
        addQuizzesTopLevel(navController)
    }
}

@InternalCoroutinesApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
private fun NavGraphBuilder.addQuizzesTopLevel(
    navController: NavController,
) {
    navigation(
        route = Screen.Quizzes.route,
        startDestination = LeafScreen.QuizzesList.createRoute(Screen.Quizzes),
    ) {
        addQuizzes(navController, Screen.Quizzes)
        addQuiz(navController, Screen.Quizzes)
        addResult(navController, Screen.Quizzes)
    }
}

@ExperimentalMaterialApi
private fun NavGraphBuilder.addQuizzes(
    navController: NavController,
    root: Screen,
) {
    composable(LeafScreen.QuizzesList.createRoute(root)) {
        Quizzes(openDescription = { quiz ->
            navController.navigate(
                LeafScreen.Quiz.createRoute(
                    root = root,
                    quizName = quiz.name
                )
            )
        })
    }
}

@ExperimentalMaterialApi
private fun NavGraphBuilder.addQuiz(
    navController: NavController,
    root: Screen,
) {
    composable(
        LeafScreen.Quiz.createRoute(root), arguments = listOf(
            navArgument(QUIZ_NAME_ARG) {
                type = NavType.EnumType(QuizName::class.java)
            })
    ) {
        Quiz(onBack = { navController.popBackStack() },
            onResult = {
                navController.navigate(LeafScreen.Result.createRoute(root)) {
                    popUpTo(LeafScreen.QuizzesList.createRoute(root = root)) {
                        inclusive = false
                    }
                }
            }
        )
    }
}

@InternalCoroutinesApi
@ExperimentalMaterialApi
private fun NavGraphBuilder.addResult(
    navController: NavController,
    root: Screen,
) {
    composable(LeafScreen.Result.createRoute(root), arguments = emptyList()) {
        Result(onBack = {
            navController.popBackStack()
        }, onTryAgain = {

        })
    }
}
