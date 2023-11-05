package fr.groupe4.bookmyspace_front_mobile.data.remote.requests

/**
 * Data class representing a search request with criteria to find spaces.
 *
 * @property date The selected date for the search (as a string).
 * @property startHour The selected start hour for the search (as a string).
 * @property endHour The selected end hour for the search (as a string).
 * @property capacity The desired capacity for the search.
 */
data class SearchRequest(
    val date: String,
    val startHour: String,
    val endHour: String,
    val capacity: Int
)