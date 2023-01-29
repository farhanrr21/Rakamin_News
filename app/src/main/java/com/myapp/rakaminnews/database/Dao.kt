package com.myapp.rakaminnews.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.myapp.rakaminnews.model.Article

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(article: Article): Long

    @Query("SELECT * FROM artikel")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}