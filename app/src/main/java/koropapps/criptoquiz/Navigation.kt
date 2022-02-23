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
import koropapps.criptoquiz.feature.decription.ui.Description
import koropapps.criptoquiz.feature.quizzes.ui.Quizzes
import kotlinx.coroutines.InternalCoroutinesApi

const val QUIZ_NAME_ARG = "EXERCISE_NAME_ARG"

sealed class Screen(val route: String) {
    object Quizzes : Screen("Quizzes")
}

private sealed class LeafScreen(
    private val route: String,
) {
    fun createRoute(root: Screen) = "${root.route}/$route"

    object Quizzes : LeafScreen("Quizzes")

    object Description : LeafScreen("Description/{${QUIZ_NAME_ARG}}") {
        fun createRoute(root: Screen, quizName: QuizName): String {
            return "${root.route}/Description/$quizName"
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
        startDestination = LeafScreen.Quizzes.createRoute(Screen.Quizzes),
    ) {
        addQuizzes(navController, Screen.Quizzes)
        addDescription(navController, Screen.Quizzes)
    }
}

@ExperimentalMaterialApi
private fun NavGraphBuilder.addQuizzes(
    navController: NavController,
    root: Screen,
) {
    composable(LeafScreen.Quizzes.createRoute(root)) {
        Quizzes(openQuiz = {})
    }
}


@ExperimentalMaterialApi
private fun NavGraphBuilder.addDescription(
    navController: NavController,
    root: Screen,
) {
    composable(
        LeafScreen.Description.createRoute(root), arguments = listOf(
            navArgument(QUIZ_NAME_ARG) {
                type = NavType.EnumType(QuizName::class.java)
            })
    ) { backStackEntry ->
        val quizName = backStackEntry.arguments?.getSerializable(QUIZ_NAME_ARG) as QuizName

        Description(openQuiz = {}, quizName = quizName)
    }
}

