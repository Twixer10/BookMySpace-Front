package fr.groupe4.bookmyspace_front_mobile.ui.core.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.LargeInputReadOnly

/**
 * Composable function for a date input field.
 *
 * @param onDateInputClick Function to be called when the date input field is clicked.
 * @param onDateInputChange Function to be called when the date input field value changes.
 * @param inputValue The current value of the date input field (as a string).
 * @param function A function, which purpose is not clear from the provided code.
 */
@Composable
fun DateInput(
    onDateInputClick: () -> Unit,
    inputValue: String? = null,
    function: () -> Unit
){
    val actualInputValue = inputValue ?: "Date"

    LargeInputReadOnly(
        onInputClick = { onDateInputClick() },
        onValueChange = { },
        inputValue = actualInputValue,
    )
}

@Preview(name = "Date Input")
@Composable
fun DateInputPreview() {
    DateInput(
        onDateInputClick = { },
    ) {

    }
}