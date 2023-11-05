package fr.groupe4.bookmyspace_front_mobile.data.repositories

import fr.groupe4.bookmyspace_front_mobile.data.remote.ApiServices
import fr.groupe4.bookmyspace_front_mobile.data.remote.responses.BookingResponse
import fr.groupe4.bookmyspace_front_mobile.domain.repositories.BookingRepository
import retrofit2.Response

/**
 * Implementation of the BookingRepository interface for fetching booking data.
 *
 * @param apiServices The API service used for making requests.
 */
internal class BookingRepositoryImpl(
    private val apiServices: ApiServices
) : BookingRepository {

    /**
     * Fetches booking data by user ID from the API.
     *
     * @param userId The unique identifier of the user to filter bookings.
     * @return A Response containing a list of BookingResponse objects.
     */
    override suspend fun bookingbyUserId(userId: Int): Response<List<BookingResponse>> {
        val response = apiServices.bookingbyid(userId)
        return response ?: throw Exception(response.message())
    }
}
