package com.ismin.android

import android.icu.text.CaseMap
import retrofit2.Call
import retrofit2.http.*;

interface BookService {

    @GET("books")
    fun getAllBooks(): Call<ArrayList<Book>>

    @POST("books")
    fun createBook(@Body() book: Book): Call<Book>

    @DELETE("/books/{title}")//gu
    fun deleteBook(@Path("title") title:String):Call<Book>//gu
}