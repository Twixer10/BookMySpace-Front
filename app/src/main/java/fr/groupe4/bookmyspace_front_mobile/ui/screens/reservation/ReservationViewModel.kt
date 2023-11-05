package fr.groupe4.bookmyspace_front_mobile.ui.screens.reservation

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import fr.groupe4.bookmyspace_front_mobile.data.remote.responses.SpaceResponse
import fr.groupe4.bookmyspace_front_mobile.domain.repositories.SpaceRepository
import org.koin.core.component.inject
import fr.groupe4.bookmyspace_front_mobile.ui.core.ViewModel
import kotlinx.coroutines.launch

/**
 * ViewModel class for managing data related to the reservation screen.
 *
 * @param application The application instance used for accessing Android application resources.
 */
class ReservationViewModel(application: Application) : ViewModel<ReservationViewModel.ReservationState>(ReservationState(), application) {

    private val spaceRepository: SpaceRepository by inject()
    /**
     * Initializes the ViewModel with the provided space identifier.
     *
     * @param idSpace The unique identifier of the space to be retrieved and reserved.
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
     * Data class representing the state of the reservation screen.
     *
     * @property isLoading Boolean representing whether data is currently being loaded.
     * @property spaceResponse The SpaceResponse object containing details of the retrieved space for reservation.
     * @property error String representing any error message that occurred during data retrieval.
     */
    data class ReservationState(
        val isLoading: Boolean = true,
        val spaceResponse: SpaceResponse? = null,
        val error: String? = null
    )
}