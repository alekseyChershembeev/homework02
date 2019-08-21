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

    @Autowired
    public GenreShell(GenreService genreService) {
        this.genreService = genreService;
    }


    @ShellMethod(value = "show all genres", key = "all-genres")
    public List<Genre> getAllGenres() {
        return genreService.getAll();
    }

    @Transactional
    @ShellMethod(value = "delete Genre by id", key = "delete-genre")
    public String deleteGenreById(@ShellOption(help = "id") String id) {

        final long longId = Long.parseLong(id);

        boolean isDelete = id.matches("\\d+") &&
                (genreService.getById(longId).getGenreId() == longId);

        if (isDelete) {
            genreService
                    .delete(longId);
            return "Genre was delete successfully";
        } else
            return "Genre doesn't exist";
    }

    @Transactional
    @ShellMethod(value = "update Genre", key = "update-genre")
    public String updateGenreById(@ShellOption(help = "id") String id,
                                  @ShellOption(help = "genre") String genreName) {
        long longId = 0;
        if (id.matches("\\d+"))
            longId = Long.parseLong(id);

        boolean isDelete =
                (genreService.getById(longId).getGenreId() == longId);

        if (isDelete && longId != 0) {
            genreService
                    .update(new Genre(longId, genreName));

            return "Genre was update successfully";
        } else
            return "Genre doesn't exist";
    }


}
