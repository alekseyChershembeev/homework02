package ru.demo.homework02.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.demo.homework02.dao.AuthorDAO;
import ru.demo.homework02.dao.BookDAO;
import ru.demo.homework02.dao.GenreDAO;
import ru.demo.homework02.entity.*;

/**
 * Created by Chershembeev_AE
 * Date: 12.08.2019
 * Time: 16:59.
 */
@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {

    private final BookDAO bookDAO;
    private final AuthorDAO authorDAO;
    private final GenreDAO genreDAO;

    /**
     * Instantiates a new Library service.
     *
     * @param bookDAO   the book dao
     * @param authorDAO the author dao
     * @param genreDAO  the genre dao
     */
    @Autowired
    public LibraryServiceImpl(BookDAO bookDAO, AuthorDAO authorDAO, GenreDAO genreDAO) {
        this.bookDAO = bookDAO;
        this.authorDAO = authorDAO;
        this.genreDAO = genreDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getAllAuthorsNames() {
        return authorDAO.getAllAuthorsNames();
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getAllGenres() {
        return genreDAO.getAllGenres().stream()
                .map(Genre::getGenreName)
                .collect(Collectors.toList());
    }

    @NotNull
    @Override
    @Transactional(readOnly = true)
    public List<Book> getBooksByAuthorsName(String name) {

        return bookDAO.getAllBooks().stream()
                .flatMap(Stream::ofNullable)
                .filter((s) -> s.getAuthors() != null)
                .filter((s) -> s.getAuthors().getName() != null)
                .filter(s2 -> s2.getAuthors().getName().equals(name))
                .collect(Collectors.toList());

    }

    @NotNull
    @Override
    public boolean addNewGenre(Genre genre) {
        return genreDAO.addGenre(genre) == 1;

    }

    @NotNull
    @Override
    @Transactional()
    public boolean addNewBook(Book book) {
        book.setAuthors(authorDAO.addAuthorObject(book.getAuthors()));
        book.setGenre(genreDAO.addGenreObject(book.getGenre()));
        return bookDAO.addNewBook(book) == 1;
    }

    @NotNull
    @Override
    public boolean addNewAuthor(Author author) {
        return authorDAO.addNewAuthor(author) == 1;
    }

    @Override
    public boolean updateBookTitleById(Long id, String newTitle) {
        return bookDAO.updateBookTitleById(id, newTitle) == 1;
    }

    @Override
    public boolean deleteBookById(Long id) {
        return bookDAO.deleteBookById(id) == 1;
    }

    @Override
    public boolean deleteAuthorById(Long id) {
        return authorDAO.deleteAuthorById(id) == 1;
    }

    @NotNull
    @Override
    public boolean deleteGenre(String genreName) {

        AtomicBoolean b = new AtomicBoolean(false);
        genreDAO.getGenreByName(genreName).
                ifPresent((g) -> {
                    genreDAO.deleteGenre(g);
                    b.set(true);
                });
        return b.get();

    }

    @Override
    public boolean deleteAll() {
        return (genreDAO.deleteAll() + authorDAO.deleteAll() + bookDAO.deleteAll()) == 3;

    }
}
