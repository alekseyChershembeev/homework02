package com.spring.homework2.spring_course2.cli;

import com.spring.homework2.spring_course2.entity.Author;
import com.spring.homework2.spring_course2.service.AuthorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
 * Created by Chershembeev_AE
 * Date: 20.08.2019
 * Time: 15:38.
 */
@ShellComponent
public class AuthorShell {

    /**
     * Instantiates a new Author shell.
     *
     * @param authorService the author service
     */
    @Autowired
    public AuthorShell(AuthorService authorService) {
        this.authorService = authorService;
    }

    private AuthorService authorService;

    /**
     * Gets all authors names.
     *
     * @return the all authors names
     */
    @ShellMethod(value = "show all Authors names", key = "all-authors")
    public List<Author> getAllAuthorsNames() {
        return authorService.findAll();
    }

    /**
     * Add new author string.
     *
     * @param authorName     the author name
     * @param authorLastName the author last name
     * @return the string
     */
    @ShellMethod(value = "add new Author", key = "add-author")
    public String addNewAuthor(@ShellOption(help = "author name") String authorName,
                               @ShellOption(help = "author last name") String authorLastName) {
        if (authorService
                .save(new Author(authorName, authorLastName)) > 0)
            return "New Author was added successfully";
        else
            return "Author already exist ";
    }

    /**
     * Delete author by id string.
     *
     * @param id the id
     * @return the string
     */
    @Transactional
    @ShellMethod(value = "delete Author by id", key = "delete-author")
    public String deleteAuthorById(@ShellOption(help = "id") String id) {

        long idLong;
        if (id.matches("\\d+")) {
            idLong = (Long.parseLong(id));
            if (authorService
                    .deleteAuthorById(idLong))
                return "Author was delete successfully";
        }
        return "Author doesn't exist";
    }

    /**
     * Update author by id string.
     *
     * @param id       the id
     * @param name     the name
     * @param lastName the last name
     * @return the string
     */
    @ShellMethod(value = "update Author by id", key = "update-author")

    public String updateAuthorById(@ShellOption(help = "id") String id,
                                   @ShellOption(help = "name") String name,
                                   @ShellOption(help = "lastName") String lastName) {
        boolean b = false;
        long longId = 0;
        if (id.matches("\\d+"))
            longId = Long.parseLong(id);

        if (authorService
                .save(new Author(longId, name, lastName)) > 0)
            return "Author was update successfully";
        else
            return "Author doesn't exist";
    }


    /**
     * Gets author by id.
     *
     * @param id the id
     * @return the author by id
     */
    @ShellMethod(value = "get Author by id", key = "get-author")
    public String getAuthorById(@ShellOption(help = "id") String id) {

        long longId;

        if (id.matches("\\d+")) {
            longId = Long.parseLong(id);

            Optional<Author> author = authorService.getById(longId);
            if (author.isPresent()) {
                return author.toString();
            }
        }
        return "Author doesn't exist";
    }


}
