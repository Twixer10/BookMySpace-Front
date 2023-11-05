package fr.groupe4.bookmyspace_front_mobile.ui.core.composable

import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.commandiron.wheel_picker_compose.WheelDatePicker
import com.commandiron.wheel_picker_compose.core.WheelPickerDefaults
import java.time.LocalDate

/**
 * Composable function for a date picker dialog.
 *
 * @param onDismiss Function to be called when the dialog is dismissed.
 * @param onValidClick Function to be called when the "OK" button is clicked, passing the selected date.
 * @param dateState The initial date to be displayed in the date picker dialog.
 */
@Composable
fun DatePickerDialog(
    onDismiss: () -> Unit,
    onValidClick: (LocalDate) -> Unit,
    dateState: LocalDate?
) {
    var selectedDate by remember { mutableStateOf(dateState ?: LocalDate.now()) }

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
                        .width(250.dp)
                        .height(175.dp)
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(size = 12.dp)
                        )
                ){
                    var wheelDatePickerState by remember { mutableStateOf(selectedDate) }

                    WheelDatePicker(
                        startDate = LocalDate.now(),
                        minDate = LocalDate.now(),
                        selectorProperties = WheelPickerDefaults.selectorProperties(

                        ),
                        onSnappedDate = {wheelDatePickerState = it}
                    )

                    Button(
                        onClick = {
                            selectedDate = wheelDatePickerState
                            onValidClick(selectedDate)
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
fun DatePickerDialogPreview(){
    DatePickerDialog(
        onDismiss = { },
        onValidClick = { },
        dateState = LocalDate.now()
    )
}