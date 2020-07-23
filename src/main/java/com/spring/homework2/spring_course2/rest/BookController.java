package com.spring.homework2.spring_course2.rest;

import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.entity.BookDTO;
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
        return BookMapper.mapBookListToDTO(bookService.getAllBooks());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookDTO> getBook(@PathVariable(name = "id") String id) {

        Optional<Book> book = bookService.findBookById(id);

        return book.map(value -> new ResponseEntity<>(BookMapper.mapBookToDTO(book.get()), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/comments")
    public List<List<Comment>> showCommentsForBookId(@PathVariable(name = "id") String id) {
        return (bookService.getAllComments(id));
    }

    @PostMapping("/books")
    public ResponseEntity<BookDTO> addNewBook(@RequestBody Book book) {

//        Book book = bookService.addBook(BookMapper.(bookDto));

//        URI uri = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(bookService.addBook(book))
//                .toUri();
//
//        return ResponseEntity.created(uri).build();

//        Book book = BookMapper.bookDTOtoBook(bookDTO);

        BookDTO bookDTO = BookMapper.mapBookToDTO(book);
        return (bookService.addBook(book) != null)
                ? new ResponseEntity<>((bookDTO), HttpStatus.OK)
                : new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BookDTO> showBookForEdit(@PathVariable(name = "id") String id, @RequestBody Book book) {


        Optional<Book> newBook = bookService.updateBookById(id, book.getTitle(), book.getAuthors(), book.getGenre());

        return newBook.map(value -> new ResponseEntity<>(BookMapper.mapBookToDTO(newBook.get()), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));


    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable(name = "id") String id) {
        return bookService.deleteBookById(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();

    }




}
