package fr.groupe4.bookmyspace_front_mobile.data.remote

import fr.groupe4.bookmyspace_front_mobile.data.remote.requests.CreateSpaceRequest
import fr.groupe4.bookmyspace_front_mobile.data.remote.responses.BookingResponse
import fr.groupe4.bookmyspace_front_mobile.data.remote.responses.CreateSpaceResponse
import fr.groupe4.bookmyspace_front_mobile.data.remote.responses.SearchResponse
import fr.groupe4.bookmyspace_front_mobile.data.remote.responses.SpaceResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiServices {
    @POST("/space")
    suspend fun createSpace(@Body createSpace: CreateSpaceRequest): Response<CreateSpaceResponse>

    @GET("/space")
    suspend fun getSpaceById(
        @Query("idSpace") idSpace : Int,
    ): Response<SpaceResponse>

    /**
     * Makes a GET request to retrieve a list of booking responses filtered by user ID.
     *
     * @param userId The unique identifier of the user to filter bookings.
     * @return A Response containing a list of BookingResponse objects.
     */
    @GET("/booking")
    suspend fun bookingbyid(
        @Query("userId") userId: Int
    ): Response<List<BookingResponse>>


    /**
     * API route for searching spaces.
     *
     * @param date The selected date for the search.
     * @param startHour The selected start hour for the search.
     * @param endHour The selected end hour for the search.
     * @param capacity The desired capacity for the search.
     * @return A response containing a list of search results (spaces).
     */
    @GET("/space/searchSpace")
    suspend fun searchSpace(
        @Query("date") date : String,
        @Query("startHour") startHour : String,
        @Query("endHour") endHour : String,
        @Query("capacity") capacity : Int,
    ): Response<List<SearchResponse>>
}