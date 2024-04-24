package com.spanmobiles.ktor

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import kotlinx.serialization.json.Json
import okhttp3.Interceptor


object KtorInstance {

    fun createHttpClient(customHeaderInterceptor: Interceptor): HttpClient {
        return HttpClient(OkHttp) {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(JsonFeature) {
                serializer = KotlinxSerializer(Json {
                    ignoreUnknownKeys = true
                })
            }
            engine {
                config {
                    followRedirects(true)
                }
                addInterceptor(customHeaderInterceptor)
            }
        }
    }
}
