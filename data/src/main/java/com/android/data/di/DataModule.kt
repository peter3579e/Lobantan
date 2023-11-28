package com.android.data.di

import android.content.Context
import com.android.data.repository.HomeRepository
import com.android.data.repository.fake.FakeAssetManager
import com.android.data.repository.fake.FakeHomeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.serialization.json.Json

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindsHomeRepository(
        fakeHomeRepository: FakeHomeRepository,
    ): HomeRepository

    companion object {
        @Provides
        @Singleton
        fun providesNetworkJson(): Json = Json {
            ignoreUnknownKeys = true
        }

        @Provides
        @Singleton
        fun providesFakeAssetManager(
            @ApplicationContext context: Context,
        ): FakeAssetManager = FakeAssetManager(context.assets::open)
    }
}