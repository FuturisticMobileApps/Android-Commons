package com.spanmobiles.retrofit.api

object NetworkResponse {
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

data class NetworkException(
    val resultCode: Int? = null,
    val request: String? = null,
    val headers: String? = null,
    val errorMessage: String? = "Something went wrong!",
    val isNoConnection : Boolean = false,
    val forceLogOut : Boolean = false
)