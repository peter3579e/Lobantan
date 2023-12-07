package com.android.data.repository.fake

import JvmUnitTestFakeAssetManager
import android.annotation.SuppressLint
import com.android.common.network.Dispatcher
import com.android.common.network.LbtDispatchers
import com.android.data.model.Categories
import com.android.data.repository.LbtNetworkDataSource
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

class FakeLbtNetworkDataSource @Inject constructor(
    @Dispatcher(LbtDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val networkJson: Json,
    @SuppressLint("VisibleForTests") private val assets: FakeAssetManager = JvmUnitTestFakeAssetManager,
) : LbtNetworkDataSource {
    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getHomeCategoriesList(): List<Categories> {
        return withContext(ioDispatcher) {
            assets.open(HOME_ASSET).use(networkJson::decodeFromStream)
        }
    }

    companion object {
        private const val HOME_ASSET = "home.json"
    }
}