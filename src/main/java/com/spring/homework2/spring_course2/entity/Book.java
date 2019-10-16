package com.spring.homework2.spring_course2.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.GeneratedValue;

/**
 * Created by Chershembeev_AE
 * Date: 30.08.2019
 * Time: 14:49.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "books")
public class Book {

    @Id
    private String id;
    private String title;
    private String author;
    private String genre;
//    @JsonProperty("comments")
//    private List<Comment>comments;

//    public Book(String title, String author, String genre) {
//        this.title = title;
//        this.author = author;
//        this.genre = genre;
//    }
//
//    public Book(String id, String title, String author, String genre) {
//        this.id = id;
//        this.title = title;
//        this.author = author;
//        this.genre = genre;
//    }

}
