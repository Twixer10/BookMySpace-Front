package fr.groupe4.bookmyspace_front_mobile.ui.core.composable

import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.LargeInputReadOnly

/**
 * Composable function for an hour input field.
 *
 * @param onHourInputClick Function to be called when the hour input field is clicked.
 * @param onHourInputChange Function to be called when the hour input field value changes.
 * @param inputValue The current value of the hour input field (as a string).
 * @param inputText The default text displayed in the input field.
 * @param modifier Modifier to customize the appearance and behavior of the input field.
 */
@Composable
fun HourInput(
    onHourInputClick: () -> Unit,
    inputValue: String? = null,
    inputText: String = "Heure",
    modifier: Modifier = Modifier,
    function: () -> Unit
){
    val actualInputValue = inputValue ?: inputText

    LargeInputReadOnly(
        onInputClick = {
            onHourInputClick()
        },
        onValueChange = { },
        inputValue = actualInputValue,
        modifier = Modifier.then(modifier)
    )
}

@Preview(name = "Hour Input")
@Composable
fun HourInputPreview() {
    HourInput(
        onHourInputClick = { },
    ) {

    }
}

@Preview(name = "Hour Input With Name")
@Composable
fun HourInputPreviewName() {
    HourInput(
        onHourInputClick = { },
        inputValue = "Heure de debut"
    ) {

    }
}