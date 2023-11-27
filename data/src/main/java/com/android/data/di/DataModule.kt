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

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

//    @Provides
//    @Singleton
//    fun providesFakeAssetManager(
//        @ApplicationContext context: Context,
//    ): FakeAssetManager = FakeAssetManager(context.assets::open)


//    @Binds
//    fun bindsHomeRepository(
//        fakeHomeRepository: FakeHomeRepository,
//    ): HomeRepository
}