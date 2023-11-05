package fr.groupe4.bookmyspace_front_mobile.ui.screens.search


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import fr.groupe4.bookmyspace_front_mobile.R
import fr.groupe4.bookmyspace_front_mobile.ui.core.composable.DateInput
import fr.groupe4.bookmyspace_front_mobile.ui.core.composable.DatePickerDialog
import fr.groupe4.bookmyspace_front_mobile.ui.core.composable.HourInput
import fr.groupe4.bookmyspace_front_mobile.ui.core.composable.HourPickerDialog
import fr.groupe4.bookmyspace_front_mobile.ui.core.composable.NumberInput
import fr.groupe4.bookmyspace_front_mobile.ui.core.composable.PreviewContent
import fr.groupe4.bookmyspace_front_mobile.ui.core.composable.SearchButton
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.BasicText
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.ScreenLargeTitleText

private typealias UIState = SearchState

/**
 * Composable function for the search screen that displays different content based on the current step.
 *
 * @param navController The navigation controller used for navigating between screens.
 */
@Composable
fun SearchScreen(navController: NavController? = null) {
    val viewModel: SearchViewModel = viewModel()
    val state by viewModel.state.collectAsState()

    when (state.currentStep) {
        0 -> SearchContent(
            state = state,
            onAction = viewModel::handleActions
        )
        1 -> SearchResult(
            state = state,
            onAction = viewModel::handleActions,
            navController = navController
        )
    }
}

/**
 * Composable function for the content of a search screen.
 *
 * @param state The UI state for the search screen.
 * @param onAction A function to handle user actions (e.g., button clicks).
 */
@Composable
private fun SearchContent(
    state: UIState = UIState(),
    onAction: (SearchAction) -> Unit
) {
    val searchScreenTitle = stringResource(id = R.string.search_screen_title)
    val searchScreenPeopleNumber = stringResource(id = R.string.search_people_number)

    var showDatePickerDialog by remember { mutableStateOf(false) }
    var showStartHourPickerDialog by remember { mutableStateOf(false) }
    var showEndHourPickerDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column (
            Modifier
                .padding(50.dp, 50.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ScreenLargeTitleText(
                buttonText = searchScreenTitle
            )

            DateInput(
                onDateInputClick = { showDatePickerDialog = true },
                inputValue = state.date?.toString() ?: null
            ) {

            }

            HourInput(
                onHourInputClick = { showStartHourPickerDialog = true },
                inputValue = state.startHour?.toString() ?: null,
                inputText = "Heure de debut"
            ) {

            }

            HourInput(
                onHourInputClick = { showEndHourPickerDialog = true },
                inputValue = state.endHour?.toString() ?: null,
                inputText = "Heure de fin"
            ) {

            }

            BasicText(
                buttonText = searchScreenPeopleNumber
            )

            NumberInput(
                onPlusClick = { onAction(SearchAction.IncrementPeopleNb) },
                onMinusClick = { onAction(SearchAction.DecrementPeopleNb) },
                onValueChange = { state.capacity.toString() },
                inputValue = state.capacity.toString()
            )

            SearchButton {
                onAction(SearchAction.Search)
            }
        }
    }

    if (showDatePickerDialog) {
        DatePickerDialog(
            onDismiss = { showDatePickerDialog = false },
            onValidClick = { selectedDate ->
                onAction(SearchAction.UpdateDate(selectedDate))
                showDatePickerDialog = false
            },
            dateState = state.date
        )
    }

    if (showStartHourPickerDialog) {
        HourPickerDialog(
            onDismiss = { showStartHourPickerDialog = false },
            onValidClick = { selectHour ->
                onAction(SearchAction.UpdateStartHour(selectHour))
                showStartHourPickerDialog = false
            },
            hourState = state.startHour
        )
    }

    if (showEndHourPickerDialog) {
        HourPickerDialog(
            onDismiss = { showEndHourPickerDialog = false },
            onValidClick = { selectHour ->
                onAction(SearchAction.UpdateEndHour(selectHour))
                showEndHourPickerDialog = false
            },
            hourState = state.startHour
        )
    }
}

/**
 * Composable function for displaying search results.
 *
 * @param state The UI state for the search results.
 * @param onAction A function to handle user actions (e.g., navigation or interactions with results).
 * @param navController The navigation controller used for navigation between screens.
 */
@Composable
private fun SearchResult(
    state: UIState = UIState(),
    onAction: (SearchAction) -> Unit,
    navController: NavController?
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
        ){
            if(state.searchResponse === null){
                Text(text = "Aucun Resultat")
            }else{
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(state.searchResponse) { carouselItem ->
                        Row(
                            modifier = Modifier
                                .width(270.dp)
                                .clip(MaterialTheme.shapes.medium),
                            horizontalArrangement = Arrangement.Center // Pour placer le texte en haut
                        ) {
                            Column(
                                Modifier.
                                align(Alignment.CenterVertically)
                            ) {
                                Text(
                                    text = carouselItem.name,
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .fillMaxWidth(),
                                    color = Color.Black,
                                    fontSize = 20.sp
                                )
                                SubcomposeAsyncImage(
                                    model = carouselItem.url,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(270.dp)
                                        .height(270.dp)
                                        .clickable {
                                            navController?.navigate(
                                                "spacedetail/${carouselItem.idSpace}"
                                            )
                                        }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun SearchPreview() = PreviewContent {
    SearchContent(
        onAction = {}
    )
}

@Preview
@Composable
private fun SearchResultPreview() = PreviewContent {
    SearchResult(
        onAction = {},
        navController = null
    )
}