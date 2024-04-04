package com.spanmobiles.retrofit.api

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET


val headerInterceptor = Interceptor { chain ->
    val request = chain.request().newBuilder()
        // Add your headers here if needed
        .build()
    chain.proceed(request)
}

val loggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY // Set your desired log level here
}

// Define your connection timeout here (e.g., 1 minute)
val connectionTimeout = 1L // 1 minute

val clientBuilder = APIClient.getOkHttpClient(
    headerInterceptor,
    loggingInterceptor,
    connectionTimeout
)

val retrofit = APIClient.getRetrofit(clientBuilder, "https://simplifiedcoding.net/demos/")

interface SuperheroAPI {
    @GET("marvel") // making get request at marvel end-point
    fun getHeroes(): Call<List<Heros>>
}

data class Heros(
    var name: String,
    var realname: String,
    var team: String,
    var firstappearance: String,
    var createdby: String,
    var publisher: String,
    var imageurl: String,
    var bio: String
)

fun main() {
    // Your Retrofit setup code here

    val api = retrofit.create(SuperheroAPI::class.java)

    api.getHeroes().enqueue(object : Callback<List<Heros>> {

        override fun onResponse(call: Call<List<Heros>>, response: Response<List<Heros>>) {
            if (response.isSuccessful) {
                InternetService().handleNetworkResponse(
                    result = response,
                    onResponseFailure = { errorCode, errorMessage, _ ->
                        // Handle failure case
                        println("Error: $errorCode, Message: $errorMessage")
                    },
                    onResponseSuccess = { data, _, _ ->
                        // Handle success case
                        println("Success: $data")
                    }
                )
            }
        }

        override fun onFailure(call: Call<List<Heros>>, t: Throwable) {
            // Handle network call failure
            println("Network call failed: ${t.message}")
        }
    })

}

