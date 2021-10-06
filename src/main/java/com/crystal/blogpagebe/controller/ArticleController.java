package com.crystal.blogpagebe.controller;

import com.crystal.blogpagebe.model.Article;
import com.crystal.blogpagebe.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Woohoo!";
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
                                       @RequestParam(value = "date", required = false, defaultValue = "") String date,
                                       @RequestParam(value = "page", required = true, defaultValue = "0") int page) {
        List<Article> articleList = articleService.findArticles(author, tag, title, content, date, page);
        if (!articleList.isEmpty())
            return new ResponseEntity(articleList, HttpStatus.OK);
        else
            return new ResponseEntity("No data found!.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/articles/{articleId}")
    public ResponseEntity getArticleById(@PathVariable(value = "articleId") Integer articleId) {
        if (articleService.existsById(articleId)) {
            return new ResponseEntity(articleService.findArticleById(articleId), HttpStatus.OK);
        } else
            return new ResponseEntity("An article with this ID does not exist.", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/articles/{articleId}")
    public ResponseEntity deleteArticleById(@PathVariable(value = "articleId") Integer articleId) {
        if (articleService.existsById(articleId)) {
            articleService.deleteArticle(articleId);
            return new ResponseEntity("Article successfully deleted", HttpStatus.CREATED);
        } else
            return new ResponseEntity("An article with this ID does not exist therefore it can not be deleted.", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/articles")
    public ResponseEntity insertArticle(@Valid @RequestBody Article article) {
        if (!articleService.existsById(article.getId())) {
            articleService.insert(article);
            return new ResponseEntity("Added successfully.", HttpStatus.OK);
        } else
            return new ResponseEntity("Can't be added ,check if article exist.", HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/articles/{articleId}")
    public ResponseEntity updateArticle(@PathVariable(value = "articleId") Integer articleId, @Valid @RequestBody Article article) {
        if (articleService.existsById(articleId)) {
            articleService.update(articleId, article);
            return new ResponseEntity("Updated successfully.", HttpStatus.OK);
        } else
            return new ResponseEntity("Can't be updated ,check if article exist.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/articles/numbers")
    public ResponseEntity getNumberOfArticles() {
        return new ResponseEntity(articleService.getNoOfArticles(), HttpStatus.OK);
    }
}
