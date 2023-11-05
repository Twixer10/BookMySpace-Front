package fr.groupe4.bookmyspace_front_mobile.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

/**
 * Composable function for defining the bottom navigation graph.
 *
 * @param navController The NavHostController for navigation.
 */
@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Start.route
    ) {
        // Iterate through the defined screens and set up composables for each.
        Screen.screens?.forEach() { screen ->
            composable(route = screen.route, arguments = screen.arguments) {
                screen.composable(navController, it.arguments)
            }
        }
    }
}
