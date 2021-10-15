package com.crystal.blogpagebe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table(name = "articles")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;

    @NotBlank
    @Size(min = 1, max = 255)
    @Column(name = "tag")
    private String tag;

    @NotBlank
    @Size(min = 1, max = 255)
    @Column(name = "author")
    private String author;

    @NotBlank
    @Size(min = 1, max = 255)
    @Column(name = "date")
    private String date;

    @NotBlank
    @Size(min = 1, max = 1000)
    @Column(name = "imgurl")
    private String imageURL;

    @NotBlank
    @Size(min = 1, max = 10000)
    @Column(name = "content")
    private String content;

    @NotBlank
    @Size(min = 1, max = 255)
    private String saying;

    @Column(name = "datetimestamp")
    private Timestamp dateTimestamp;

}
