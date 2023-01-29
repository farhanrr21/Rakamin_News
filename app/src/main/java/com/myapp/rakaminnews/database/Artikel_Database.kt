package com.myapp.rakaminnews.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.myapp.rakaminnews.model.Article

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converter::class)
abstract class Artikel_Database : RoomDatabase() {

    abstract fun getArticleDao(): Dao

    companion object {
        @Volatile
        private var instance: Artikel_Database? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                Artikel_Database::class.java,
                "db_artikel.db"
            ).build()
    }
}