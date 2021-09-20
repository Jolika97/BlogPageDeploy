package com.crystal.blogpagebe.repository;

import com.crystal.blogpagebe.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    @Query(value = "SELECT a " +
            "FROM Article a " +
            "WHERE a.author LIKE %?1% " +
            "AND a.tag LIKE %?2% " +
            "AND a.title LIKE %?3%" +
            "AND a.content LIKE %?4%" +
            "AND a.date LIKE %?5%")
    public List<Article> findByAuthor(String author, String tag, String title, String content, String date);

    @Query (value = "SELECT * FROM articles LIMIT ?1,3", nativeQuery = true)
    public List<Article> getArticlesPerPage(int page);
}
