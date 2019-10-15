package com.spring.homework2.spring_course2.rest;

import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.entity.Comment;
import com.spring.homework2.spring_course2.service.BookService;
import com.spring.homework2.spring_course2.util.BookMapper;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by Chershembeev_AE
 * Date: 05.09.2019
 * Time: 12:54.
 */

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<BookDTO> listPage() {
        System.out.println(bookService.getAllBooks());
        return BookMapper.mapBookListToDTO(bookService.getAllBooks());
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addNewBook(@RequestBody Book book) {
        return bookService
                .addBook(book) ?
                new ResponseEntity<>((book), HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/books{id}")
    public ResponseEntity<BookDTO> showBookForEdit(@PathVariable(name = "id") String id) {

        final Optional<Book> book = bookService
                .findBookById(id);

        return book.map(value -> new ResponseEntity<>(BookMapper.mapBookToDTO(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable(name = "id") String id) {
        return bookService.deleteBookById(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();

    }

    @GetMapping("/comments{id}")
    public List<List<Comment>> showCommentsForBookId(@PathVariable(name = "id") String id) {
        return (bookService.getAllComments(id));
    }









}
