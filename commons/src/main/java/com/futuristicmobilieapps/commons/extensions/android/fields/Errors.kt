package com.futuristicmobilieapps.commons.extensions.android.fields

sealed interface Error

enum class EmailError() : Error {
    Empty,
    Invalid
}

/*
sealed interface Result<out D, out E : CommonError> {
    data class Success<out D, out E : CommonError>(val data: D) : Result<D, E>
    data class Error<out D, out E : CommonError>(val data: D) : Result<D, E>
}
*/
