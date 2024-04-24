package com.futuristicmobilieapps.androidcommons

import com.spanmobiles.ktor.KtorInstance
import com.spanmobiles.ktor.NetworkExceptionHandle
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor


 fun main() {
    val baseUrl = "https://reqres.in/api/users"
    val customInterceptor = createCustomInterceptor()
    val internetService = NetworkExceptionHandle()

    runBlocking {
        val result: HttpResponse? = makeApiCall(baseUrl, customInterceptor)
        internetService.handleNetworkResponse<KtorDataClass>(
            result,
            { success ->
                // Handle success case
                println("Success: ${success.data}")
            },
            { failure ->
                // Handle failure case
                println("Error: $failure")
            }
        )
    }
}

fun createCustomInterceptor(): Interceptor {
    return Interceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer your_token_here")
            .addHeader("Authentication", "LRKKjZTBHl3YoVNjuNmQI8k:XNCse6lwsu1lYxLNVsFBjpP3tqsXLv43FIDUXSe72uQ=")
            .addHeader("Timestamp", "Thursday, April 18, 2024 06:11:52:671 AM")
            .addHeader("RequestFrom", "ANDROID8868")
            .addHeader("Version", "1.0.1")
            .addHeader("Content-Type", "application/json")
            .addHeader("UniqueId", "51f2fdc16807d933")
            .addHeader("IpAddress", "115.240.214.170")
            .build()
        chain.proceed(request)
    }
}

suspend fun makeApiCall(
    apiUrl: String,
    customHeaderInterceptor: Interceptor
): HttpResponse? {

    val client = KtorInstance.createHttpClient(customHeaderInterceptor)
    return try {
        val response: HttpResponse = client.get(apiUrl)
        response
    } catch (e: Exception) {
        // Handle exception, return null in case of failure
        println("Exception occurred: ${e.message}")
        null
    }
}


