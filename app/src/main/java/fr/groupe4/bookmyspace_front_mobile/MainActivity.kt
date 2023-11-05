package fr.groupe4.bookmyspace_front_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import fr.groupe4.bookmyspace_front_mobile.ui.core.theme.BookMySpaceTheme
import fr.groupe4.bookmyspace_front_mobile.ui.screens.Screen
import fr.groupe4.bookmyspace_front_mobile.ui.core.composable.MainScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Screen.init()
            BookMySpaceTheme {
                MainScreen()
            }
        }
    }
}