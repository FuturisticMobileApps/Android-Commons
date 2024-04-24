package com.futuristicmobilieapps.androidcommons

import kotlinx.serialization.Serializable

@Serializable
data class Support(
    val text: String,
    val url: String
)