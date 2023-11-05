package fr.groupe4.bookmyspace_front_mobile.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import fr.groupe4.bookmyspace_front_mobile.ui.screens.admin.AdminScreen
import fr.groupe4.bookmyspace_front_mobile.ui.screens.admin.space.create.CreateSpaceScreen
import fr.groupe4.bookmyspace_front_mobile.ui.screens.home.HomeScreen
import fr.groupe4.bookmyspace_front_mobile.ui.screens.reservation.ReservationScreen
import fr.groupe4.bookmyspace_front_mobile.ui.screens.search.SearchScreen
import fr.groupe4.bookmyspace_front_mobile.ui.screens.spaceDetailReservation.spaceDetailReservation
import fr.groupe4.bookmyspace_front_mobile.ui.screens.startScreen.StartScreen


sealed class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector,
    val composable: @Composable (NavController, Any?) -> Unit,
    val arguments: List<NamedNavArgument> = emptyList()
) {

    object Home : Screen(
        route = "homes",
        title = "Home",
        icon = Icons.Default.Home,
        composable = { it, _ ->
            HomeScreen(it)
        }
    )

    object Search : Screen(
        route = "search",
        title = "Search",
        icon = Icons.Default.Search,
        composable = { it, _ -> SearchScreen(it) }
    )

    object MyBooking : Screen(
        route = "mybooking",
        title = "MyBooking",
        icon = Icons.Default.DateRange,
        composable = { it, _ -> MyBookingScreen() }
    )

    object Admin : Screen(
        route = "admin",
        title = "Admin",
        icon = Icons.Default.Lock,
        composable = { it, _ -> AdminScreen(it) }
    )

    object Profil : Screen(
        route = "profil",
        title = "Profil",
        icon = Icons.Default.AccountCircle,
        composable = { it, _ -> ProfilScreen() }
    )

    object CreateSpace : Screen(
        route = "createSpace",
        title = "CreateSpace",
        icon = Icons.Default.AccountCircle,
        composable = { it, _ -> CreateSpaceScreen() }
    )

    object Start : Screen(
        route = "start",
        title = "Start",
        icon = Icons.Default.Home,
        composable = { it, _ -> StartScreen(it) }
    )

    object SpaceDetail : Screen(
        route = "spacedetail/{id}",
        title = "Space Detail",
        icon = Icons.Default.Build,
        composable = { it, arguments ->
            val spaceId = it.currentBackStackEntry?.arguments?.getString("id") ?: "0"
            spaceDetailReservation(it, IdSpace = spaceId!!.toInt())
        },
        arguments = listOf(navArgument("id") { type = NavType.StringType })
    )

    object Reservation : Screen(
        route = "reservation/{id}",
        title = "reservation",
        icon = Icons.Default.Home,
        composable = { it, argument ->
            val spaceId = it.currentBackStackEntry?.arguments?.getString("id") ?: "0"
            ReservationScreen(it, IdSpace = spaceId!!.toInt()) }
    )

    companion object {
        var screens: List<Screen>? = null
        fun init() {
            screens = listOf(
                Start,
                Home,
                Search,
                MyBooking,
                Admin,
                Profil,
                CreateSpace,
                SpaceDetail,
                Reservation

            )
        }
    }
}
