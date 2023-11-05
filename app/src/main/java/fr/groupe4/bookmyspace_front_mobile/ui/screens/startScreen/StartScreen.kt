package fr.groupe4.bookmyspace_front_mobile.ui.screens.startScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import fr.groupe4.bookmyspace_front_mobile.R
import fr.groupe4.bookmyspace_front_mobile.ui.core.composable.PreviewContent
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.Blue
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.LargePrimaryButton
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.LargePrimaryButtonText
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.SmallPrimaryButton
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.SmallPrimaryButtonText
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.White
import fr.groupe4.bookmyspace_front_mobile.ui.screens.startScreen.StartScreenViewModel

/**
 * Composable function for displaying the start screen of the application.
 *
 * @param navController The navigation controller used for navigating between screens. Nullable.
 *                       Make sure the navigation controller is properly initialized.
 */
@Composable
fun StartScreen(navController: NavController? = null) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(id = R.drawable.imgstart),
            contentDescription = null,
            modifier = Modifier
                .width(363.dp)
                .height(420.dp)
                .padding(top = 15.56946.dp, bottom = 22.99997.dp),
            contentScale = ContentScale.FillBounds
        )

        Text(
            modifier = Modifier
                .width(343.dp)
                .height(106.dp),
            text = "Bienvenue sur BookMySpace",
            style = TextStyle(
                fontSize = 35.sp,
                fontWeight = FontWeight(600),
                color = Blue,
                textAlign = TextAlign.Center,
            )
        )
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SmallPrimaryButton(onClick = {
                navController?.navigate("homes")
            }) {
                SmallPrimaryButtonText(buttonText = "Acceder à la page d'accueil")
                
            }
            }
        }
    }


@Preview
@Composable
private fun StartScreenPreview() = PreviewContent {
    StartScreen()
}