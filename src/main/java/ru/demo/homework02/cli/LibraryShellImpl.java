package ru.demo.homework02.cli;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.table.AutoSizeConstraints;
import org.springframework.shell.table.SimpleHorizontalAligner;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModel;
import org.springframework.shell.table.TableModelBuilder;
import ru.demo.homework02.entity.Author;
import ru.demo.homework02.entity.Book;
import ru.demo.homework02.entity.Genre;
import ru.demo.homework02.service.LibraryServiceImpl;

import static org.springframework.shell.table.CellMatchers.table;

/**
 * Created by Chershembeev_AE
 * Date: 12.08.2019
 * Time: 16:58.
 */
@ShellComponent
public class LibraryShellImpl implements LibraryShell {

    private LibraryServiceImpl libraryService;

    /**
     * Instantiates a new Library shell.
     *
     * @param libraryService the library service
     */
    @Autowired
    public LibraryShellImpl(LibraryServiceImpl libraryService) {
        this.libraryService = libraryService;

    }

    @Override
    @ShellMethod(value = "show all books", key = "all-books")
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @Override
    @ShellMethod(value = "show all Authors names", key = "all-names")
    public List<String> getAllAuthorsNames() {
        return libraryService.getAllAuthorsNames();
    }

    @Override
    @ShellMethod(value = "show all genres", key = "all-genres")
    public List<String> getAllGenres() {
        return libraryService.getAllGenres();
    }

    @Override
    @ShellMethod(value = "show all books by Author name", key = "all-books-name")
    public String getBooksByAuthorsName(@ShellOption(help = "author name") String name) {
        return getTableFromList(libraryService.getBooksByAuthorsName(name));
    }


    @Override
    @ShellMethod(value = "add new Genre", key = "add-genre")
    public String addNewGenre(@ShellOption(help = "add new Genre") String genre) {
        if (libraryService.addNewGenre(new Genre(genre)))
            return "New Genre was added successfully";
        else
            return "Genre already exist ";
    }

    @Override
    @ShellMethod(value = "add new Book", key = "add-book")
    public String addNewBook(@ShellOption(help = "genre") String genre,
                             @ShellOption(help = "title") String title,
                             @ShellOption(help = "author") String author) {
        final boolean isAddBook = libraryService
                .addNewBook(new Book(
                        new Author(author),
                        title,
                        new Genre(genre)
                ));

        if (isAddBook)
            return "New Book was added successfully";
        else
            return "Book already exist ";
    }

    @Override
    @ShellMethod(value = "add new Author", key = "add-author")
    public String addNewAuthor(String author) {
        final boolean isAddBook = libraryService
                .addNewAuthor(new Author(author));

        if (isAddBook)
            return "New Author was added successfully";
        else
            return "Author already exist ";
    }

    @Override
    @ShellMethod(value = "update Book by id", key = "update-book")
    public String updateBookTitleById(@ShellOption(help = "id") String id,
                                      @ShellOption(help = "title") String newTitle) {
        boolean isUpdate = id.matches("\\d+");

        if (isUpdate)
            isUpdate = libraryService
                    .updateBookTitleById(Long.valueOf(id), newTitle);

        if (isUpdate)
            return "Book was update successfully";
        else
            return "Book doesn't exist";
    }

    @Override
    @ShellMethod(value = "delete Book by id", key = "delete-book")
    public String deleteBookById(@ShellOption(help = "id") String id) {

        boolean isDelete = id.matches("\\d+");

        if (isDelete)
            isDelete = libraryService
                    .deleteBookById(Long.valueOf(id));

        if (isDelete)
            return "Book was delete successfully";
        else
            return "Book doesn't exist";
    }

    @Override
    @ShellMethod(value = "delete Author by id", key = "delete-author")
    public String deleteAuthorById(@ShellOption(help = "id") String id) {

        boolean isDelete = id.matches("\\d+");

        if (isDelete)
            isDelete = libraryService
                    .deleteAuthorById(Long.valueOf(id));

        if (isDelete)
            return "Author was delete successfully";
        else
            return "Author doesn't exist";
    }

    @Override
    @ShellMethod(value = "delete Genre by genreName", key = "delete-genre")
    public String deleteGenre(@ShellOption(help = "genreName") String genreName) {
        final boolean isDelete = libraryService
                .deleteGenre(genreName);

        if (isDelete)
            return "Genre was delete successfully";
        else
            return "Genre doesn't exist";
    }

    @Override
    @ShellMethod(value = "delete all", key = "delete-all")
    public String deleteAll() {

        final boolean isDelete = libraryService
                .deleteAll();

        if (isDelete)
            return "Delete all was successfully";
        else
            return "Delete all wasn't successfully";

    }

    @Override

    public String getTableFromList(List<Book> books) {
        TableModelBuilder<String> modelBuilder = new TableModelBuilder<>();
        modelBuilder.addRow()
                .addValue("Book id")
                .addValue("Author(s)")
                .addValue("Title")
                .addValue("Genre");

        books.forEach(book -> modelBuilder.addRow()
                .addValue(String.valueOf(book.getId()))
                .addValue(book.getAuthors().getName())
                .addValue(book.getTitle() + " ")
                .addValue(book.getGenre().getGenreName()));
        TableModel model = modelBuilder.build();

        return new TableBuilder(model)
                .on(table())
                .addSizer(new AutoSizeConstraints())
                .addAligner(SimpleHorizontalAligner.left)
                .build()
                .render(400);

    }
}
