package com.spanmobiles.retrofit.api

import com.google.gson.GsonBuilder
import okhttp3.ConnectionPool
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object APIClient {

    fun getRetrofit(client: OkHttpClient.Builder, url: String): Retrofit {

        val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder()
            .baseUrl(url)
            .client(client.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun getOkHttpClient(
        headerInterceptor: Interceptor,
        loggingInterceptor: HttpLoggingInterceptor,
        connectionTimeOut: Long
    ): OkHttpClient.Builder =
        OkHttpClient.Builder().apply {
            readTimeout(connectionTimeOut, TimeUnit.SECONDS)
            callTimeout(connectionTimeOut, TimeUnit.SECONDS)
            connectTimeout(connectionTimeOut, TimeUnit.SECONDS)
            writeTimeout(connectionTimeOut, TimeUnit.SECONDS)
            retryOnConnectionFailure(false)
            connectionPool(ConnectionPool(connectionTimeOut.toInt(), connectionTimeOut, TimeUnit.SECONDS))
            addInterceptor(headerInterceptor)
            addInterceptor(loggingInterceptor)
        }

}
