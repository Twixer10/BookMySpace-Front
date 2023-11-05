package fr.groupe4.bookmyspace_front_mobile.ui.screens.admin.space.create

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.SubcomposeAsyncImage
import fr.groupe4.bookmyspace_front_mobile.R
import fr.groupe4.bookmyspace_front_mobile.ui.core.composable.BmsButton
import fr.groupe4.bookmyspace_front_mobile.ui.core.composable.BmsDropDownMenu
import fr.groupe4.bookmyspace_front_mobile.ui.core.composable.BmsField
import fr.groupe4.bookmyspace_front_mobile.ui.core.composable.BmsFieldNumber
import fr.groupe4.bookmyspace_front_mobile.ui.core.composable.BmsFieldWithErrorMessage
import fr.groupe4.bookmyspace_front_mobile.ui.core.composable.closeKeyboardOnTap

private typealias UISpace = CreateSpaceState

/**
 * Create space main screen
 * This screen is used to create a new space, it is composed of 6 steps
 * Each step is a composable function
 */
@Composable
fun CreateSpaceScreen() {
    val viewModel: CreateSpaceViewModel = viewModel()
    val state by viewModel.state.collectAsState()

    when (state.currentStep) {
        0 -> GetSpaceName(state, viewModel)
        1 -> GetSpaceImage(state, viewModel)
        2 -> GetDescription(state, viewModel)
        3 -> GetCapacity(state, viewModel)
        4 -> GetSpaceType(state, viewModel)
        5 -> RunCreateSpace(state, viewModel)
        6 -> DisplaySpaceCreated(state, viewModel)
    }
}

/**
 * Step 1 of space creation: Obtaining the space name.
 * This composable allows the user to enter the name of the space.
 *
 * @param state The current state model for space creation.
 * @param viewModel The ViewModel used to manage the creation state.
 */
@Composable
fun GetSpaceName(state: UISpace = UISpace(), viewModel: CreateSpaceViewModel = viewModel()) {
    var spaceName by remember { mutableStateOf("") }
    spaceName = state.spaceName

    Column(
        modifier = Modifier
            .fillMaxSize()
            .closeKeyboardOnTap()
    ) {

        FormHeader(
            subtitle = stringResource(id = R.string.admin_create_space_why_space_name),
            state = state
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            BmsFieldWithErrorMessage(
                value = spaceName,
                onValueChange = {
                    spaceName = it
                    viewModel.setStartControl(true)
                    viewModel.updateSpaceName(it)
                },
                isSingleLine = true,
                labelText = stringResource(id = R.string.admin_create_space_placeholder_space_name),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF1F41BB),
                    textAlign = TextAlign.Center,
                ),
                isActivated = state.startControl,
                minimumCharacters = 3
            )
        }

        FormNavigator(
            canNext = true,
            conditionForNext = (spaceName.length >= 3),
            canPrevious = false,
            conditionForPrevious = false,
        )
    }
}

/**
 * Step 2 of space creation: Obtaining the space image URL.
 * This composable allows the user to enter the URL for the space image.
 *
 * @param state The current state model for space creation.
 * @param viewModel The ViewModel used to manage the creation state.
 */
@Composable
fun GetSpaceImage(state: UISpace = UISpace(), viewModel: CreateSpaceViewModel = viewModel()) {
    var spaceUrl by remember { mutableStateOf("") }
    spaceUrl = state.spaceUrl

    Column(
        modifier = Modifier
            .fillMaxSize()
            .closeKeyboardOnTap()
    ) {

        FormHeader(
            subtitle = stringResource(id = R.string.admin_create_space_why_space_url), state = state
        )
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            BmsField(
                value = spaceUrl,
                onValueChange = {
                    spaceUrl = it
                    viewModel.updateSpaceUrl(it)
                },
                isSingleLine = true,
                labelText = stringResource(id = R.string.admin_create_space_placeholder_space_image_url),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF1F41BB),
                    textAlign = TextAlign.Center,
                ),
            )
        }

        FormNavigator(
            canNext = true,
            conditionForNext = true,
            canPrevious = true,
            conditionForPrevious = true,
            nextStepCanIgnore = (spaceUrl.isEmpty()),
        )
    }
}

/**
 * Step 3 of space creation: Obtaining the space description.
 * This composable allows the user to enter a short description for the space.
 *
 * @param state The current state model for space creation.
 * @param viewModel The ViewModel used to manage the creation state.
 */
@Composable
fun GetDescription(
    state: CreateSpaceState = UISpace(), viewModel: CreateSpaceViewModel = viewModel()
) {
    var spaceShortDescription by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .closeKeyboardOnTap()
    ) {
        FormHeader(
            subtitle = stringResource(id = R.string.admin_create_space_why_space_description).replace(
                "%s", state.spaceName
            ), state = state
        )
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f),
                contentAlignment = Alignment.Center
            ) {
                BmsField(
                    value = spaceShortDescription,
                    onValueChange = {
                        spaceShortDescription = it
                        viewModel.updateSpaceDescription(it)
                    },
                    isSingleLine = false,
                    labelText = stringResource(id = R.string.admin_create_space_placeholder_space_description),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF1F41BB),
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }

        FormNavigator(
            canPrevious = true,
            canNext = true,
            conditionForNext = true,
            conditionForPrevious = true,
            nextStepCanIgnore = (spaceShortDescription.isEmpty())
        )
    }
}

/**
 * Step 4 of space creation: Obtaining the maximum capacity of the space.
 * This composable allows the user to specify the maximum capacity of the space in terms of occupants.
 *
 * @param state The current state model for space creation.
 * @param viewModel The ViewModel used to manage the creation state.
 */
@Composable
fun GetCapacity(
    state: CreateSpaceState = UISpace(), viewModel: CreateSpaceViewModel = viewModel()
) {
    var spaceMaxCapacity by remember { mutableStateOf("") }
    spaceMaxCapacity = state.spaceMaxCapacity.toString()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .closeKeyboardOnTap()
    ) {
        FormHeader(
            subtitle = stringResource(id = R.string.admin_create_space_why_space_max_capacity).replace(
                "%s", state.spaceName
            ), state = state
        )
        Row(

            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f),
                contentAlignment = Alignment.Center
            ) {
                BmsFieldNumber(
                    value = spaceMaxCapacity,
                    onValueChange = {
                        spaceMaxCapacity = onlyNumbers(it)
                        viewModel.updateSpaceMaxCapacity(onlyNumbers(it))
                    },
                    isSingleLine = false,
                    labelText = stringResource(id = R.string.admin_create_space_placeholder_space_max_capacity),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF1F41BB),
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }

        FormNavigator(
            canPrevious = true,
            canNext = true,
            conditionForNext = (spaceMaxCapacity.isNotEmpty() && spaceMaxCapacity.toInt() > 0),
            conditionForPrevious = true,
        )
    }
}

/**
 * Step 5 of space creation: Selecting the space type.
 * This composable allows the user to choose the type of space from a list of options.
 *
 * @param state The current state model for space creation.
 * @param viewModel The ViewModel used to manage the creation state.
 */
@Composable
fun GetSpaceType(
    state: CreateSpaceState = UISpace(), viewModel: CreateSpaceViewModel = viewModel()
) {
    var spaceType by remember { mutableStateOf("test") }
    //TODO: Replace by real list of space type
    val items =
        listOf("test", "Parking\nPerfect for cars", "Office\nPerfect for work", "Item 3", "Item 4")
    spaceType = state.spaceType

    Column(
        modifier = Modifier
            .fillMaxSize()
            .closeKeyboardOnTap()
    ) {
        FormHeader(
            subtitle = stringResource(id = R.string.admin_create_space_why_space_type).replace(
                "%s", state.spaceName
            ), state = state
        )
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f),
                contentAlignment = Alignment.Center
            ) {
                BmsDropDownMenu(
                    items = items,
                    onValueChange = {
                        spaceType = items[it]
                        viewModel.updateSpaceType(items[it])
                    },
                    labelText = stringResource(id = R.string.admin_create_space_placeholder_space_type),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF1F41BB),
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }

        FormNavigator(
            canPrevious = true,
            canNext = true,
            conditionForNext = (spaceType.isNotEmpty()),
            conditionForPrevious = true,
            nextStepLabel = stringResource(id = R.string.admin_create_space_button_finish)
        )

    }
}

/**
 * Step 6 of space creation: Initiating space creation process.
 * This composable initiates the space creation process by triggering the ViewModel
 * to create the space. It typically displays a loading screen while the process is underway.
 * At this moment, there is not implemented yet.
 *
 * @param state The current state model for space creation.
 * @param viewModel The ViewModel used to manage the creation state.
 */
@Composable
fun RunCreateSpace(state: CreateSpaceState = UISpace(), viewModel: CreateSpaceViewModel = viewModel()) {
    //loading screen
    LaunchedEffect(Unit) {
        viewModel.createSpace()
    }
}

/**
 * Step 7 of space creation: Displaying the space creation result.
 * This composable displays the result of the space creation process.
 * It typically displays a success or error message.
 * At this moment, there is not implemented yet.
 *
 * @param state The current state model for space creation.
 * @param viewModel The ViewModel used to manage the creation state.
 */
@Composable
fun DisplaySpaceCreated(state: CreateSpaceState = UISpace(), viewModel: CreateSpaceViewModel = viewModel()) {

}

/**
 * Composable for displaying the header section of the space creation form.
 *
 * This composable displays the header of the space creation form, which typically
 * includes a title, subtitle, and an image representing the space being created.
 *
 * @param title The title to display. Defaults to the title from string resources.
 * @param subtitle The subtitle to display, often providing context or guidance.
 * @param state The current state model for space creation, including the space's URL.
 */
@Composable
fun FormHeader(
    title: String = stringResource(id = R.string.admin_create_space_page_title),
    subtitle: String,
    state: CreateSpaceState
) {
    
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title, style = TextStyle(
                fontSize = 35.sp,
                fontWeight = FontWeight(900),
                color = MaterialTheme.colors.primary,
                textAlign = TextAlign.Center,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = subtitle, style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight(400),
                color = MaterialTheme.colors.primary,
                textAlign = TextAlign.Center,
            )
        )
        Spacer(modifier = Modifier.height(30.dp))

        if (state.spaceUrl.isNotEmpty()) {
            SubcomposeAsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(0.dp, 300.dp)
                    .shadow(
                        4.dp, RoundedCornerShape(
                            topStart = 0.dp, topEnd = 80.dp, bottomEnd = 0.dp, bottomStart = 80.dp
                        )
                    )
                    .clip(
                        RoundedCornerShape(
                            topStart = 0.dp, topEnd = 80.dp, bottomEnd = 0.dp, bottomStart = 80.dp
                        )
                    ), model = state.spaceUrl, contentDescription = null
            )
        } else {
            //TODO: Replace by real image
            Image(
                painter = painterResource(id = R.drawable.content),
                contentDescription = null,
                modifier = Modifier
                    .size(220.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 80.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 80.dp
                        )
                    ),
            )
        }
    }
}

/**
 * Composable for the navigation buttons and controls in the space creation form.
 * This composable displays the navigation buttons and controls, such as "Previous" and "Next" buttons,
 * for the space creation form. It also handles conditions for enabling and disabling these controls.
 *
 * @param previousStepLabel The label for the "Previous" button. Defaults to the label from string resources.
 * @param nextStepLabel The label for the "Next" button. Defaults to the label from string resources.
 * @param canPrevious A boolean indicating whether the "Previous" button is enabled.
 * @param canNext A boolean indicating whether the "Next" button is enabled.
 * @param conditionForNext A boolean indicating the condition for enabling the "Next" button.
 * @param conditionForPrevious A boolean indicating the condition for enabling the "Previous" button.
 * @param viewModel The ViewModel used for managing the space creation process.
 * @param nextStepCanIgnore A boolean indicating whether the next step can be ignored.
 * @param ignoreLabel The label for the "Ignore" button, used when the next step can be ignored.
 */
@Composable
fun FormNavigator(
    previousStepLabel: String = stringResource(id = R.string.admin_create_space_button_previous),
    nextStepLabel: String = stringResource(id = R.string.admin_create_space_button_next),
    canPrevious: Boolean,
    canNext: Boolean,
    conditionForNext: Boolean,
    conditionForPrevious: Boolean,
    viewModel: CreateSpaceViewModel = viewModel(),
    nextStepCanIgnore: Boolean = false,
    ignoreLabel: String = stringResource(id = R.string.admin_create_space_button_ignore)
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Row(
        ) {
            if (canPrevious) {
                BmsButton(
                    modifier = Modifier.weight(
                        1f
                    ),
                    onClick = {
                        viewModel.previousStep()
                    },
                    text = previousStepLabel,
                    color = MaterialTheme.colors.primary,
                    enableIcon = false,
                    enabled = conditionForPrevious,
                    roundedCornerShape = RoundedCornerShape(
                        topStart = 25.dp, topEnd = 0.dp, bottomEnd = 25.dp, bottomStart = 0.dp
                    )
                )

                Spacer(modifier = Modifier.width(16.dp))
            }

            if (canNext) {
                val resourceId = if (nextStepCanIgnore) {
                    ignoreLabel
                } else {
                    nextStepLabel
                }
                BmsButton(
                    modifier = Modifier.weight(
                        1f
                    ),
                    onClick = {
                        viewModel.nextStep()
                    },
                    text = resourceId,
                    color = MaterialTheme.colors.primary,
                    enableIcon = false,
                    enabled = conditionForNext
                )
            }
        }
    }
}

fun onlyNumbers(str: String): String {
    return str.replace(Regex("[^0-9]"), "")
}

@Composable
@Preview
fun SecondStepPreview() {
    GetDescription()
}


@Preview
@Composable
fun FirstStepPreview() {
    GetSpaceName()
}

@Composable
@Preview
fun CreateSpaceScreenPreview() {
    CreateSpaceScreen()
}