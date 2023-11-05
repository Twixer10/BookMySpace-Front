package fr.groupe4.bookmyspace_front_mobile.data.remote.responses

/**
 * Data class representing a response for a booking.
 *
 * @param id The unique identifier of the booking.
 * @param url The URL of the booking, typically an image or resource location.
 * @param name The name or description associated with the booking.
 */
data class BookingResponse(
    val id: Int,
    val url: String,
    val name: String
)
