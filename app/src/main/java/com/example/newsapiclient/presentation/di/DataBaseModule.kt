package com.example.newsapiclient.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.newsapiclient.data.db.ArticleDAO
import com.example.newsapiclient.data.db.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideNewsDatabase(app:Application):ArticleDatabase{
        return Room.databaseBuilder(app,ArticleDatabase::class.java,"news_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideNewDao(articleDatabase: ArticleDatabase):ArticleDAO{
        return articleDatabase.getArticleDao()
    }
}