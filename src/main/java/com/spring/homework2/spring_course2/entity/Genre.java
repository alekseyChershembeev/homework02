package com.spring.homework2.spring_course2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Chershembeev_AE
 * Date: 19.08.2019
 * Time: 18:53.
 */
@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "genres")

public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genreId")
    private long genreId;

    @Column(name = "genreName")
    private String genreName;

    public Genre(String genreName) {
        this.genreName = genreName;
    }
}
