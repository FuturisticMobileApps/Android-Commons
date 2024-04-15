package com.spanmobiles.ktor

import kotlinx.serialization.Serializable

@Serializable
data class PostRequest(
    val body: String,
    val title: String,
    val userId: Int
)


@Serializable
data class PostResponse(
    val body: String ="",
    val title: String ="",
    val id: Int = 0,
    val userId: Int = 0
)