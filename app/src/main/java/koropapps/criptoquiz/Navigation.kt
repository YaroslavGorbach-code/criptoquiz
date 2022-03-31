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
const val NEED_RELOAD_QUIZ_ARG = "NEED_RELOAD_QUIZ_ARG"

sealed class Screen(val route: String) {
    object Quizzes : Screen("Quizzes")
}

private sealed class LeafScreen(
    private val route: String,
) {
    fun createRoute(root: Screen) = "${root.route}/$route"

    object QuizzesList : LeafScreen("QuizzesList")

    object Result : LeafScreen("Result/{${QUIZ_NAME_ARG}}") {
        fun createRoute(root: Screen, quizName: QuizName): String {
            return "${root.route}/Result/$quizName"
        }
    }

    object Quiz : LeafScreen("Quiz/{${QUIZ_NAME_ARG}}/{${NEED_RELOAD_QUIZ_ARG}}") {
        fun createRoute(root: Screen, quizName: QuizName, needReloadQuiz: Boolean = false): String {
            return "${root.route}/Quiz/$quizName/$needReloadQuiz"
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
            }, navArgument(NEED_RELOAD_QUIZ_ARG) {
                type = NavType.BoolType
            })
    ) {
        Quiz(onBack = { navController.popBackStack() },
            onResult = { name ->
                navController.popBackStack()
                navController.navigate(LeafScreen.Result.createRoute(root, name)) {
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
    composable(
        LeafScreen.Result.createRoute(root), arguments = listOf(
            navArgument(QUIZ_NAME_ARG) {
                type = NavType.EnumType(QuizName::class.java)
            })
    ) {
        Result(onBack = {
            navController.popBackStack()
        }, onTryAgain = { name ->
            navController.navigate(
                LeafScreen.Quiz.createRoute(
                    root = root,
                    quizName = name,
                    needReloadQuiz = true
                )
            ) {
                popUpTo(LeafScreen.QuizzesList.createRoute(root = root)) {
                    inclusive = false
                }
            }
        })
    }
}
