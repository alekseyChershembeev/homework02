package com.spring.homework2.spring_course2.rest;

import com.spring.homework2.spring_course2.entity.Book;
import com.spring.homework2.spring_course2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by Chershembeev_AE
 * Date: 05.09.2019
 * Time: 12:54.
 */

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/")
    public String listPage(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "list";
    }
    @GetMapping("/edit")
    public String editPage(@RequestParam(name ="id") String id, Model model) {
        model.addAttribute("book", bookService.findBookById(id).orElseThrow(IllegalArgumentException::new));
        return "edit";
    }

//    @PostMapping("/add")
//    public String addNewBook(@RequestParam(name = "author") String authors,
//                             @RequestParam(name = "title") String title,
//                             @RequestParam(name = "genre") String genre,
//                             Model model) {
//
//        if (bookService.addBook(new Book(title, authors, genre))) {
//            model.addAttribute("addResult");
//        }
//        return "edit";
//    }



}
