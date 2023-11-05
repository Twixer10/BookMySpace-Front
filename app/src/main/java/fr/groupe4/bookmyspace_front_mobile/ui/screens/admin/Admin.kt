package fr.groupe4.bookmyspace_front_mobile.ui.screens.admin

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlin.reflect.typeOf

@Composable
fun AdminScreen(navController: NavController? = null) {
    Box(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(
            onClick = {
                navController?.navigate("createSpace")
            },
            modifier = Modifier
                .align(Alignment.BottomEnd).padding(16.dp),
        ) {
            Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
        }
    }

}

@Composable
@Preview
fun AdminScreenScreenPreview() {
    AdminScreen()
}