package com.elearning.myapplication.retrofit

import com.elearning.myapplication.model.CharacterModel
import retrofit2.Call
import retrofit2.http.GET
import java.util.*

interface ApiServices {
    @GET("client_id=238b4f660e017edb7dadc5ce864869daf68441fd58249d0f773123334f11ef9f`")
     fun imageapi(): Call<Objects>

    @GET("characters")
    fun characterAPI(): Call<Array<CharacterModel>>
}