package com.crystal.blogpagebe.service;

import com.crystal.blogpagebe.model.Article;
import com.crystal.blogpagebe.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

//    @Autowired
//    ArticlePaginationRepository articlePaginationRepository;

    public List<Article> findArticles(String author, String tag, String title, String content, String date) {
        return articleRepository.findByAuthor(author, tag, title, content, date);
    }

    public Article findArticleById(int articleId) {
        return articleRepository.getById(articleId);
    }

    public void deleteArticle(int articleId) {
        articleRepository.deleteById(articleId);
    }

    public Article insert(Article article) {
        return articleRepository.saveAndFlush(article);
    }

    public Article update(int articleId, Article article) {
        Article existingArticle = articleRepository.getById(articleId);

        if (article.getTitle() != null)
            existingArticle.setTitle(article.getTitle());
        if (article.getTag() != null)
            existingArticle.setTag(article.getTag());
        if (article.getAuthor() != null)
            existingArticle.setAuthor(article.getAuthor());
        if (article.getDate() != null)
            existingArticle.setDate(article.getDate());
        if (article.getDateTimestamp() != null)
            existingArticle.setDateTimestamp(article.getDateTimestamp());
        if (article.getImageURL() != null)
            existingArticle.setImageURL(article.getImageURL());
        if (article.getContent() != null)
            existingArticle.setContent(article.getContent());

        return articleRepository.saveAndFlush(existingArticle);
    }

    public boolean existsById(int articleId) {
        return articleRepository.existsById(articleId);
    }

    public List<Article> findArticlesByPage(int page) {
       return articleRepository.getArticlesPerPage(page);
    }
}
