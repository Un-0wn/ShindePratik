package com.example.shindepratik.ends

import retrofit2.http.GET
import retrofit2.http.Query

interface Ends {

    @GET("users")
    suspend fun getUserResponse(
        @Query("page") page: Int = 1
    ): Dto

    @GET("unknown")
    suspend fun getUnknownResponse(
        @Query("page") page: Int = 1
    ): Unk

}