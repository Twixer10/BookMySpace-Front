package fr.groupe4.bookmyspace_front_mobile.data.remote.responses

data class CreateSpaceResponse(
    val idSpace: Int,
    val name: String,
    val url: String,
    val description: String,
    val maxCapacity: Number,
    val idTypeSpace: Int
)