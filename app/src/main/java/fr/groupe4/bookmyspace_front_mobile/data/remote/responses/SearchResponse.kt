package fr.groupe4.bookmyspace_front_mobile.data.remote.responses

/**
 * Data class representing a response for search results of a space.
 *
 * @property idSpace The unique identifier of the space.
 * @property name The name of the space.
 * @property description A description of the space.
 * @property maxCapacity The maximum capacity of the space.
 * @property typeSpace The type of space as a SpaceSearchTypeSpaceResponse.
 * @property options A string containing space options (purpose not specified).
 * @property url The URL associated with the space.
 */
data class SearchResponse(
    val idSpace: Int,
    val name: String,
    val description: String,
    val maxCapacity: Int,
    val typeSpace: SpaceSearchTypeSpaceResponse,
    val options: String,
    val url: String
)