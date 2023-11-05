package fr.groupe4.bookmyspace_front_mobile.domain.models

import java.time.LocalDateTime

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val idRole: Int,
    val isExternal: Boolean,
)