package com.dmentors.solar_city.di

import android.content.Context
import com.dmentors.solar_city.BuildConfig
import com.dmentors.solar_city.base.ApiErrorHandler
import com.dmentors.solar_city.base.AuthorizationKeyValueStorage
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class RetrofitCreatorModule {

    companion object {
        private const val DUMMY_URL = "http://solarcity.doubletapp.ru/api/"
        private const val TIMEOUT_SECONDS = 5L
        private const val LOGGING_INTERCEPTOR = "loggingInterceptor"
        private const val AUTH_HEADER_NAME = "Authentication"
        private const val AUTH_TOKEN_VALUE = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImxvZ2luIn0.tqliocnyFcvsrY__TIL7vGS6H-6oaPPe9XQ07Sr_lhs"
        private const val AUTH_TOKEN_PREFIX = "JWT "
    }

    @Provides
    @Singleton
    fun provideApiErrorHandler(
        context: Context,
        authorizationKeyValueStorage: AuthorizationKeyValueStorage
    ): ApiErrorHandler =
        ApiErrorHandler(
            context = context,
            authorizationKeyValueStorage = authorizationKeyValueStorage
        )

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(DUMMY_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(@Named(LOGGING_INTERCEPTOR) loggingInterceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .addInterceptor {
                return@addInterceptor it.proceed(
                    it.request()
                        .newBuilder()
                        .apply {
                            addAuthToken(this)
                        }
                        .build()
                )
            }
            .hostnameVerifier { hostname, session -> hostname.equals(session.peerHost, ignoreCase = true) }
            .build()

    private fun addAuthToken(requestBuilder: Request.Builder) {
            requestBuilder
                .addHeader(AUTH_HEADER_NAME, AUTH_TOKEN_PREFIX + AUTH_TOKEN_VALUE)
    }

    @Provides
    @Singleton
    @Named(LOGGING_INTERCEPTOR)
    fun provideLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor()
            .setLevel(
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            )
}