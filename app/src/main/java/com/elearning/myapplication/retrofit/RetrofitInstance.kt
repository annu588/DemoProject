package com.elearning.myapplication.retrofit

import android.content.Context
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance (val context: Context){

    private var retrofit: Retrofit?=null
    private var BaseUrl ="https://breakingbadapi.com/api/"
    private val httpClient = OkHttpClient.Builder().connectTimeout(30,TimeUnit.SECONDS)
        .readTimeout(20,TimeUnit.SECONDS)
        .writeTimeout(30,TimeUnit.SECONDS)
        .addInterceptor(
        Interceptor {
            val ongoing: Request.Builder = it.request().newBuilder()
            ongoing.addHeader("Accept", "application/json;versions=1")

             it.proceed(ongoing.build()) }).build()


  public fun getInstance ():Retrofit{
      if(retrofit==null){
          retrofit=Retrofit.Builder().baseUrl(BaseUrl).client(httpClient).addConverterFactory(GsonConverterFactory.create()).build()
      }
          return retrofit as Retrofit
  }
}