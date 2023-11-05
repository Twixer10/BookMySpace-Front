package fr.groupe4.bookmyspace_front_mobile.ui.core.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.LargeInputReadOnly
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.LargeNumberInputBase
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.LeftMinusButton
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.RightPlusButton

/**
 * Custom Compose component for numeric input with addition and subtraction buttons.
 *
 * @param onPlusClick Function called when the "+" (addition) button is clicked.
 * @param onMinusClick Function called when the "-" (subtraction) button is clicked.
 * @param onValueChange Function called when the input value is modified.
 * @param inputValue The input numeric value (as a string).
 */
@Composable
fun NumberInput(
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    onValueChange: () -> Unit,
    inputValue: String
){
    Box(modifier = Modifier.width(311.dp)){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            RightPlusButton(
                onClick = { onPlusClick() },
            )

            LargeNumberInputBase(
                inputValue = inputValue,
                onValueChange = { onValueChange() },
                modifier = Modifier.then(Modifier.weight(1f))
            )

            LeftMinusButton(
                onClick = { onMinusClick() },
            )
        }
    }
}

@Preview(name = "Number Input")
@Composable
fun NumberInputPreview() {
    NumberInput(
        onPlusClick = { },
        onMinusClick = { },
        onValueChange = { },
        inputValue = "1"
    )
}