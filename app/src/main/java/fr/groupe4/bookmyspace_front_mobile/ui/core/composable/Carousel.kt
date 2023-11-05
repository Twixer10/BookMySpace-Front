// theme/Carousel.kt
package fr.groupe4.bookmyspace_front_mobile.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import fr.groupe4.bookmyspace_front_mobile.data.remote.responses.BookingResponse

// Data structure representing a carousel item
data class CarouselItem(val imageResId: Int, val name: String)

/**
 * Composable representing a carousel of images with text.
 *
 * @param images List of items to display in the carousel.
 * @param modifier Modifier to customize the component.
 * @param navController NavController for navigation.
 */
@Composable
fun Carousel(
    images: List<BookingResponse>,
    modifier: Modifier = Modifier,
    navController: NavController? = null
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .height(270.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(images) { carouselItem ->
            Column(
                modifier = Modifier
                    .width(270.dp)
                    .clip(MaterialTheme.shapes.medium),
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = carouselItem.name,
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth(),
                    color = Color.Black,
                    fontSize = 20.sp
                )
                SubcomposeAsyncImage(
                    model = carouselItem.url, contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(270.dp)
                        .height(270.dp)
                        .clickable {
                            navController?.navigate(
                                "spacedetail/${carouselItem.id}"
                            )
                        },
                )
            }
        }
    }
}
