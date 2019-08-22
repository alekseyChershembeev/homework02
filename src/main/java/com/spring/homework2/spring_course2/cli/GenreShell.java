package com.spring.homework2.spring_course2.cli;

import com.spring.homework2.spring_course2.entity.Genre;
import com.spring.homework2.spring_course2.service.GenreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chershembeev_AE
 * Date: 20.08.2019
 * Time: 15:39.
 */
@ShellComponent
public class GenreShell {

    private GenreService genreService;

    /**
     * Instantiates a new Genre shell.
     *
     * @param genreService the genre service
     */
    @Autowired
    public GenreShell(GenreService genreService) {
        this.genreService = genreService;
    }


    /**
     * Gets all genres.
     *
     * @return the all genres
     */
    @ShellMethod(value = "show all genres", key = "all-genres")
    public List<Genre> getAllGenres() {
        return genreService.getAll();
    }

    /**
     * Delete genre by id string.
     *
     * @param id the id
     * @return the string
     */
    @Transactional
    @ShellMethod(value = "delete Genre by id", key = "delete-genre")
    public String deleteGenreById(@ShellOption(help = "id") String id) {

        if (id.matches("\\d+")) {
            if (genreService
                    .delete(Long.parseLong(id)))
                return "Genre was delete successfully";
        }
        return "Genre doesn't exist";
    }

    /**
     * Update genre by id string.
     *
     * @param id        the id
     * @param genreName the genre name
     * @return the string
     */
    @Transactional
    @ShellMethod(value = "update Genre", key = "update-genre")
    public String updateGenreById(@ShellOption(help = "id") String id,
                                  @ShellOption(help = "genre") String genreName) {
        long longId = 0;
        if (id.matches("\\d+"))
            longId = Long.parseLong(id);

        Genre genre = genreService.getById(longId);
        if (genre != null) {
            genreService
                    .update(new Genre(longId, genreName));

            return "Genre was update successfully";
        } else
            return "Genre doesn't exist";

    }

}
