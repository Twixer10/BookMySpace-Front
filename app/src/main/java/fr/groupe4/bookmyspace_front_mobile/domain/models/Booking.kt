package fr.groupe4.bookmyspace_front_mobile.domain.models

import java.time.LocalDateTime

data class Booking(
    val idBooking: Int,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
    val idSpace: Int,
    val created: LocalDateTime,
    val createdBy: User
)
