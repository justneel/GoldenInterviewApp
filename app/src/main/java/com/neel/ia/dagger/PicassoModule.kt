package com.neel.ia.dagger

import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object PicassoModule {

    @Provides
    fun providePicasso(): Picasso {
        return Picasso.get()
    }
}