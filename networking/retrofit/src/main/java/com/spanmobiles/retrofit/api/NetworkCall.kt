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

class NetworkCall {

    fun <T> dotNetworkCall(result: Response<T>?): APIEvent<T> {
        return when {

            result?.code() == ERROR_CONNECTION_TIMEOUT -> {

                APIEvent.Error(errorMessage = "Connection timeout, please check your connection and try again.")
            }


            result?.code() == ERROR_INTERNAL_SERVER -> {

                APIEvent.Error(errorMessage = "Internal Server Error (500).")
            }


            result?.code() == ERROR_TOO_MANY_REQUESTS -> {

                APIEvent.Error(errorMessage = "Too Many Requests (429). Please try again later.")
            }


            result?.code() == ERROR_PAYLOAD_TOO_LARGE -> {

                APIEvent.Error(errorMessage = "Payload Too Large (413).")
            }


            result?.code() == ERROR_UNSUPPORTED_MEDIA_TYPE -> {

                APIEvent.Error(errorMessage = "Unsupported Media Type (415).")
            }


            result?.code() == ERROR_RANGE_NOT_SATISFIABLE -> {

                APIEvent.Error(errorMessage = "Range Not Satisfiable (416).")
            }


            result?.code() == ERROR_UPGRADE_REQUIRED -> {

                APIEvent.Error(errorMessage = "Upgrade Required (426).")
            }


            result?.code() == ERROR_SERVICE_UNAVAILABLE -> {

                APIEvent.Error(errorMessage = "Service Unavailable (503).")
            }


            result?.code() == ERROR_HTTP_VERSION_NOT_SUPPORTED -> {

                APIEvent.Error(errorMessage = "HTTP Version Not Supported (505).")
            }


            result?.code() == ERROR_DEFAULT -> {

                APIEvent.Error(errorMessage = "Something went wrong!")
            }


            result?.code() == ERROR_NOT_AUTHORIZED -> {

                APIEvent.Error(errorMessage = "Not Authorized!")
            }


            result?.code() == STATUS_OK && result.body() == null -> {

                APIEvent.Error(errorMessage = "No data found!")
            }


            result?.code() == STATUS_OK && result.body() != null -> {

                APIEvent.Success(data = result.body()!!, headers = result.headers())
            }


            else -> {

                APIEvent.Error(errorMessage = "Something went wrong!")
            }
        }
    }

}


sealed interface APIEvent<T> {

    data class Success<T>(val data: T, val headers: Headers) : APIEvent<T>

    data class Error<T>(val errorMessage: String = "Something went wrong!") : APIEvent<T>
}
