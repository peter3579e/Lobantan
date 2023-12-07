package com.android.data.repository.fake

import com.android.common.network.Dispatcher
import com.android.common.network.LbtDispatchers
import com.android.data.model.Categories
import com.android.data.model.Product
import com.android.data.repository.HomeRepository
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class FakeHomeRepository @Inject constructor(
    @Dispatcher(LbtDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val datasource: FakeLbtNetworkDataSource,
) : HomeRepository {
    override fun getCategories(): Flow<List<Categories>> = flow {
        emit(
            datasource.getHomeCategoriesList().map {
                Categories(
                    id = it.id,
                    title = it.title,
                    products = it.products
                )
            }
        )
    }.flowOn(ioDispatcher)

    override fun getProducts(id: String): Flow<List<Product>> {
        return getCategories().map {
            it.first { product -> product.id == id }.products
        }
    }

    /** TODO
     * Synchronizes the local database backing the repository with the network.
     * Returns if the sync was successful or not.
     *  override suspend fun syncWith(synchronizer: Synchronizer) = true
     */
}