package fr.groupe4.bookmyspace_front_mobile.ui.core.composable


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.groupe4.bookmyspace_front_mobile.R
import fr.groupe4.bookmyspace_front_mobile.data.repositories.SpaceRepositoryImpl
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.LargePrimaryButton
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.LargePrimaryButtonText

/**
 * Composable function for a search button used in a search screen.
 *
 * @param onSearchClick Function to be called when the search button is clicked.
 */
@Composable
fun SearchButton(
    onSearchClick: () -> Unit
) {
    val searchScreenTitle = stringResource(id = R.string.search_screen_title)

    LargePrimaryButton(
        onClick = { onSearchClick() }
    ) {
        LargePrimaryButtonText(
            buttonText = searchScreenTitle
        )
    }
}

@Preview(name = "SearchButton")
@Composable
fun SearchButtonPreview() {
    SearchButton {
        Log.d("TAG", "SearchButton")
    }
}