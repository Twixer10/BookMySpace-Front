package fr.groupe4.bookmyspace_front_mobile.data.remote.responses

import fr.groupe4.bookmyspace_front_mobile.domain.models.Option
/**
 * Data class representing the response received for space information.
 *
 * @property idSpace The unique identifier for the space.
 *                   Should be a non-negative integer value that uniquely identifies the space.
 * @property name The name associated with the space.
 * @property url The URL representing the image associated with the space.
 * @property description The description providing details about the space.
 * @property maxCapacity The maximum capacity of the space.
 *                      Should be a numerical value representing the maximum occupancy of the space.
 * @property idTypeSpace The unique identifier representing the type of space.
 *                      Should be a non-negative integer value that identifies the type of the space.
 * @property options The list of options available for the space.
 *                  Make sure the list is not null and contains valid Option objects.
 */
data class SpaceResponse(
    val idSpace: Int,
    val name: String,
    val url: String,
    val description: String,
    val maxCapacity: Number,
    val idTypeSpace: Int,
    val options: List<Option>

)