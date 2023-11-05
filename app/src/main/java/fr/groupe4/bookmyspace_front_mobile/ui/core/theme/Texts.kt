package fr.groupe4.bookmyspace_front_mobile.ui.core.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.groupe4.bookmyspace_front_mobile.R

object TextStyles {
    val largePrimaryButtonTextStyle: TextStyle = TextStyle(
        fontSize = 20.sp,
        fontFamily = FontFamily(Font(R.font.poppinssemibold)),
        fontWeight = FontWeight(600),
        color = Color(0xFFFFFFFF),
        textAlign = TextAlign.Center,
    )

    val smallPrimaryButtonTextStyle: TextStyle = TextStyle(
        fontSize = 15.sp,
        fontFamily = FontFamily(Font(R.font.poppinssemibold)),
        fontWeight = FontWeight(600),
        color = Color(0xFFFFFFFF),
        textAlign = TextAlign.Center,
    )


    val largePrimaryButtonTextModifier: Modifier = Modifier
        .width(109.dp)
        .height(30.dp)

    val smallPrimaryButtonTextModifier: Modifier = Modifier
        .width(250.dp)
        .height(25.dp)

    val screenTitleTextStyle: TextStyle = TextStyle(
        fontSize = 30.sp,
        fontFamily = FontFamily(Font(R.font.poppinssemibold)),
        fontWeight = FontWeight(700),
        color = Color(0xFF1F41BB),
        textAlign = TextAlign.Center,
    )

    val screenTitleTextModifier: Modifier = Modifier
        .width(311.dp)
        .height(90.dp)

    val basicTextStyle: TextStyle = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.poppinssemibold)),
        fontWeight = FontWeight(500),
        color = Color(0xFF626262),
        textAlign = TextAlign.Center,
    )

    val basicTextModifier: Modifier = Modifier
        .height(24.dp)
}

@Composable
fun SmallPrimaryButtonText(
    modifier: Modifier = TextStyles.smallPrimaryButtonTextModifier,
    textStyle: TextStyle = TextStyles.smallPrimaryButtonTextStyle,
    buttonText: String
) {
    Text(
        modifier = modifier,
        style = textStyle,
        text = buttonText,
    )
}
@Composable
fun LargePrimaryButtonText(
    modifier: Modifier = TextStyles.largePrimaryButtonTextModifier,
    textStyle: TextStyle = TextStyles.largePrimaryButtonTextStyle,
    buttonText: String
) {
    Text(
        modifier = modifier,
        style = textStyle,
        text = buttonText,
    )
}

@Composable
fun ScreenLargeTitleText(
    modifier: Modifier = TextStyles.screenTitleTextModifier,
    textStyle: TextStyle = TextStyles.screenTitleTextStyle,
    buttonText: String
) {
    Text(
        modifier = modifier,
        style = textStyle,
        text = buttonText,
    )
}

@Composable
fun BasicText(
    modifier: Modifier = TextStyles.basicTextModifier,
    textStyle: TextStyle = TextStyles.basicTextStyle,
    buttonText: String
) {
    Text(
        modifier = modifier,
        style = textStyle,
        text = buttonText
    )
}

@Composable
fun Title(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        style = TextStyle(
            fontSize = 28.sp,
            fontWeight = FontWeight(700),
            color = Color(0xFF1F41BB)
        ),
        modifier = Modifier
            .padding(16.dp)
            .then(modifier)
    )
}