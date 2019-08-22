package com.spring.homework2.spring_course2.cli;

import com.spring.homework2.spring_course2.entity.Author;
import com.spring.homework2.spring_course2.service.AuthorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chershembeev_AE
 * Date: 20.08.2019
 * Time: 15:38.
 */

@ShellComponent
public class AuthorShell {

    @Autowired
    public AuthorShell(AuthorService authorService) {
        this.authorService = authorService;
    }

    private AuthorService authorService;

    @ShellMethod(value = "show all Authors names", key = "all-authors")
    public List<Author> getAllAuthorsNames() {
        return authorService.getAll();
    }

    @ShellMethod(value = "add new Author", key = "add-author")
    public String addNewAuthor(@ShellOption(help = "author name") String authorName,
                               @ShellOption(help = "author last name") String authorLastName) {

        if (authorService
                .create(new Author(authorName, authorLastName)) > 0)
            return "New Author was added successfully";
        else
            return "Author already exist ";
    }

    @Transactional
    @ShellMethod(value = "delete Author by id", key = "delete-author")
    public String deleteAuthorById(@ShellOption(help = "id") String id) {

        if (id.matches("\\d+")) {
            authorService
                    .delete(Long.parseLong(id));
            return "Author was delete successfully";
        } else
            return "Author doesn't exist";
    }

    @ShellMethod(value = "update Author by id", key = "update-author")

    public String updateAuthorById(@ShellOption(help = "id") String id,
                                   @ShellOption(help = "name") String name,
                                   @ShellOption(help = "lastName") String lastName) {
        long longId = 0;
        if (id.matches("\\d+"))
            longId = Long.parseLong(id);

        boolean isDelete =
                (authorService.getById(longId).getAuthorId() == longId);

        if (isDelete && longId != 0) {
            authorService
                    .update(new Author(longId, name, lastName));
            return "Author was update successfully";
        } else
            return "Author doesn't exist";
    }


    @ShellMethod(value = "get Author by id", key = "get-author")
    public String getAuthorById(@ShellOption(help = "id") String id) {

        Author author;
        long longId;

        if (id.matches("\\d+")) {
            longId = Long.parseLong(id);
            author = authorService.getById(longId);
            if (author != null) {
                authorService
                        .delete(longId);
                return author.toString();
            }
        }

        return "Author doesn't exist";
    }


}
