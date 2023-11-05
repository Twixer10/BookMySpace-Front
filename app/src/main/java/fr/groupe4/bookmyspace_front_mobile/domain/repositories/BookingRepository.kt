package fr.groupe4.bookmyspace_front_mobile.domain.repositories

import fr.groupe4.bookmyspace_front_mobile.data.remote.responses.BookingResponse
import retrofit2.Response

/**
 * Repository interface for fetching booking data.
 */
interface BookingRepository {

    /**
     * Fetches booking data by user ID.
     *
     * @param userId The unique identifier of the user to filter bookings.
     * @return A Response containing a list of BookingResponse objects.
     */
    suspend fun bookingbyUserId(userId: Int): Response<List<BookingResponse>>
}
