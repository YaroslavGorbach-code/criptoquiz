package koropapps.criptoquiz

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import kotlinx.coroutines.InternalCoroutinesApi

sealed class Screen(val route: String) {
    object Quizzes : Screen("Quizzes")
}

private sealed class LeafScreen(
    private val route: String,
) {
    fun createRoute(root: Screen) = "${root.route}/$route"
    object Quizzes : LeafScreen("Quizzes")
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

    }
}

@ExperimentalMaterialApi
private fun NavGraphBuilder.addQuizzes(
    navController: NavController,
    root: Screen,
) {
    composable(LeafScreen.Quizzes.createRoute(root)) {
//        Exercises(openDescription = { exerciseName ->
//            navController.navigate(
//                LeafScreen.ShowDescription.createRoute(
//                    root = root,
//                    exerciseName = exerciseName
//                )
//            )
//        })
    }
}
