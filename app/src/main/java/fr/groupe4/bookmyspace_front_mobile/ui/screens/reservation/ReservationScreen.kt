package fr.groupe4.bookmyspace_front_mobile.ui.screens.reservation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.Blue
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.LargePrimaryButton
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.LargePrimaryButtonText
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.ScreenLargeTitleText
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.White
import fr.groupe4.bookmyspace_front_mobile.ui.screens.spaceDetailReservation.spaceDetailReservationViewModel


private typealias UIState = ReservationViewModel.ReservationState

/**
 * Composable function for displaying the reservation screen.
 *
 * @param navController The navigation controller used for navigating between screens.
 * @param IdSpace The unique identifier of the space for reservation.
 */

@Composable
fun ReservationScreen(
    navController: NavController? = null, IdSpace: Int,

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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Box(
                    modifier = Modifier
                        .width(375.dp)
                        .height(100.dp)
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
                                    color = Blue,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .border(1.dp, Color.Black, shape = RoundedCornerShape(10.dp))

                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Retour",
                                tint = White,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
            }

            item {
                ScreenLargeTitleText(buttonText = "Réservation")
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "ID de la salle :",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = state.spaceResponse?.idSpace.toString(),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp
                        )
                    )
                }
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "Nom de la salle :",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    state.spaceResponse?.name?.let {
                        Text(
                            text = it,
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 18.sp
                            )
                        )
                    }
                }
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "Heure :",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "15H-17H",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp
                        )
                    )
                }
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "Options :",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
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
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "Capacités :",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = state.spaceResponse?.maxCapacity.toString(),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp
                        )
                    )
                }
            }

            item {
                Text(
                    text = "Description",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            item {
                state.spaceResponse?.description?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp,
                        ),
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }



            item {
                LargePrimaryButton(
                    onClick = { navController?.navigate("homes") },
                ) {
                    LargePrimaryButtonText(buttonText = "Confirmer")
                }
            }




        }
    }
}



