package com.crystal.blogpagebe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "articles")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "tag")
    private String tag;

    @NotNull
    @Column(name = "author")
    private String author;

    @NotNull
    @Column(name = "date")
    private String date;

    @NotNull
    @Column(name = "imgUrl")
    private String imageURL;

    @NotNull
    @Column(name = "content")
    private String content;

    @NotNull
    @Column(name = "dateTimestamp")
    private Timestamp dateTimestamp;

    public Article() {
    }

    public Article(int id, String title, String tag, String author, String date, String imageURL, String content, Timestamp dateTimestamp) {
        this.id = id;
        this.title = title;
        this.tag = tag;
        this.author = author;
        this.date = date;
        this.imageURL = imageURL;
        this.content = content;
        this.dateTimestamp = dateTimestamp;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDateTimestamp() {
        return dateTimestamp;
    }

    public void setDateTimestamp(Timestamp dateTimestamp) {
        this.dateTimestamp = dateTimestamp;
    }

}
