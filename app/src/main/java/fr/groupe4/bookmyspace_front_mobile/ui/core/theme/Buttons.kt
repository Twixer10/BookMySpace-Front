package fr.groupe4.bookmyspace_front_mobile.ui.core.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.groupe4.bookmyspace_front_mobile.R

object ButtonStyles {

    val smallPrimaryButtonModifier: Modifier = Modifier
        .shadow(elevation = 20.dp, spotColor = Color(0xFFCBD6FF), ambientColor = Color(0xFFCBD6FF))
        .width(311.dp)
        .height(60.dp)
        .background(color = Color(0xFF1F41BB), shape = RoundedCornerShape(size = 10.dp))
        .padding(start = 20.dp, end = 20.dp)

    val largePrimaryButtonModifier: Modifier = Modifier
        .shadow(elevation = 20.dp, spotColor = Color(0xFFCBD6FF), ambientColor = Color(0xFFCBD6FF))
        .width(311.dp)
        .height(60.dp)
        .background(color = Color(0xFF1F41BB), shape = RoundedCornerShape(size = 10.dp))
        .padding(start = 20.dp, end = 20.dp)

    val largePrimaryButtonColor: Color = Color(0xFF1F41BB)

    val smallPrimaryButtonColor: Color = Color(0xFF1F41BB)

    val plusButtonNumberInputModifier: Modifier = Modifier
        .width(46.65.dp)
        .height(64.dp)
        .background(
            color = Color(0xFF1F41BB), shape = RoundedCornerShape(
                topStart = 10.dp,
                topEnd = 0.dp,
                bottomStart = 10.dp,
                bottomEnd = 0.dp
            )
        )

    val minusButtonNumberInputModifier: Modifier = Modifier
        .width(46.65.dp)
        .height(64.dp)
        .background(
            color = Color(0xFF1F41BB), shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 10.dp,
                bottomStart = 0.dp,
                bottomEnd = 10.dp
            )
        )
}

@Composable
fun SmallPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        contentColor = ButtonStyles.smallPrimaryButtonColor,
        containerColor = ButtonStyles.smallPrimaryButtonColor
    ),
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = ButtonStyles.smallPrimaryButtonModifier.then(modifier),
        colors = colors
    ) {
        content()
    }
}
@Composable
fun LargePrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        contentColor = ButtonStyles.largePrimaryButtonColor,
        containerColor = ButtonStyles.largePrimaryButtonColor
    ),
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = ButtonStyles.largePrimaryButtonModifier.then(modifier),
        colors = colors
    ) {
        content()
    }
}

@Composable
fun RightPlusButton(
    onClick: () -> Unit,
    modifier: Modifier = ButtonStyles.plusButtonNumberInputModifier
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.then(modifier)
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = null, tint = Color.White)
    }
}

@Composable
fun LeftMinusButton(
    onClick: () -> Unit,
    modifier: Modifier = ButtonStyles.minusButtonNumberInputModifier
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.then(modifier)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_remove),
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Composable
fun CustomSearchButton(onClick: () -> Unit) {
    Icon(
        Icons.Default.Search,
        contentDescription = "Recherche",
        modifier = Modifier
            .padding(16.dp)
            .clickable(onClick = onClick),
        tint = Color.Blue // Personnalisez la couleur du bouton
    )
}
/* Preview */

@Preview
@Composable
fun LargePrimaryButtonPreview() {
    LargePrimaryButton(
        onClick = { },
    ) {
        LargePrimaryButtonText(
            buttonText = "Rechercher"
        )
    }
}

@Preview
@Composable
fun PlusPreview() {
    RightPlusButton(onClick = { })
}

@Preview
@Composable
fun MinusPreview() {
    LeftMinusButton(onClick = { })
}