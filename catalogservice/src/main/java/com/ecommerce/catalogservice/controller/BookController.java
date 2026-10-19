package com.ecommerce.catalogservice.controller;


import org.springframework.web.bind.annotation.*;

import com.ecommerce.catalogservice.entity.Book;
import com.ecommerce.catalogservice.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}