package com.ecommerce.catalogservice.service;


import org.springframework.stereotype.Service;

import com.ecommerce.catalogservice.entity.Book;
import com.ecommerce.catalogservice.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}