package com.example.marsphotos.network

import com.example.marsphotos.model.MarsPhoto
import retrofit2.http.GET

// retrofit client interface http method
interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos() : List<MarsPhoto>
}