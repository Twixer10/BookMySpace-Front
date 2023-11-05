package fr.groupe4.bookmyspace_front_mobile.data.remote.requests

data class CreateSpaceRequest(
    val name: String,
    val description: String,
    val maxCapacity: Number,
    val url: String,
    val idTypeSpace: Int,
    val options: List<Int> = listOfNotNull(1, 2, 3)
)