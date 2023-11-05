package fr.groupe4.bookmyspace_front_mobile.domain.models

data class Space(
    val id: Int,
    val name: String,
    val description: String,
    val url: String,
    val maxCapacity: Number,
    val idTypeSpace: TypeSpace,
    val options: List<Option>
)