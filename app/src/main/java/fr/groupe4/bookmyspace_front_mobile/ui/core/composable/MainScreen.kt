package fr.groupe4.bookmyspace_front_mobile.ui.core.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import fr.groupe4.bookmyspace_front_mobile.ui.screens.BottomNavGraph
import fr.groupe4.bookmyspace_front_mobile.ui.screens.Screen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable


fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
                BottomBar(
                    navController = navController,
                )

        }
    ) {
        Box(modifier = Modifier.padding(bottom = 56.dp).fillMaxSize().navigationBarsPadding()) {
            BottomNavGraph(navController = navController)
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        Screen.Home,
        Screen.Search,
        Screen.MyBooking,
        Screen.Admin,
        Screen.Profil,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    if (navController.currentDestination?.route != Screen.Start.route) {
        BottomNavigation(
            backgroundColor = Color.White,
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}
@Composable
fun RowScope.AddItem(
    screen: Screen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
//        label = {
//            Text(text = screen.title)
//        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon",
                tint = if (currentDestination?.hierarchy?.any { it.route == screen.route } == true) {
                    MaterialTheme.colors.primary // Couleur sélectionnée
                } else {
                    Color.Black // Couleur non sélectionnée
                }
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}













