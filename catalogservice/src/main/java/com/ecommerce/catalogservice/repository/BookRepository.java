package com.ecommerce.catalogservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.catalogservice.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}