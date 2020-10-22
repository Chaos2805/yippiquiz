package com.example.yippiquiz.api

import android.graphics.Movie
import com.example.yippiquiz.model.Item
import com.example.yippiquiz.utils.Constants
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiServiceInterface {

//    @GET("id")
//    fun getItem(@Path("id") id:Int):Observable<Item>


    @GET("/get")
    fun getList() : Observable<List<Item>>

    companion object Factory {
        fun create(): ApiServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL1)
                .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}