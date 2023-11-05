package fr.groupe4.bookmyspace_front_mobile.ui.screens.search

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import fr.groupe4.bookmyspace_front_mobile.data.remote.requests.SearchRequest
import fr.groupe4.bookmyspace_front_mobile.data.remote.responses.SearchResponse
import fr.groupe4.bookmyspace_front_mobile.domain.models.Option
import fr.groupe4.bookmyspace_front_mobile.domain.repositories.SpaceRepository
import fr.groupe4.bookmyspace_front_mobile.ui.core.ViewModel
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

/**
 * ViewModel class for managing the state and actions related to the search screen.
 *
 * @param application The Android application instance.
 */
class SearchViewModel(application: Application) : ViewModel<SearchState>(SearchState(), application), KoinComponent{
    private val spaceRepository: SpaceRepository by inject()

    /**
     * Handle user actions by updating the state based on the provided action.
     *
     * @param action The action to be processed.
     */
    fun handleActions(action: SearchAction){
        when(action){
            SearchAction.InitOptions -> {
                Log.d("Tag", "Init Options")
            }
            SearchAction.Search -> {
                Log.d("Tag", "Search Function")

                viewModelScope.launch {
                    try {
                        val response = spaceRepository.searchSpace(SearchRequest(
                            date = stateValue.date.toString(),
                            startHour = stateValue.startHour.toString() + ":00",
                            endHour = stateValue.endHour.toString() + ":00",
                            capacity = stateValue.capacity
                        ))

                        if(response.isSuccessful) {
                            updateState { copy(searchResponse = response.body()) }
                            Log.d("API_SUCCESS", response.body().toString())
                            updateState { copy(currentStep = 1) }
                        }else {
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
            SearchAction.IncrementPeopleNb -> {
                updateState { copy(capacity = capacity.plus(1)) }
                Log.d("Tag", stateValue.capacity.toString())
            }
            SearchAction.DecrementPeopleNb -> {
                if(stateValue.capacity  > 0){
                    updateState {
                        copy(capacity = capacity.minus(1))
                    }
                }
                Log.d("Tag", stateValue.capacity.toString())
            }
            is SearchAction.UpdateDate -> {
                updateState { copy(date = action.date) }
            }
            is SearchAction.UpdateStartHour -> {
                updateState { copy(startHour = action.date) }
            }
            is SearchAction.UpdateEndHour -> {
                updateState { copy(endHour = action.date) }
            }
            SearchAction.PingLogAction -> {
                Log.d("Tag", "Ping Log")
            }
            SearchAction.SetStepToInitalValue -> {
                updateState { copy(currentStep = 0) }
            }
            else -> {

            }
        }
    }

}

/**
 * Data class representing the state of the search screen.
 *
 * @param name The name (not used in the provided code).
 * @param isLoading Indicates if the screen is loading (not used in the provided code).
 * @param error An error message if an error occurs.
 * @param date The selected date for the search.
 * @param startHour The selected start hour for the search.
 * @param endHour The selected end hour for the search.
 * @param capacity The selected capacity for the search.
 * @param options List of options (not shown in the provided code).
 * @param searchResponse List of search results.
 * @param currentStep The current step in the search process.
 */
data class SearchState (
    val name: String = "",
    val isLoading: Boolean = true,
    val error: String? = null,
    val date: LocalDate? = null,
    val startHour: LocalTime? = null,
    val endHour: LocalTime? = null,
    val capacity: Int = 1,
    val options: List<Option> = emptyList(),
    val searchResponse: List<SearchResponse>? = emptyList(),
    val currentStep: Int = 0
)