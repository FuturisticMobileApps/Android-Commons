package com.spanmobiles.retrofit

import com.google.gson.GsonBuilder
import com.sun.tools.javac.util.Context
import okhttp3.ConnectionPool
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url
import java.util.concurrent.TimeUnit

object APIClient {

    fun getRetrofit(client: OkHttpClient.Builder,url: Url): Retrofit {

        val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder()
            .baseUrl(url.toString())
            .client(client.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun getOkHttpClient(
        context: Context,apiInterceptor: Interceptor ): OkHttpClient.Builder =
        OkHttpClient.Builder().apply {
            readTimeout(15, TimeUnit.MINUTES)
            callTimeout(15, TimeUnit.MINUTES)
            connectTimeout(15, TimeUnit.MINUTES)
            writeTimeout(15, TimeUnit.MINUTES)
            retryOnConnectionFailure(false)
            connectionPool(ConnectionPool(15, 15, TimeUnit.MINUTES))
            addInterceptor(apiInterceptor)
            addInterceptor(apiInterceptor)
        }

}
