package com.myapp.rakaminnews.repositori

import com.myapp.rakaminnews.api.Retrofit
import com.myapp.rakaminnews.database.Artikel_Database
import com.myapp.rakaminnews.model.Article

class News_Repository(val db: Artikel_Database) {

        suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
            Retrofit.api.getNews(countryCode, pageNumber)

        suspend fun update(article: Article) = db.getArticleDao().update(article)

        fun getSavedNews() = db.getArticleDao().getAllArticles()

        suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}