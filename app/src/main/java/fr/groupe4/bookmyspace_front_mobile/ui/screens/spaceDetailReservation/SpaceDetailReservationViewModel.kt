package fr.groupe4.bookmyspace_front_mobile.ui.screens.spaceDetailReservation

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import fr.groupe4.bookmyspace_front_mobile.data.remote.requests.CreateSpaceRequest
import fr.groupe4.bookmyspace_front_mobile.data.remote.responses.SpaceResponse
import fr.groupe4.bookmyspace_front_mobile.domain.repositories.SpaceRepository
import fr.groupe4.bookmyspace_front_mobile.ui.core.ViewModel
import kotlinx.coroutines.launch
import org.koin.core.component.inject

/**
 * ViewModel class for managing data related to the space detail reservation screen.
 *
 * @param application The application instance used for accessing Android application resources.
 */

class spaceDetailReservationViewModel(application: Application) : ViewModel<spaceDetailReservationViewModel.spaceDetailReservationState>(spaceDetailReservationState(), application) {

    private val spaceRepository: SpaceRepository by inject()
    /**
     * Initializes the ViewModel with the provided space identifier.
     *
     * @param idSpace The unique identifier of the space to be retrieved and displayed.
     */
    fun init(idSpace: Int) {
        updateState { copy(isLoading = true) }

        viewModelScope.launch {
            try {
                val response = spaceRepository.getSpaceById(idSpace)

                if(response.isSuccessful) {
                    updateState { copy(spaceResponse = response.body()) }
                    updateState { copy(isLoading = false) }
                    Log.d("API SUCCESS", response.body().toString())

                } else {
                    updateState { copy(error = response.errorBody()?.string()) }
                }
            } catch (
                ex: Throwable
            ) {
                Log.d("ErrorApi", ex.toString())
                updateState { copy(error = ex.toString()) }
            }
        }
    }

    /**
     * Data class representing the state of the space detail reservation screen.
     *
     * @property isLoading Boolean representing whether data is currently being loaded.
     * @property spaceResponse The SpaceResponse object containing details of the retrieved space.
     * @property error String representing any error message that occurred during data retrieval.
     */
    data class spaceDetailReservationState(
        val isLoading: Boolean = true,
        val spaceResponse: SpaceResponse? = null,
        val error: String? = null
    )
}