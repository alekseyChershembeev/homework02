package ru.demo.homework02.dao;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.demo.homework02.entity.Author;
import ru.demo.homework02.entity.Book;
import ru.demo.homework02.entity.Genre;



@JdbcTest
@RunWith(SpringRunner.class)
@Import(BookDaoImpl.class)
public class BookDaoImplTest {

    @Autowired
    BookDaoImpl bookDAO;



    private Author author;
    private Genre genre;
    private Book book;

    @Before
    public void setUp() {
        author = new Author();
        author.setId(2L);
        author.setName("Л.Толстой");

        genre= new Genre(2L,"роман");
        book = new Book();
        book.setAuthors(author);
        book.setGenre(genre);
        book.setTitle("Тест1");


    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAllTitles() {
        System.out.println(bookDAO.getAllTitles());
    }

    @Test
    public void getAllBooks() {
        System.out.println(bookDAO.getAllBooks());
    }

    @Test
    public void getBooksByAuthor() {
        System.out.println(bookDAO.getBooksByAuthor(author) );

    }

    @Test
    public void getBooksByTitle() {

        String s = "Восточный экспресс";
        System.out.println(bookDAO.getBooksByTitle(s));

    }

    @Test
    public void getBookById() {
        System.out.println(bookDAO.getBookById(2L));
    }

    @Test
    public void addNewBook() {
        Integer i = bookDAO.addNewBook(book);
        System.out.println(i);
    }

    @Test
    public void updateBookTitleById() {
        System.out.println(bookDAO.updateBookTitleById(2L,"newTitle"));

    }

    @Test
    public void deleteBookById() {
        System.out.println(bookDAO.deleteBookById(3L));
    }

    @Test
    public void deleteAll() {


        System.out.println(bookDAO.getAllTitles());
        System.out.println(bookDAO.deleteAll());
        System.out.println(bookDAO.getAllTitles());




    }
}