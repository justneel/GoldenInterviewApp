package com.neel.ia.api

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ApiModule {
    private const val baseUrl = "https://api.themoviedb.org/"

    @Provides
    @Singleton
    fun provideApi(): Api {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(AuthenticationInterceptor)

        val retrofit = Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient.build()).addConverterFactory(GsonConverterFactory.create()).baseUrl(
                baseUrl
            ).build()
        return retrofit.create(Api::class.java)
    }

}

object AuthenticationInterceptor: Interceptor {
    private const val v3ApiKey = "7fe0f4e34c27cc3709d550bfa03f81af"
    private const val apiKeyParam = "api_key"

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalReq = chain.request()
        val newUrl = originalReq.url().newBuilder().addQueryParameter(
            apiKeyParam, v3ApiKey
        ).build()
        return chain.proceed(originalReq.newBuilder().url(newUrl).build())
    }


}