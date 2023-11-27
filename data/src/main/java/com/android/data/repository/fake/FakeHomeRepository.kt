package com.android.data.repository.fake

import JvmUnitTestFakeAssetManager
import com.android.common.network.Dispatcher
import com.android.common.network.LbtDispatchers
import com.android.data.model.Categories
import com.android.data.repository.HomeRepository
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

class FakeHomeRepository @Inject constructor(
    @Dispatcher(LbtDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val networkJson: Json,
    private val assets: FakeAssetManager = JvmUnitTestFakeAssetManager,
) : HomeRepository {
    override fun getHomeCategoriesList(): List<Categories> =
            assets.open(HOME_ASSET).use(networkJson::decodeFromStream)

    companion object {
        private const val HOME_ASSET = "home.json"
    }
}