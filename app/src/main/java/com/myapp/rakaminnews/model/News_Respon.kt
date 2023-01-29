package com.myapp.rakaminnews.model

data class News_Respon(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)
