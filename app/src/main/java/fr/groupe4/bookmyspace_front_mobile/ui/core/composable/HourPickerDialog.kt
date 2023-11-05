package fr.groupe4.bookmyspace_front_mobile.ui.core.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.commandiron.wheel_picker_compose.WheelTimePicker
import com.commandiron.wheel_picker_compose.core.WheelPickerDefaults
import java.time.LocalTime

/**
 * Composable function for a dialog that allows picking a time (hour).
 *
 * @param onDismiss Function to be called when the dialog is dismissed.
 * @param onValidClick Function to be called when the "OK" button is clicked, passing the selected time.
 * @param hourState The initial time (hour) to be displayed in the time picker dialog.
 */
@Composable
fun HourPickerDialog(
    onDismiss: () -> Unit,
    onValidClick: (LocalTime) -> Unit,
    hourState: LocalTime?
) {
    var selectedHour by remember { mutableStateOf(hourState ?: LocalTime.now()) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray.copy(alpha = 0.5f))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .background(Color.White)
        ) {
            Dialog(
                onDismissRequest = { onDismiss() },
            ) {
                Card (
                    Modifier
                        .width(145.dp)
                        .height(175.dp)
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(size = 12.dp)
                        )
                ){
                    var wheelHourPickerState by remember { mutableStateOf(selectedHour) }

                    WheelTimePicker(
                        startTime = LocalTime.now(),
                        minTime = LocalTime.now(),
                        selectorProperties = WheelPickerDefaults.selectorProperties(

                        ),
                        onSnappedTime = {wheelHourPickerState = it}
                    )

                    Button(
                        onClick = {
                            selectedHour = wheelHourPickerState
                            onValidClick(selectedHour)
                        },
                    ) {
                        Text(text = "Ok")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HourPickerDialogPreview(){
    HourPickerDialog(
        onDismiss = { },
        onValidClick = { },
        hourState = LocalTime.now())
}