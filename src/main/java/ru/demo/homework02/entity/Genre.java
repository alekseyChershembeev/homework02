package ru.demo.homework02.entity;

import lombok.Data;

/**
 * Created by Chershembeev_AE
 * Date: 06.08.2019
 * Time: 11:00.
 */
@Data
public class Genre {
    private Long id;
    private String genreName;

    /**
     * Instantiates a new Genre.
     *
     * @param genreName the genre name
     */
    public Genre(String genreName) {
        this.genreName = genreName;
    }

    /**
     * Instantiates a new Genre.
     */
    public Genre() {
    }

    /**
     * Instantiates a new Genre.
     *
     * @param id        the id
     * @param genreName the genre name
     */
    public Genre(Long id, String genreName) {
        this.id = id;
        this.genreName = genreName;
    }
}
