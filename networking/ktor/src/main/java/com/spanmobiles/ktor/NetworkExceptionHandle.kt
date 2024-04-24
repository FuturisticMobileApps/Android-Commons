package com.spanmobiles.ktor

import io.ktor.client.call.receive
import io.ktor.client.statement.*
import io.ktor.http.Headers
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentLength

class NetworkExceptionHandle {

    suspend fun <T> handleNetworkResponse(
        result: HttpResponse?,
        onResponseSuccess: (APIEvent.Success<T>) -> Unit,
        onResponseFailure: (APIEvent<T>) -> Unit,
    ) {
        try {
            when (result?.status) {
                HttpStatusCode.SwitchingProtocols -> {
                    onResponseFailure(
                        APIEvent.Error("Please check your network connection!"))
                }
                HttpStatusCode.OK -> {
                    if (result.contentLength() == 0L) {
                        onResponseFailure(APIEvent.Error("No data found!"))
                    } else {
                        val responseBody: String = result.receive()
                        onResponseSuccess(APIEvent.Success(responseBody as T, result.headers))
                    }
                }
                else -> {
                    onResponseFailure(handleHttpError(result))
                }
            }
        } catch (e: Exception) {
            onResponseFailure(APIEvent.Exception(e))
        }
    }

    private fun <T> handleHttpError(result: HttpResponse?): APIEvent<T> {
        return when (result?.status) {
            HttpStatusCode.RequestTimeout -> APIEvent.Error("Connection timeout, please check your connection and try again.")
            HttpStatusCode.InternalServerError -> APIEvent.Error("Internal Server Error (500).")
            HttpStatusCode.TooManyRequests -> APIEvent.Error("Too Many Requests (429). Please try again later.")
            HttpStatusCode.PayloadTooLarge -> APIEvent.Error("Payload Too Large (413).")
            HttpStatusCode.UnsupportedMediaType -> APIEvent.Error("Unsupported Media Type (415).")
            HttpStatusCode.UpgradeRequired -> APIEvent.Error("Upgrade Required (426).")
            HttpStatusCode.ServiceUnavailable -> APIEvent.Error("Service Unavailable (503).")
            HttpStatusCode.Unauthorized -> APIEvent.Error("Not Authorized!")
            null -> APIEvent.Error("Something went wrong!")
            else -> APIEvent.Error("Something went wrong!")
        }
    }
}



sealed interface APIEvent<T> {
    data class Success<T>(val data: T, val headers: Headers) : APIEvent<T>
    data class Error<T>(val errorMessage: String) : APIEvent<T>
    data class Exception<T>(val exception: kotlin.Exception) : APIEvent<T>
}






