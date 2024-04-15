package com.spanmobiles.ktor

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
class PostsServiceTest {

    @Test
    fun testGetPosts() {

        // Create a PostsService using the companion object's create function
        val postsService = PostsService.create()

        // Test the getPosts function and log the data
        runBlocking {
            val posts = postsService.getPosts()


            val limit = 10.coerceAtMost(posts.size)
            for (index in 0 until limit) {
                val post = posts[index]
                println("Post ${index + 1}: Title - ${post.title}, Body - ${post.body}")
            }

            // Verify that the correct number of posts is returned
            assertEquals(10, posts.size)
        }
    }

    @Test
    fun testCreatePost() {
        // Create a PostsService using the companion object's create function
        val postsService = PostsService.create()

        // Create a new post
        val postRequest = PostRequest("New Post Title", "New Post Body",100)

        // Post the new post
        runBlocking {
            val createdPost = postsService.createPost(postRequest)

            // Verify that the post was created successfully
            assertNotNull(createdPost)
            assertEquals(postRequest.title, createdPost?.title)
            assertEquals(postRequest.body, createdPost?.body)

            // Additional check: verify that the ID is not null (indicating a successful creation)
            assertNotNull(createdPost?.id)
        }
    }
}
