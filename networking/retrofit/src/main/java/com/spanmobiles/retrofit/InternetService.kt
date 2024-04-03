package com.spanmobiles.retrofit

import com.sun.tools.javac.util.Context
import retrofit2.Response
import retrofit2.http.Headers


class InternetService(private val context: Context) {
    companion object {
        const val ERROR_NO_CONNECTION = 101
        const val ERROR_CONNECTION_TIMEOUT = 504
        const val ERROR_INTERNAL_SERVER = 500
        const val ERROR_TOO_MANY_REQUESTS = 429
        const val ERROR_PAYLOAD_TOO_LARGE = 413
        const val ERROR_UNSUPPORTED_MEDIA_TYPE = 415
        const val ERROR_RANGE_NOT_SATISFIABLE = 416
        const val ERROR_UPGRADE_REQUIRED = 426
        const val ERROR_SERVICE_UNAVAILABLE = 503
        const val ERROR_HTTP_VERSION_NOT_SUPPORTED = 505
        const val ERROR_DEFAULT = 0
        const val ERROR_NOT_AUTHORIZED = 401
        const val STATUS_OK = 200
    }

    fun <T> dotNetworkCall(
        result: Response<T>?,
        onResponseFailure: ((Int, String?, T?) -> Unit)? = null,
        onResponseSuccess: (T, String?, Headers) -> Unit
    ) {
        when {

            !context.isOnline() || result?.code() == ERROR_NO_CONNECTION -> {
                onResponseFailure?.invoke(ERROR_NO_CONNECTION, "Please check your network connection!", null)
            }

            result?.code() == ERROR_CONNECTION_TIMEOUT -> {
                onResponseFailure?.invoke(ERROR_CONNECTION_TIMEOUT,
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

            }
        }
    }
}


