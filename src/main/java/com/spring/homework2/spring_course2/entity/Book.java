package com.spring.homework2.spring_course2.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 17:43.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name ="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private long bookId;
    @Column(name = "bookName")
    private String bookName;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "authorId")
    private Author bookAuthor;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "genreId")
    private Genre bookGenre;


    /**
     * Instantiates a new Book.
     *
     * @param bookName   the book name
     * @param bookAuthor the book author
     * @param bookGenre  the book genre
     */
    public Book(String bookName, Author bookAuthor, Genre bookGenre) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
    }



}
