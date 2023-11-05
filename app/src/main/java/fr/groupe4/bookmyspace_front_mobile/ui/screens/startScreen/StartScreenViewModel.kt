package fr.groupe4.bookmyspace_front_mobile.ui.screens.startScreen

import android.app.Application
import fr.groupe4.bookmyspace_front_mobile.ui.core.ViewModel
/**
 * ViewModel class for managing data related to the start screen.
 *
 * @param application The application instance used for accessing Android application resources.
 */
class StartScreenViewModel(application: Application) : ViewModel<StartScreenState>(StartScreenState(), application) {

    init {
        updateState { copy(isLoading = false) }
    }

}
/**
 * Data class representing the state of the start screen.
 *
 * @property name String representing the name associated with the start screen. Default is an empty string.
 * @property isLoading Boolean representing whether data is currently being loaded. Default is true.
 * @property error String representing any error message that occurred during data retrieval. Nullable.
 */
data class StartScreenState(
    val name: String = "",
    val isLoading: Boolean = true,
    val error: String? = null
)
