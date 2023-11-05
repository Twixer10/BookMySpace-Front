package fr.groupe4.bookmyspace_front_mobile.data.repositories

import fr.groupe4.bookmyspace_front_mobile.data.remote.ApiServices
import fr.groupe4.bookmyspace_front_mobile.data.remote.requests.CreateSpaceRequest
import fr.groupe4.bookmyspace_front_mobile.data.remote.requests.SearchRequest
import fr.groupe4.bookmyspace_front_mobile.data.remote.responses.CreateSpaceResponse
import fr.groupe4.bookmyspace_front_mobile.data.remote.responses.SearchResponse
import fr.groupe4.bookmyspace_front_mobile.data.remote.responses.SpaceResponse
import fr.groupe4.bookmyspace_front_mobile.domain.repositories.SpaceRepository
import retrofit2.Response

/**
 * Implementation of the SpaceRepository interface for managing space-related data operations.
 *
 * @param apiServices The API services used for communication with the backend.
 */
internal class SpaceRepositoryImpl(
    private val apiServices: ApiServices
) : SpaceRepository {

    /**
     * Asynchronously creates a new space by sending a request to the API service with the provided [space].
     *
     * @param space The [CreateSpaceRequest] object containing information for the new space.
     * @return A [Response] object containing the result of the API call, including the newly created space if successful.
     * @throws Exception if the API response is null or contains an error message.
     */
    override suspend fun createSpace(space: CreateSpaceRequest): Response<CreateSpaceResponse> {
        val response = apiServices.createSpace(space)
        return response ?: throw Exception(response.message())
    }

    /**
     * Search for spaces based on the provided search query.
     *
     * @param searchQuery The query with search criteria.
     * @return A response containing a list of search results.
     */
    override suspend fun searchSpace(searchQuery: SearchRequest): Response<List<SearchResponse>> {
        val response = apiServices.searchSpace(
            searchQuery.date,
            searchQuery.startHour,
            searchQuery.endHour,
            searchQuery.capacity
        )
        return response ?: throw Exception(response.message())
    }

    /**
     * Retrieve space information by its unique identifier.
     *
     * @param idSpace The unique identifier of the space.
     * @return A response containing the space information.
     */
    override suspend fun getSpaceById(idSpace: Int): Response<SpaceResponse> {
        val response = apiServices.getSpaceById(idSpace = idSpace)
        return response ?: throw Exception(response.message())
    }
}