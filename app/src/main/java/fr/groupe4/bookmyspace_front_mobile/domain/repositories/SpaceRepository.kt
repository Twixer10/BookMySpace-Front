package fr.groupe4.bookmyspace_front_mobile.domain.repositories

import fr.groupe4.bookmyspace_front_mobile.data.remote.requests.CreateSpaceRequest
import fr.groupe4.bookmyspace_front_mobile.data.remote.requests.SearchRequest
import fr.groupe4.bookmyspace_front_mobile.data.remote.responses.CreateSpaceResponse
import fr.groupe4.bookmyspace_front_mobile.data.remote.responses.SearchResponse
import fr.groupe4.bookmyspace_front_mobile.data.remote.responses.SpaceResponse
import retrofit2.Response

/**
 * Interface for managing space-related data operations.
 */
interface SpaceRepository {
    /**
     * Asynchronously creates a new space with the provided information.
     *
     * This function sends a request to create a new space using the provided [space] parameter.
     *
     * @param space The [CreateSpaceRequest] object containing information for the new space.
     * @return A [Response] object containing the result of the API call, including the newly created space if successful.
     */
    suspend fun createSpace(space: CreateSpaceRequest): Response<CreateSpaceResponse>

    /**
     * Retrieve space information by its unique identifier.
     *
     * @param idSpace The unique identifier of the space.
     * @return A response containing the space information.
     */
    suspend fun getSpaceById(idSpace: Int): Response<SpaceResponse>

    /**
     * Search for spaces based on the provided search query.
     *
     * @param searchQuery The query with search criteria.
     * @return A response containing a list of search results.
     */
    suspend fun searchSpace(searchQuery: SearchRequest): Response<List<SearchResponse>>
}