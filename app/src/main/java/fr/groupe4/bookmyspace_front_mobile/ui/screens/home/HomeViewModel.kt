package fr.groupe4.bookmyspace_front_mobile.ui.screens.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import fr.groupe4.bookmyspace_front_mobile.data.remote.responses.BookingResponse
import fr.groupe4.bookmyspace_front_mobile.domain.repositories.BookingRepository
import fr.groupe4.bookmyspace_front_mobile.ui.core.ViewModel
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * ViewModel for the Home screen.
 *
 * @param application The application context.
 */
class HomeViewModel(application: Application) :
    ViewModel<BookingState>(BookingState(), application), KoinComponent {

    private val bookingRepository: BookingRepository by inject()

    /**
     * Fetches booking data and updates the state.
     */
    fun getBooking() {
        updateState { copy(isLoading = true) }
        Log.d("Tag", "getBooking")

        viewModelScope.launch {
            try {
                val response = bookingRepository.bookingbyUserId(
                    userId = stateValue.userId,
                )

                if (response.isSuccessful) {
                    updateState { copy(bookingResponse = response.body()) }
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

/**
 * Represents the state of the Home screen.
 *
 * @property name The name, if needed.
 * @property isLoading Indicates if data is loading.
 * @property error The error message, if an error occurs.
 * @property bookingResponse The list of booking responses.
 * @property userId The user ID to use for data fetching.
 */
data class BookingState(
    val name: String = "",
    val isLoading: Boolean = true,
    val error: String? = null,
    val bookingResponse: List<BookingResponse>? = emptyList(),
    val userId: Int = 1,
)
