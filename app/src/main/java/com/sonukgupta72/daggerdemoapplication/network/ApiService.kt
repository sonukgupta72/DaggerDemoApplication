package com.sonukgupta72.daggerdemoapplication.network

import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("12iu9o")
    fun getResponse(): Single<ResponseModel>
}