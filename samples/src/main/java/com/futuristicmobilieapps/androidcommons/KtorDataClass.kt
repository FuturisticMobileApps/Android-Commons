package com.futuristicmobilieapps.androidcommons

import kotlinx.serialization.Serializable

@Serializable
data class KtorDataClass(
    val `data`: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)