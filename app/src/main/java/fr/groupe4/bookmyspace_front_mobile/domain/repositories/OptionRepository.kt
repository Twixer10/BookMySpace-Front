package fr.groupe4.bookmyspace_front_mobile.domain.repositories

import fr.groupe4.bookmyspace_front_mobile.domain.models.Option
import kotlinx.coroutines.flow.Flow

interface OptionRepository {
    suspend fun getOptions(): Flow<List<Option>>
}