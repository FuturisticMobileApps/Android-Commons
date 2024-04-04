package com.spanmobiles.retrofit.api

import com.spanmobiles.retrofit.api.NetworkResponse.ERROR_CONNECTION_TIMEOUT
import com.spanmobiles.retrofit.api.NetworkResponse.ERROR_DEFAULT
import com.spanmobiles.retrofit.api.NetworkResponse.ERROR_HTTP_VERSION_NOT_SUPPORTED
import com.spanmobiles.retrofit.api.NetworkResponse.ERROR_INTERNAL_SERVER
import com.spanmobiles.retrofit.api.NetworkResponse.ERROR_NOT_AUTHORIZED
import com.spanmobiles.retrofit.api.NetworkResponse.ERROR_PAYLOAD_TOO_LARGE
import com.spanmobiles.retrofit.api.NetworkResponse.ERROR_RANGE_NOT_SATISFIABLE
import com.spanmobiles.retrofit.api.NetworkResponse.ERROR_SERVICE_UNAVAILABLE
import com.spanmobiles.retrofit.api.NetworkResponse.ERROR_TOO_MANY_REQUESTS
import com.spanmobiles.retrofit.api.NetworkResponse.ERROR_UNSUPPORTED_MEDIA_TYPE
import com.spanmobiles.retrofit.api.NetworkResponse.ERROR_UPGRADE_REQUIRED
import com.spanmobiles.retrofit.api.NetworkResponse.STATUS_OK
import okhttp3.Headers
import retrofit2.Response


class InternetService {

    fun <T> handleNetworkResponse(
        result: Response<T>?,
        onResponseFailure: ((Int, String?, T?) -> Unit)? = null,
        onResponseSuccess: (T, String?, okhttp3.Headers) -> Unit
    ) {

        when {

            result?.code() == ERROR_CONNECTION_TIMEOUT -> {
                onResponseFailure?.invoke(
                    ERROR_CONNECTION_TIMEOUT,
                    "Connection timeout, please check your connection and try again.",
                    null
                )
            }

            result?.code() == ERROR_INTERNAL_SERVER -> {
                onResponseFailure?.invoke(
                    ERROR_INTERNAL_SERVER,
                    "Internal Server Error (500).",
                    null
                )
            }

            result?.code() == ERROR_TOO_MANY_REQUESTS -> {
                onResponseFailure?.invoke(
                    ERROR_TOO_MANY_REQUESTS,
                    "Too Many Requests (429). Please try again later.",
                    null
                )
            }

            result?.code() == ERROR_PAYLOAD_TOO_LARGE -> {
                onResponseFailure?.invoke(
                    ERROR_PAYLOAD_TOO_LARGE,
                    "Payload Too Large (413).",
                    null
                )
            }

            result?.code() == ERROR_UNSUPPORTED_MEDIA_TYPE -> {
                onResponseFailure?.invoke(
                    ERROR_UNSUPPORTED_MEDIA_TYPE,
                    "Unsupported Media Type (415).",
                    null
                )
            }

            result?.code() == ERROR_RANGE_NOT_SATISFIABLE -> {
                onResponseFailure?.invoke(
                    ERROR_RANGE_NOT_SATISFIABLE,
                    "Range Not Satisfiable (416).",
                    null
                )
            }

            result?.code() == ERROR_UPGRADE_REQUIRED -> {
                onResponseFailure?.invoke(
                    ERROR_UPGRADE_REQUIRED,
                    "Upgrade Required (426).",
                    null
                )
            }

            result?.code() == ERROR_SERVICE_UNAVAILABLE -> {
                onResponseFailure?.invoke(
                    ERROR_SERVICE_UNAVAILABLE,
                    "Service Unavailable (503).",
                    null
                )
            }

            result?.code() == ERROR_HTTP_VERSION_NOT_SUPPORTED -> {
                onResponseFailure?.invoke(
                    ERROR_HTTP_VERSION_NOT_SUPPORTED,
                    "HTTP Version Not Supported (505).",
                    null
                )
            }

            result == null -> {
                onResponseFailure?.invoke(
                    ERROR_DEFAULT,
                    "Something went wrong!",
                    null
                )
            }

            result.code() == ERROR_NOT_AUTHORIZED -> {
                onResponseFailure?.invoke(
                    ERROR_NOT_AUTHORIZED,
                    "Not Authorized!",
                    null
                )
            }

            result.isSuccessful && result.body() == null -> {
                onResponseFailure?.invoke(
                    result.code(),
                    "No data found!",
                    null
                )
            }

            result.isSuccessful && result.code() == STATUS_OK && result.body() != null -> {
                onResponseSuccess.invoke(result.body()!!, result.message(), result.headers())
            }
        }
    }
}

sealed interface APIEvent<T> {

    data  class Success<T>(val data: T,val headers: Headers) : APIEvent<T>

    data class Error<T>(
        val exception: NetworkException = NetworkException(errorMessage = "Something went wrong!"),
        val data : T? = null
    ) : APIEvent<T>
}



