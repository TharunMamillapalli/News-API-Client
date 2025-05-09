package com.example.newsapiclient.data.repository.dataSourceImpl

import com.example.newsapiclient.data.db.ArticleDAO
import com.example.newsapiclient.data.model.Article
import com.example.newsapiclient.data.repository.dataSource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(
    private val articleDAO: ArticleDAO
):NewsLocalDataSource {
    override suspend fun saveArticleToDB(article: Article) {
        return articleDAO.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return articleDAO.getAllArticles()
    }

    override suspend fun deleteArticlesFromDB(article: Article) {
        return articleDAO.deleteArticle(article)
    }
}