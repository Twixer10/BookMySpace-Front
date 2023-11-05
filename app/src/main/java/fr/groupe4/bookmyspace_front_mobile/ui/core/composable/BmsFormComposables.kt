package fr.groupe4.bookmyspace_front_mobile.ui.core.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.groupe4.bookmyspace_front_mobile.R
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.BmsButtonColors

@Composable
fun BmsField(
    value: String,
    onValueChange: (String) -> Unit,
    isSingleLine: Boolean,
    labelText: String,
    style: TextStyle
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = isSingleLine,
        label = {
            Text(
                text = labelText,
                style = style
            )
        },
        modifier = Modifier.fillMaxWidth(),

        )
    Spacer(modifier = Modifier.height(1.dp))
}

@Composable
fun BmsFieldNumber(
    value: String,
    onValueChange: (String) -> Unit,
    isSingleLine: Boolean,
    labelText: String,
    style: TextStyle
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = isSingleLine,
        label = {
            Text(
                text = labelText,
                style = style
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)

    )
    Spacer(modifier = Modifier.height(1.dp))
}

@Composable
fun BmsFieldWithErrorMessage(
    value: String,
    onValueChange: (String) -> Unit,
    isSingleLine: Boolean,
    labelText: String,
    style: TextStyle,
    isActivated: Boolean,
    minimumCharacters: Int = 3
) {
    BmsField(
        value = value,
        onValueChange = onValueChange,
        isSingleLine = isSingleLine,
        labelText = labelText,
        style = style
    )
    if (isActivated) {
        var text = ""
        if (value.isEmpty()) text = stringResource(id = R.string.error_field_is_empty)
        if (value.length < minimumCharacters) text =
            stringResource(id = R.string.error_field_minimum_characters).replace(
                "%i",
                minimumCharacters.toString()
            )
        Text(
            text = text,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                color = Color.Red,
                textAlign = TextAlign.Center,
            ),
        )
    }
}

@Composable
fun BmsButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    color: Color = MaterialTheme.colors.primary,
    icon: ImageVector = Icons.Default.Home,
    enableIcon: Boolean = true,
    iconIsBefore: Boolean = false,
    iconIsAfter: Boolean = false,
    enabled: Boolean = true,
    roundedCornerShape: RoundedCornerShape = RoundedCornerShape(
        topStart = 0.dp,
        topEnd = 25.dp,
        bottomEnd = 0.dp,
        bottomStart = 25.dp
    )
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(50.dp)
            .clip(roundedCornerShape),
        elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp),
        colors = ButtonDefaults.BmsButtonColors,
        enabled = enabled
    ) {
        if (iconIsBefore && enableIcon) {
            Image(
                modifier = Modifier
                    .size(25.dp),
                imageVector = icon,
                contentDescription = "icon",
                colorFilter = if (enabled) ColorFilter.tint(color) else ColorFilter.tint(Color.Gray)
            )
        }
        Text(
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight(500),
            ),
            text = text.uppercase()
        )
        if (iconIsAfter && enableIcon) {
            Image(
                modifier = Modifier
                    .size(25.dp),
                imageVector = icon,
                contentDescription = "icon",
                colorFilter = if (enabled) ColorFilter.tint(color) else ColorFilter.tint(Color.Gray)
            )
        }
    }
}

@Composable
fun BmsDropDownMenu(
    items: List<String>,
    labelText: String,
    style: TextStyle,
    onValueChange: (Int) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableIntStateOf(items.indexOf("")) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colors.primary, MaterialTheme.shapes.small)
    ) {
        Text(
            text = if (selectedIndex == -1) labelText else items[selectedIndex],
            style = style,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { expanded = true })
                .padding(16.dp)
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            items.forEachIndexed { index, item ->
                DropdownMenuItem(
                    modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 16.dp),
                    onClick = {
                        selectedIndex = index
                        expanded = false
                        onValueChange(index)
                    },
                ) {
                    Text(text = item)
                }
                if (index != items.size - 1) {
                    Spacer(
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth()
                            .background(MaterialTheme.colors.primary)
                    )
                }

            }
        }
    }
}


fun Modifier.closeKeyboardOnTap() = composed {
    val focusManager = LocalFocusManager.current
    this.pointerInput(Unit) {
        detectTapGestures(onTap = {
            focusManager.clearFocus()
        })
    }
}