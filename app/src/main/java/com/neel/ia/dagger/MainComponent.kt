package com.neel.ia.dagger

import com.neel.ia.api.ApiModule
import com.neel.ia.repository.RepositoryModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Component(modules = [AndroidInjectionModule::class, ApiModule::class, RepositoryModule::class, PicassoModule::class])
@EntryPoint
interface MainComponent {
}