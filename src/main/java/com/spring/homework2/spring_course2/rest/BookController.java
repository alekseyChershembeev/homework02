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

    @GetMapping("/comment")
    public List<List<Comment>> showCommentsForBookId(@RequestParam(name = "id") String id) {
        return (bookService.getAllComments(id));
    }

    @PutMapping("/edit")
    public ResponseEntity<BookDTO> showBookForEdit(@RequestParam(name = "id") String id) {

        final Optional<Book> book = bookService
                .findBookById(id);

        return book.map(value -> new ResponseEntity<>(BookMapper.mapBookToDTO(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));


    }

    @PostMapping("/add")
    public ResponseEntity<Book> addNewBook(@RequestBody Book book) {
        return bookService
                .addBook(book) ?
                new ResponseEntity<>((book), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @DeleteMapping("/delete")
    public ResponseEntity deleteBook(@RequestParam(name = "id") String id) {
        return bookService.deleteBookById(id) ?
                new ResponseEntity(HttpStatus.OK) :
                new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
