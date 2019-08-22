package com.spring.homework2.spring_course2.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 18:53.
 */
@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId")
    private long commentId;
    @Column(name = "commentText")
    private String commentText;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "bookId",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Book book;


    /**
     * Instantiates a new Comment.
     *
     * @param commentText the comment text
     * @param id          the id
     */
    public Comment(String commentText, long id) {
        this.commentText = commentText;
        this.book = new Book();
    }
}
