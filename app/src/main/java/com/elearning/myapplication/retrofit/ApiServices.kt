package com.elearning.myapplication.retrofit

import com.elearning.myapplication.model.CharacterModel
import retrofit2.Call
import retrofit2.http.GET
import java.util.*

interface ApiServices {
    @GET("characters")
    fun characterAPI(): Call<Array<CharacterModel>>
}