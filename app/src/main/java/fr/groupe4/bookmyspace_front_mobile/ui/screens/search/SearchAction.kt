package fr.groupe4.bookmyspace_front_mobile.ui.screens.search

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

/**
 * Sealed interface representing different actions in the search screen.
 */
sealed interface SearchAction{
    data object InitOptions: SearchAction
    data object Search: SearchAction
    data object IncrementPeopleNb: SearchAction
    data object DecrementPeopleNb: SearchAction
    data class UpdateDate(val date: LocalDate) : SearchAction
    data class UpdateStartHour(val date: LocalTime) : SearchAction
    data class UpdateEndHour(val date: LocalTime) : SearchAction
    data object PingLogAction: SearchAction
    data object SetStepToInitalValue: SearchAction
}