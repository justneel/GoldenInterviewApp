package com.neel.ia.repository

import com.neel.ia.api.ApiModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [ApiModule::class])
@InstallIn(SingletonComponent::class)
internal object RepositoryModule {
}