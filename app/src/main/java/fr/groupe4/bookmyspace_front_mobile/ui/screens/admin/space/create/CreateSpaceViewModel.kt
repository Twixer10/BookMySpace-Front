package fr.groupe4.bookmyspace_front_mobile.ui.screens.admin.space.create

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import fr.groupe4.bookmyspace_front_mobile.data.remote.requests.CreateSpaceRequest
import fr.groupe4.bookmyspace_front_mobile.data.remote.responses.CreateSpaceResponse
import fr.groupe4.bookmyspace_front_mobile.domain.repositories.SpaceRepository
import fr.groupe4.bookmyspace_front_mobile.ui.core.ViewModel
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class CreateSpaceViewModel(application: Application) :
    ViewModel<CreateSpaceState>(CreateSpaceState(), application), KoinComponent {

    private val spaceRepository: SpaceRepository by inject()

    init {
        //TODO
    }

    fun nextStep() {
        updateState { copy(currentStep = currentStep + 1) }
        updateState { copy(startControl = false) }
        if(state.value.currentStep == 5) {
            createSpace()
            Log.d("KOUKOU", "createSpace: " + state.value.createSpaceRequest)
        }
    }

    fun previousStep() {
        updateState { copy(currentStep = currentStep - 1) }
        updateState { copy(startControl = false) }
    }

    fun setStartControl(bool: Boolean) {
        updateState { copy(startControl = bool) }
    }

    fun updateSpaceName(name: String) {
        updateState { copy(spaceName = name) }
    }

    fun updateSpaceDescription(description: String) {
        updateState { copy(spaceDescription = description) }
    }

    //Convert string to int
    fun updateSpaceMaxCapacity(maxCapacity: String) {
        updateState { copy(spaceMaxCapacity = maxCapacity.toInt()) }
    }

    fun updateSpaceType(type: String) {
        updateState { copy(spaceType = type) }
    }

    fun updateSpaceUrl(it: String) {
        updateState { copy(spaceUrl = it) }
    }

    /**
     * Initiates the process of creating a new space.
     *
     * This function updates the state to indicate that the creation process is loading and
     * makes an API request to create a new space using the provided information. It handles
     * successful and unsuccessful API responses and updates the state accordingly.
     */
    fun createSpace() {
        updateState { copy(isLoading = true) }

        viewModelScope.launch {
            try {
                val response = spaceRepository.createSpace(CreateSpaceRequest(
                    name = state.value.spaceName,
                    description = state.value.spaceDescription,
                    maxCapacity = state.value.spaceMaxCapacity,
                    idTypeSpace = 1,
                    url = state.value.spaceUrl
                ))

                if(response.isSuccessful) {
                    updateState { copy(createSpaceRequest = response.body()) }
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

}

data class CreateSpaceState(
    val name: String = "",
    val isLoading: Boolean = true,
    val error: String? = null,
    val currentStep: Int = 0,
    val startControl: Boolean = false,
    val spaceName: String = "",
    val spaceDescription: String = "",
    val spaceMaxCapacity: Int = 0,
    val spaceType: String = "",
    val spaceUrl: String = "",
    val createSpaceRequest: CreateSpaceResponse? = null
)
