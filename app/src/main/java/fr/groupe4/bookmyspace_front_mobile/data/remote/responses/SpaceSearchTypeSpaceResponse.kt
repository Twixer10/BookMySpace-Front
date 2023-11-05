package fr.groupe4.bookmyspace_front_mobile.data.remote.responses

/**
 * Data class representing the type of space in a search response.
 *
 * @property idTypeSpace The unique identifier of the space type.
 * @property name The name of the space type.
 * @property options A string containing space type options (purpose not specified).
 */
data class SpaceSearchTypeSpaceResponse(
    val idTypeSpace: Int,
    val name: String,
    val options: String
)