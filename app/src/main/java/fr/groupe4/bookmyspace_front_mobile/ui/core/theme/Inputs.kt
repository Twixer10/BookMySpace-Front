package fr.groupe4.bookmyspace_front_mobile.ui.core.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.groupe4.bookmyspace_front_mobile.R
import io.ktor.http.RangeUnits
import io.ktor.http.RangeUnits.None

object InputStyles {
    val largeInputModifier: Modifier = Modifier
        .width(311.dp)
        .height(64.dp)
        .background(color = Color(0xFFF1F4FF), shape = RoundedCornerShape(size = 10.dp))

    val largeInputTextStyle: TextStyle = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.poppinssemibold)),
        fontWeight = FontWeight(500),
        color = Color(0xFF626262),
    )

    val largeNumberInputModifier: Modifier = Modifier
        .width(217.dp)
        .height(64.dp)
        .background(color = Color(0xFFF1F4FF), shape = RoundedCornerShape(size = 0.dp))


    val largeNumberInputTextStyle: TextStyle = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.poppinssemibold)),
        fontWeight = FontWeight(500),
        color = Color(0xFF000000),
        textAlign = TextAlign.Center
    )
}

@Composable
fun LargeInputReadOnly(
    onInputClick: () -> Unit,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = InputStyles.largeInputTextStyle,
    inputValue: String
) {
    TextField(
        value = inputValue,
        onValueChange = { newValue -> onValueChange(newValue) },
        modifier = InputStyles.largeInputModifier.then(
            Modifier.clickable { onInputClick() }
                .then(modifier)
        ),
        textStyle = textStyle,
        enabled = false
    )
}

@Composable
fun LargeNumberInputBase(
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = InputStyles.largeNumberInputTextStyle,
    inputValue: String
) {
    TextField(
        value = inputValue,
        onValueChange = onValueChange,
        modifier = InputStyles.largeNumberInputModifier.then(modifier),
        enabled = false,
        textStyle = textStyle
    )
}

/*Preview*/

@Preview
@Composable
fun LargeInputReadOnlyPreview() {
    LargeInputReadOnly(
        onInputClick = {},
        onValueChange = {},
        inputValue = "Text"
    )
}

@Preview
@Composable
fun LargeNumberInputBasePreview() {
    LargeNumberInputBase(
        inputValue = "0",
        onValueChange = {}
    )
}