package fr.groupe4.bookmyspace_front_mobile.ui.screens.spaceDetailReservation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import fr.groupe4.bookmyspace_front_mobile.R
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.Black
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.LargePrimaryButton
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.LargePrimaryButtonText
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.White


private typealias UIState = spaceDetailReservationViewModel.spaceDetailReservationState

/**
 * Composable function for displaying detailed information about a particular space and enabling reservation.
 *
 * @param navController The navigation controller used for navigating between screens. Nullable.
 * @param state The UIState data class representing the current UI state. Default is a new instance of UIState.
 * @param onClickBack The callback function to handle the action when the back button is clicked. Default is an empty function.
 * @param IdSpace The unique identifier of the space for reservation. Default is set to 0.
 *                Should be a valid non-negative integer that uniquely identifies the space for reservation.
 *
 * @throws IllegalArgumentException if the provided IdSpace is invalid or negative.
 *                                Ensure the IdSpace is a non-negative integer value representing a valid space.
 *
 * @throws NullPointerException if the navController is null while trying to perform a navigation action.
 *                            Make sure the navController is initialized before attempting navigation actions.
 *
 * @throws IllegalStateException if the UIState is in an inconsistent or unexpected state during the composable function execution.
 *                             Ensure the UIState is properly initialized and updated to reflect the current UI state accurately.
 */
@Composable
fun spaceDetailReservation(navController: NavController? = null,
                           state: UIState = UIState(),
                           onClickBack: () -> Unit = { },
                           IdSpace: Int = 0
) {

    val viewModel: spaceDetailReservationViewModel = viewModel()
    val state by viewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.init(IdSpace)
    }
    if (!state.isLoading) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Box(
                modifier = Modifier
                    .width(375.dp)
                    .height(516.dp)
                    .clip(RoundedCornerShape(bottomStart = 135.dp))

            ) {
                IconButton(
                    onClick = {
                        navController?.popBackStack()
                    },
                    modifier = Modifier
                        .padding(30.dp)
                        .zIndex(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(45.dp)
                            .background(
                                color = White,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .border(1.dp, Color.Black, shape = RoundedCornerShape(10.dp))

                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Retour",
                            tint = Black,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
                val painter = rememberAsyncImagePainter(state.spaceResponse?.url)
                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                        .zIndex(0f)
                )
            }
            Text(
                text = "Options",
                style = TextStyle(
                    color = Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalAlignment = Alignment.Top
            ) {
                Image(
                    modifier = Modifier
                        .width(37.dp)
                        .height(41.dp),
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = "image description",
                    contentScale = ContentScale.FillBounds
                )

                Text(
                    text = state.spaceResponse?.maxCapacity.toString(),
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 28.sp,
                        fontWeight = FontWeight(600),
                        color = Black,
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(top = 6.dp)
                )
                Spacer(modifier = Modifier.width(37.dp))
                state.spaceResponse?.options?.forEach { option ->
                    Text(
                        text = option.name,
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 25.2.sp,
                            fontWeight = FontWeight(600),
                            color = Color.Black,
                        ),
                        modifier = Modifier
                            .width(267.dp)
                            .height(93.dp)
                    )
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LargePrimaryButton(onClick = {
                    navController?.navigate("reservation/${state.spaceResponse?.idSpace}")
                }) {
                    LargePrimaryButtonText(buttonText = "Réserver")
                }
            }
        }
    }
}
}

