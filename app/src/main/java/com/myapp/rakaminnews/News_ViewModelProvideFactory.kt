package com.myapp.rakaminnews

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myapp.rakaminnews.repositori.News_Repository

class NewsViewModelProviderFactory(
    val app: Application,
    val newsRepository: News_Repository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return News_ViewModel(app, newsRepository) as T
    }
}