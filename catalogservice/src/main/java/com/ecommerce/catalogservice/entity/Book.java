package com.ecommerce.catalogservice.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bookname", nullable = false)
    private String bookname;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "quantity_available", nullable = false)
    private Integer quantityAvailable;

    @Column(name = "book_category")
    private String bookCategory;

    @Column(name = "author", nullable = false)
    private String author;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public String getBookname() {
        return bookname;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}