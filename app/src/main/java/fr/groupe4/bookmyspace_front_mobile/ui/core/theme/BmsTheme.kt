package fr.groupe4.bookmyspace_front_mobile.ui.core.theme

import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Disabled = Color(0xFFACACAC)


val ButtonDefaults.BmsButtonColors: ButtonColors
    @Composable get() = ButtonDefaults.buttonColors(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        disabledBackgroundColor = Color.Gray,
        disabledContentColor = Color.DarkGray
    )

