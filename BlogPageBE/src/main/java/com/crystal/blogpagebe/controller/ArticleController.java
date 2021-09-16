package com.crystal.blogpagebe.controller;

import com.crystal.blogpagebe.model.Article;
import com.crystal.blogpagebe.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    /*
    Return a list of all articles
    or
    search some based on one or combined filters
     */
    @GetMapping("/articles")
    public ResponseEntity findArticles(@RequestParam(value = "author", required = false, defaultValue = "") String author,
                                       @RequestParam(value = "tag", required = false, defaultValue = "") String tag,
                                       @RequestParam(value = "title", required = false, defaultValue = "") String title,
                                       @RequestParam(value = "content", required = false, defaultValue = "") String content,
                                       @RequestParam(value = "date", required = false, defaultValue = "") String date) {
        List<Article> articleList = articleService.findArticles(author, tag, title, content, date);
        if (!articleList.isEmpty())
            return new ResponseEntity(articleList, HttpStatus.OK);
        else
            return new ResponseEntity("No data found!.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/article/{articleId}")
    public ResponseEntity getArticleById(@PathVariable(value = "articleId") Integer articleId) {
        if (articleService.existsById(articleId)) {
            return new ResponseEntity(articleService.findArticleById(articleId), HttpStatus.OK);
        } else
            return new ResponseEntity("An article with this ID does not exist.", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/article/{articleId}")
    public ResponseEntity deleteArticleById(@PathVariable(value = "articleId") Integer articleId) {
        if (articleService.existsById(articleId)) {
            articleService.deleteArticle(articleId);
            return new ResponseEntity("Article successfully deleted", HttpStatus.OK);
        } else
            return new ResponseEntity("An article with this ID does not exist therefore it can not be deleted.", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/article")
    public ResponseEntity insertArticle(@RequestBody Article article) {
        if (!articleService.existsById(article.getId())) {
            articleService.insert(article);
            return new ResponseEntity("Added successfully.", HttpStatus.OK);
        } else
            return new ResponseEntity("Can't be added ,check if article exist.", HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/article/{articleId}")
    public ResponseEntity updateArticle(@PathVariable(value = "articleId") Integer articleId, @RequestBody Article article) {
        if (articleService.existsById(articleId)) {
            articleService.update(articleId, article);
            return new ResponseEntity("Updated successfully.", HttpStatus.OK);
        } else
            return new ResponseEntity("Can't be updated ,check if article exist.", HttpStatus.BAD_REQUEST);
    }

}
