package fr.groupe4.bookmyspace_front_mobile.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import fr.groupe4.bookmyspace_front_mobile.theme.Carousel
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.CustomSearchButton
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.Title

/**
 * Composable for the Home screen.
 *
 * @param NavController NavController for navigation.
 */
@Composable
fun HomeScreen(NavController: NavController? = null) {
    val viewModel: HomeViewModel = viewModel()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(true) {
        viewModel.getBooking()
    }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(40.dp),
                modifier = Modifier.fillMaxWidth(),
            ) {
                Spacer(modifier = Modifier.weight(1f))
                CustomSearchButton(onClick = {
                })
            }

            Title(
                title = "My Reservations ->",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            state.bookingResponse?.let {
                Carousel(
                    images = it,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    navController = NavController
                )
            }

            Title(
                title = "Nearby Free Spaces ->",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            state.bookingResponse?.let {
                Carousel(
                    images = it,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    navController = NavController
                )
            }
        }
    }

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}
