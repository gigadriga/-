package com.example.networkapp.data

import com.example.networkapp.model.Post
import com.example.networkapp.network.PostApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostRepository {

    private val postApi = PostApi.create()

    fun getPosts(): Flow<List<Post>> {
        return flow {
            val posts = postApi.getPosts()
            emit(posts)
        }
    }

    fun updatePost(post: Post): Flow<Post> {
        return flow {
            val updatedPost = postApi.updatePost(post.id, post)
            emit(updatedPost)
        }
    }
}
